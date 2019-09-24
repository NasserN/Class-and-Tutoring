package ConvexHullBackEnd;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**<pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class            FileIO
 * File             FileIO.java
 * Description      Handles reading and writing to/from text files.
 * @author          Nasser Najib
 * Environment      PC, Windows 10, jdk1.8, NetBeans 8.2
 * Date             04/10/19
 * @version         1.0
 * @see
 * History Log:     04/10/19 - creation.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *</pre>
 */
public class FileIO {
    JFileChooser chooser;
    String desc, extension;
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      FileIO
     * @author          Nasser Najib
     * Description      Default constructor, initializes variables.

     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public FileIO(){
        chooser = new JFileChooser();
        desc = "Text File";
        extension = "TXT";
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      FileIO
     * @author          Nasser Najib
     * Description      Overloaded constructor, intializes varibles to inputs.
     * Input
     * @param           desc - Description of the file type. IE: Text files.
     * @param           extension - File extension. IE: TXT
     * Output
     *
     * History Log:
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public FileIO(String desc, String extension){
        chooser = new JFileChooser();
        this.desc = desc;
        this.extension = extension;
        FileNameExtensionFilter exten = 
                new FileNameExtensionFilter(desc, extension);
        chooser.setFileFilter(exten);
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      loadFile()
     * @author          Nasser Najib
     * Description      Lauches a file chooser, allows the user to select a file,
     *                  determines if the file is readable and returns it to the calling method.
     *
     * Output
     * @return          File - the selected file.
     * History Log:
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public File loadFile()
    {
        File inputFile = null;
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            
            inputFile = chooser.getSelectedFile();
            if (!inputFile.exists() || !inputFile.canRead())
            {
                JOptionPane.showMessageDialog(null, "Can not read this file,"
                        + " please try another");
                int choice = JOptionPane.showConfirmDialog(null, 
                        "Choose Another File?",
                        "File Error", JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE);
                if (choice == JOptionPane.YES_OPTION)
                {
                    loadFile();
                }
            }
        } else if (returnValue == JFileChooser.CANCEL_OPTION)
        {
            
            int choice = JOptionPane.showConfirmDialog(null, 
                    "Choose Another File?",
                    "File Canceled", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
            if (choice == JOptionPane.YES_OPTION)
            {
                loadFile();
            }
        }
        return inputFile;
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      saveFile
     * @author          Nasser Najib
     * Description      Exports string data to a file.
     *
     * Input        
     * @param           output - Strign containing the data to be exported.
     * Output           Saves file containing the data.
     *
     * History Log:
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public void saveFile(String output){
        
    }
}
