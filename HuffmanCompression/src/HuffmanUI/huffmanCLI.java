/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HuffmanUI;

import java.io.File;

/**
 *
 * @author Nasser Najib
 */
public class huffmanCLI {
        private String extension;
        private String desc;
    public huffmanCLI(){
        
    }
    public huffmanCLI(String args[]){
        if(args[0].equalsIgnoreCase("-d")){
            if(args.length == 1)
                decodeMode("");
            else
                decodeMode(args[1]);
        }
        else if(args[0].equalsIgnoreCase("-e")){
            if(args.length == 1)
                encodeMode("");
            else
                encodeMode(args[1]);
        }
        else
            unknownEntry();
        
    }

    private void decodeMode(String file) {
        File input = new File(file);
        if(file.equals("") || file == null){
            HuffmanDriver.extension = "HUF";
            HuffmanDriver.desc = "HUF File";
            input = HuffmanDriver.getFile();
        }
        HuffmanDriver.decode(input);
        
    }
    

    private void encodeMode(String file) {
        File input = new File(file);
        if(file.equals("") || file == null){
            HuffmanDriver.extension = "TXT";
            HuffmanDriver.desc = "Text File";
            input = HuffmanDriver.getFile();
        }
        HuffmanDriver.decode(input);
    }

    private void unknownEntry() {
        System.out.println("Unknown entry. Please enter mode (-d or -e)"
                + " followed by a file path. \n Example: HuffmanCompression.java"
                + " -d example.huf");
    }
}
