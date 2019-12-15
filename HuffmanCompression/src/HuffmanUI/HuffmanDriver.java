/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HuffmanUI;

import huffman.Huffman;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Nasser Najib
 */
public class HuffmanDriver {
    static protected String extension;
    static protected String desc;
    /**
     * @param args the command line arguments
     */
    static huffmanGUI gui;
    static huffmanCLI cli;
    static Huffman coder;
    public static void main(String[] args) {
        if(args.length == 0){
            huffmanGUI.display();
        }
        else
            cli = new huffmanCLI(args);
    }
    public static void decode(File file){
        coder = new Huffman();
        try {
            coder.decode(file);
        } catch (IOException ex) {
            System.out.println("Error can't read file!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error, class not found!");
        }
    }
    public static void encode(File file){
        coder = new Huffman();
        try {
            coder.encode(file);
        } catch (IOException ex) {
            System.out.println("Error can't read file");
        }
    }
    protected static File getFile(){
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String inputFileName = "x";
        File inputFile = new File(inputFileName);
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter exten = new FileNameExtensionFilter(desc, extension);
        chooser.setFileFilter(exten);
        chooser.setCurrentDirectory(inputFile.getAbsoluteFile()
                .getParentFile());
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            inputFile = chooser.getSelectedFile();
            if (!inputFile.exists() || !inputFile.canRead()) {
                JOptionPane.showMessageDialog(null, "Can not read this file,"
                        + " please try another");
                int choice = JOptionPane.showConfirmDialog(null, "Choose Another File?",
                        "File Error", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (choice == JOptionPane.YES_OPTION) {
                    getFile();
                }
            }
        } else if (returnValue == JFileChooser.CANCEL_OPTION) {
            int choice = JOptionPane.showConfirmDialog(null, "Choose Another File?",
                    "File Canceled", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                getFile();
            }
        }
        return inputFile;
    }
    
}
