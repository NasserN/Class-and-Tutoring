/*
 * Huffman.java
 *
 * Created on May 21, 2007, 1:01 PM
 */
package huffman;

import java.util.*;
import java.io.*;

/**
 *
 * @author pbladek
 */
public class Huffman {

    public static final int CHARMAX = 128;
    public static final byte CHARBITS = 7;
    public static final short CHARBITMAX = 128;
    private HuffmanTree<Character> theTree;
    private byte[] byteArray;
    private SortedMap<Character, String> keyMap;
    private SortedMap<String, Character> codeMap;
    HuffmanChar[] charCountArray;
    byte[] saveDataArray;
    private String directory;

    /**
     * Creates a new instance of Main
     */
    public Huffman() {
        
    }
    public void test(){
        System.out.println("Worked");
    }

    /*
     * encode
     * @param fileName the file to encode
     */
    public void encode(File file) throws IOException {
        // YOUR CODE HERE
        if (file.getParent() != null) {
            directory = file.getParent() + "\\";
        } else {
            directory = "";
        }
        int[] counter = new int[CHARMAX];
        Scanner in = null;
        List<HuffmanChar> countList = new ArrayList<>();
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File open error");
            return;
        }
        while (in.hasNextLine()) {
            String line = in.nextLine();
            line += "\n";
            for (int i = 0; i < line.length(); i++) {
                Character a = line.charAt(i);
                counter[a]++;
            }

        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > 0) {
                countList.add(new HuffmanChar((char) i, counter[i]));
            }
        }

        charCountArray = countList.toArray(new HuffmanChar[countList.size()]);
        countList = null;
        Arrays.sort(charCountArray);
        theTree = new HuffmanTree<>(charCountArray);
        keyMap = theTree.getCodeMap();
        codeMap = theTree.getKeyMap();
        System.out.println("" + keyMap);
        System.out.println("" + codeMap);
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File open error");
        }
        ArrayList<Byte> arrayList = new ArrayList<>();
        String output = "";
        String outputByte = null;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            line += "\n";
            for (int i = 0; i < line.length(); i++) {
                output += keyMap.get(line.charAt(i));
                while (output.length() > CHARBITS) {
                    outputByte = output.substring(0, 8);
                    output = output.substring(8);
                    arrayList.add((byte) Integer.parseInt(outputByte, 2));
                }
            }

        }
        while (output.length() != 0 && output.length() < 8) {
            output += "0";
        }
        arrayList.add((byte) Integer.parseInt(outputByte));
        byteArray = toArray(arrayList);
        arrayList = null;
        System.out.println(byteArray.length);
        File hufFile = writeEncodedFile(byteArray, file.getName());
        System.out.println("HUF = " + Double.toString(hufFile.length()));
        System.out.println("TXT = " + Double.toString(file.length()));
        double ratio = ((double)hufFile.length() / file.length() * 100.0);
        System.out.println("Compression ratio: " + String.format("%.2f%%", ratio));
        writeKeyFile(file.getName());
    }

    public HuffmanData<Character>[] decodeCode(String fileName)
            throws FileNotFoundException, IOException, ClassNotFoundException {
        HuffmanData<Character>[] allHuffman = null;
        try (ObjectInputStream readObject = new ObjectInputStream(new FileInputStream(fileName))) {
            allHuffman = new HuffmanChar[readObject.available() / 3];
            byte[] recoverData = new byte[readObject.available()];
            readObject.readFully(recoverData);
            for (int i = 0; i < recoverData.length; i += 3) {
                byte[] holdThree = {recoverData[i], recoverData[i + 1], recoverData[i + 2]};
                HuffmanChar temp = new HuffmanChar(holdThree);
                allHuffman[i / 3] = temp;
            }
            readObject.close();
        }
        return allHuffman;
    }

    /*
     * decode
     * @param inFileName the file to decode
     */
    public void decode(File inFile) throws FileNotFoundException, IOException, ClassNotFoundException {
        String inFileName = inFile.getName();
        if (inFile.getParent() != null) {
            directory = inFile.getParent() + "\\";
        } else {
            directory = "";
        }
        String outFileName = directory + inFile.getName().replaceAll("\\Q.huf\\E", ".txt");
        File outFile = new File(outFileName);

        if (codeMap == null) {
            theTree = new HuffmanTree<>(decodeCode(
                    directory + inFileName.replaceAll("\\Q.huf\\E", ".cod")));
        }
        codeMap = theTree.getKeyMap();
        ObjectInputStream readObj = new ObjectInputStream(new FileInputStream(inFile));
        PrintWriter out = new PrintWriter(outFile);
        int counter = 0;
        saveDataArray = new byte[(int) inFile.length()];
        int size = 0;
        while (readObj.available() != 0) {
            byte[] temp = new byte[readObj.available()];

            readObj.readFully(temp);
            size += temp.length;
            for (int i = 0; i < temp.length; i++) {
                saveDataArray[counter * 1024 + i] = temp[i];
            }
            counter++;
        }
        saveDataArray = Arrays.copyOf(saveDataArray, size);
        readObj.close();
        char[] addChar = traverseTree(saveDataArray);
        StringBuilder lineOut = new StringBuilder("");
        for (int i = 0; i < addChar.length; i++) {
            if (addChar[i] == '\n') {
                out.println(lineOut);
                lineOut.delete(0, lineOut.length());
            } else {
                lineOut.append(addChar[i]);
            }
        }
        if (lineOut.length() > 0) {
            out.print(lineOut);
        }
        out.close();
    }

    /**
     * writeEncodedFile
     *
     * @param bytes bytes for file
     * @param fileName file input
     * @return
     */
    public File writeEncodedFile(byte[] bytes, String fileName) throws IOException {
        String encodeFileName
                = fileName.substring(0, fileName.lastIndexOf(".")) + ".huf";
        File encodeFile = new File(directory + encodeFileName);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(encodeFile))) {
            outputStream.write(bytes);
            outputStream.close();
        }
        return new File(encodeFileName);
    }

    /**
     * writeKeyFile
     *
     * @param fileName the name of the file to write to
     */
    public void writeKeyFile(String fileName) throws IOException {
        String keyFileName
                = fileName.substring(0, fileName.lastIndexOf(".")) + ".cod";
        saveDataArray = new byte[charCountArray.length * 3];
        for (int i = 0; i < charCountArray.length; i++) {
            byte[] threeByteArray = charCountArray[i].toThreeBytes();
            saveDataArray[3 * i] = threeByteArray[0];
            saveDataArray[3 * i + 1] = threeByteArray[1];
            saveDataArray[3 * i + 2] = threeByteArray[2];
        }
        File keyFile = new File(directory + keyFileName);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(keyFile))) {
            for (int i = 0; i < saveDataArray.length; i++) {
                outputStream.writeByte(saveDataArray[i]);
            }
            outputStream.close();
        }
    }


    private byte[] toArray(ArrayList<Byte> arrayList) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        byte[] bytesArray = new byte[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            bytesArray[i] = arrayList.get(i);
        }
        return bytesArray;
    }

    private char[] traverseTree(byte[] saveDataArray) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<Character> allChars = new ArrayList<>();
        StringBuilder value = new StringBuilder("");
        StringBuilder test = new StringBuilder("");
        for (int i = 0; i < saveDataArray.length; i++) {
            String getVal = Integer.toBinaryString(saveDataArray[i]);
            int adjust = getVal.length() - Byte.SIZE;
            if (adjust > 0) {
                getVal = getVal.substring(adjust);
            } else if (adjust < 0) {
                while (getVal.length() < 8) {
                    getVal = "0" + getVal;
                }
            }
            value.append(getVal);
            while (value.length() > 0) {
                test.append(value.substring(0, 1));
                value = new StringBuilder(value.substring(1));
                Character fromKey = codeMap.get(test.toString());
                if (fromKey != null) {
                    test.delete(0, test.length());
                    allChars.add(fromKey);
                }
            }
        }
        char[] charsArray = new char[allChars.size()];
        for (int i = 0; i < allChars.size(); i++) {
            charsArray[i] = allChars.get(i);
        }
        allChars = null;
        return charsArray;
    }

}
