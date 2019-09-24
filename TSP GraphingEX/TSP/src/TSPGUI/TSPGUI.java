package TSPGUI;
import TSPBackEnd.Location;
import TSPBackEnd.Path;
import TSPBackEnd.Validation;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
/**<pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
 * Class            TSPGUI<br>
 * File             TSPGUI.java<br>
 * Description      creates and displays the GUI Form, handles actions and
 * passes inputs to the driver class.<br>
 * @author          Nasser Najib<br>
 * Environment      PC, Windows 10, jdk1.8, NetBeans 8.2<br>
 * Date             04/10/19<br>
 * @version         1.0<br>
 * History Log:     06/01/19 - creation.<br>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *</pre>
 */

public class TSPGUI extends javax.swing.JFrame {
    public boolean isVisible = false;
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      TSPGUI<br>
     * @author          Nasser Najib<br>
     * Description      Default constructor for the GUI, sets control properties
     * and initializes the form.<br>
     * History Log:     06/01/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public TSPGUI() {
        initComponents();
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~~~~~~~~~~JFRAME PROPERTIES~~~~~~~~~~~~~
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Travelling Salesman Problem");
        isVisible = true;
        
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~~~~~~~~~~BUTTON PROPERTIES~~~~~~~~~~~~~
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(nearestNeighborJRadioButtonMenuItem);
        radioButtons.add(sortedEdgeJRadioButtonMenuItem);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        algorithmJButtonGroup = new javax.swing.ButtonGroup();
        randomJDialog = new javax.swing.JDialog();
        quantityJLabel = new javax.swing.JLabel();
        minJLabel = new javax.swing.JLabel();
        maxJLabel = new javax.swing.JLabel();
        quantityJTextField = new javax.swing.JTextField();
        minJTextField = new javax.swing.JTextField();
        maxJTextField = new javax.swing.JTextField();
        titleJLabel = new javax.swing.JLabel();
        acceptJButton = new javax.swing.JButton();
        outputJScrollPane = new javax.swing.JScrollPane();
        outputJTextPane = new javax.swing.JTextPane();
        calculateJButton = new javax.swing.JButton();
        randomPointsJButton = new javax.swing.JButton();
        loadJButton = new javax.swing.JButton();
        exportJButton = new javax.swing.JButton();
        printJButton = new javax.swing.JButton();
        nearestNeighborJRadioButton = new javax.swing.JRadioButton();
        sortedEdgeJRadioButton = new javax.swing.JRadioButton();
        clearJButton = new javax.swing.JButton();
        menuJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        loadJMenuItem = new javax.swing.JMenuItem();
        saveJMenuItem = new javax.swing.JMenuItem();
        clearJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        quitJMenuItem = new javax.swing.JMenuItem();
        methodJMenu = new javax.swing.JMenu();
        nearestNeighborJRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        sortedEdgeJRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        statisticsJMenu = new javax.swing.JMenu();
        nearestNeighborTimeJMenuItem = new javax.swing.JMenuItem();
        sortedEdgeTimeJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();

        randomJDialog.setAlwaysOnTop(true);
        randomJDialog.setMinimumSize(new java.awt.Dimension(261, 250));
        randomJDialog.setResizable(false);

        quantityJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        quantityJLabel.setText("How many random points?");

        minJLabel.setText("What is the minmum coordinate?");

        maxJLabel.setText("What is the maximum coordinate?");

        titleJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleJLabel.setText("Random Points Generator");

        acceptJButton.setText("Generate");
        acceptJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout randomJDialogLayout = new javax.swing.GroupLayout(randomJDialog.getContentPane());
        randomJDialog.getContentPane().setLayout(randomJDialogLayout);
        randomJDialogLayout.setHorizontalGroup(
            randomJDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, randomJDialogLayout.createSequentialGroup()
                .addGroup(randomJDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(randomJDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                    .addGroup(randomJDialogLayout.createSequentialGroup()
                        .addGroup(randomJDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(randomJDialogLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(randomJDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(minJLabel)
                                    .addComponent(maxJLabel))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, randomJDialogLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(quantityJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(randomJDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantityJTextField)
                            .addComponent(minJTextField)
                            .addComponent(maxJTextField))))
                .addContainerGap())
            .addGroup(randomJDialogLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(acceptJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        randomJDialogLayout.setVerticalGroup(
            randomJDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(randomJDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(randomJDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quantityJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(randomJDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(randomJDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(maxJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(acceptJButton)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        outputJTextPane.setEditable(false);
        outputJTextPane.setToolTipText("Output");
        outputJScrollPane.setViewportView(outputJTextPane);

        calculateJButton.setText("Calculate Tour");
        calculateJButton.setToolTipText("Calculate the convex hull");
        calculateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateJButtonActionPerformed(evt);
            }
        });

        randomPointsJButton.setText("Add Random Locations");
        randomPointsJButton.setToolTipText("Generate a set of random points");
        randomPointsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomPointsJButtonActionPerformed(evt);
            }
        });

        loadJButton.setText("Load Points");
        loadJButton.setToolTipText("Load points from a text file");
        loadJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadJButtonActionPerformed(evt);
            }
        });

        exportJButton.setText("Export Points");
        exportJButton.setToolTipText("Save points to a text file");
        exportJButton.setMaximumSize(new java.awt.Dimension(97, 32));
        exportJButton.setMinimumSize(new java.awt.Dimension(97, 32));
        exportJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportJButtonActionPerformed(evt);
            }
        });

        printJButton.setText("Print Form");
        printJButton.setToolTipText("Prints a screenshot of the program");
        printJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJButtonActionPerformed(evt);
            }
        });

        algorithmJButtonGroup.add(nearestNeighborJRadioButton);
        nearestNeighborJRadioButton.setSelected(true);
        nearestNeighborJRadioButton.setText("Nearest Neighbor");
        nearestNeighborJRadioButton.setToolTipText("");
        nearestNeighborJRadioButton.setActionCommand("");

        algorithmJButtonGroup.add(sortedEdgeJRadioButton);
        sortedEdgeJRadioButton.setText("Sorted Edge");

        clearJButton.setText("Clear");
        clearJButton.setToolTipText("Reset the program. Deletes points and clears the output.");
        clearJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJButtonActionPerformed(evt);
            }
        });

        fileJMenu.setText("File");

        loadJMenuItem.setText("Load Points");
        loadJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(loadJMenuItem);

        saveJMenuItem.setText("Save Points");
        fileJMenu.add(saveJMenuItem);

        clearJMenuItem.setText("Clear");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printJMenuItem.setText("Print Form");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);

        quitJMenuItem.setText("Quit");
        quitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(quitJMenuItem);

        menuJMenuBar.add(fileJMenu);

        methodJMenu.setText("Method");

        nearestNeighborJRadioButtonMenuItem.setSelected(true);
        nearestNeighborJRadioButtonMenuItem.setText("Nearest Neighbor");
        nearestNeighborJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nearestNeighborJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        methodJMenu.add(nearestNeighborJRadioButtonMenuItem);

        sortedEdgeJRadioButtonMenuItem.setSelected(true);
        sortedEdgeJRadioButtonMenuItem.setText("Sorted Edge");
        sortedEdgeJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortedEdgeJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        methodJMenu.add(sortedEdgeJRadioButtonMenuItem);

        menuJMenuBar.add(methodJMenu);

        statisticsJMenu.setText("Statistics");

        nearestNeighborTimeJMenuItem.setText("Nearest Neighbor Run Time = 0 ns");
        statisticsJMenu.add(nearestNeighborTimeJMenuItem);

        sortedEdgeTimeJMenuItem.setText("Sorted Edge Run Time = 0 ns");
        statisticsJMenu.add(sortedEdgeTimeJMenuItem);

        menuJMenuBar.add(statisticsJMenu);

        helpJMenu.setText("Help");
        menuJMenuBar.add(helpJMenu);

        setJMenuBar(menuJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nearestNeighborJRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(calculateJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(randomPointsJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exportJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(printJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sortedEdgeJRadioButton)
                    .addComponent(clearJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(randomPointsJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loadJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exportJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(printJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calculateJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(nearestNeighborJRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sortedEdgeJRadioButton))
                    .addComponent(outputJScrollPane))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sortedEdgeJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortedEdgeJRadioButtonMenuItemActionPerformed
        syncRadioButtons();
    }//GEN-LAST:event_sortedEdgeJRadioButtonMenuItemActionPerformed
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      nearestNeighborJRadioButtonMenuItemActionPerformed<br>
     * @author          Nasser Najib<br>
     * Description      Handles the event of clicking the radio button. This keeps
     *                  all of the radio buttons in sync.<br>
     *
     * Input            <br>
     * @param           evt - click event.<br>
     * Output<br>
     *
     * History Log:     06/01/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private void nearestNeighborJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nearestNeighborJRadioButtonMenuItemActionPerformed
        syncRadioButtons();
    }//GEN-LAST:event_nearestNeighborJRadioButtonMenuItemActionPerformed
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      loadJButtonActionPerformed<br>
     * @author          Nasser Najib<br>
     * Description      Calls for the backend to load points, displays those points.<br>
     *
     * Input<br>
     * @param           evt - click event.<br>
     * Output<br>
     *
     * History Log:     06/01/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private void loadJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadJButtonActionPerformed
        TSPDriver.loadFromFile();
        ArrayList<Location> locs = TSPDriver.getLocations();
        
        if(!locs.isEmpty()){
            appendOutput("CURRENT POINTS:");
            for(int i = 0; i < locs.size(); i++)
                appendOutput(locs.get(i).toString());
        }
    }//GEN-LAST:event_loadJButtonActionPerformed
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      randomPointsJButtonActionPerformed
     * @author          Nasser Najib
     * Description      Calls for generating random points, prompts the user for
     *                  a few inputs (number of points, lower limit and upper limit)
     *
     * Input
     * @param           evt - click event.
     * Output
     *
     * History Log:     04/24/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private void randomPointsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomPointsJButtonActionPerformed
        randomJDialog.setVisible(true);
        randomJDialog.setLocationRelativeTo(null);
    }//GEN-LAST:event_randomPointsJButtonActionPerformed
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      calculateJButtonActionPerformed
     * @author          Nasser Najib
     * Description      Handles the button being clicked, calls for the points to
     *                  be processed and the tour to be calculated.
     *
     * Input            
     * @param           evt - click event
     * Output
     *
     * History Log:
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private void calculateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateJButtonActionPerformed
        ArrayList<Path> paths = new ArrayList<>();
        String mode = "";
        int cost = 0;
        if(nearestNeighborJRadioButton.isSelected()){
            paths = TSPDriver.calculateNN();
            mode = "Nearest Neighbor";
        }
        else{
            paths = TSPDriver.calculateSortedEdge();
            mode = "Sorted Edge";
        }
        if(paths != null && !paths.isEmpty()){
            cost = TSPDriver.getCost();
            appendOutput("Tour path found using " + mode + ":");
            for(int i = 0; i < paths.size(); i++)
                appendOutput(paths.get(i).toString());
            appendOutput("Tour cost: " + cost);
            updateTime();
        }
    }//GEN-LAST:event_calculateJButtonActionPerformed

    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJButtonActionPerformed
        outputJTextPane.setText("");
        TSPDriver.clear();
    }//GEN-LAST:event_clearJButtonActionPerformed

    private void acceptJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptJButtonActionPerformed
        Validation validator = new Validation();
        int quantity = 0;
        double min = 0, max = 0;
        boolean invalid = false;
        if(!validator.isNumeric(quantityJTextField.getText()) ||
                !validator.isNumeric(maxJTextField.getText()) ||
                !validator.isNumeric(minJTextField.getText()))
            JOptionPane.showMessageDialog(randomJDialog, 
                    "Please make sure all inputs are numeric", "Invalid input!", 
                    ERROR_MESSAGE);
        else{
            quantity = Integer.parseInt(quantityJTextField.getText());
            min = Double.parseDouble(minJTextField.getText());
            max = Double.parseDouble(maxJTextField.getText());
            randomJDialog.dispose();
            if(quantity > 0 && min != max){
                TSPDriver.generateRandomPoints(quantity, min, max);
                appendOutput("GENERATED " + quantity + " POINTS");
                appendOutput("CURRENT POINTS:");
                ArrayList<Location> loc = TSPDriver.getLocations();
                for(int i = 0; i < loc.size(); i++)
                    appendOutput(loc.get(i).toString());
            }            
        }
    }//GEN-LAST:event_acceptJButtonActionPerformed

    private void printJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJButtonActionPerformed
        TSPDriver.printForm(this);
    }//GEN-LAST:event_printJButtonActionPerformed

    private void quitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitJMenuItemActionPerformed

    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        printJButton.doClick();
    }//GEN-LAST:event_printJMenuItemActionPerformed

    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        clearJButton.doClick();
    }//GEN-LAST:event_clearJMenuItemActionPerformed

    private void loadJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadJMenuItemActionPerformed
        loadJButton.doClick();
    }//GEN-LAST:event_loadJMenuItemActionPerformed

    private void exportJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportJButtonActionPerformed
        TSPDriver.saveToFile();
    }//GEN-LAST:event_exportJButtonActionPerformed
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      display<br>
     * @author          Nasser Najib<br>
     * Description      Generated code, sets frame properties and displays the form.<br>

     * History Log:     04/10/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public void display() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TSPGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptJButton;
    private javax.swing.ButtonGroup algorithmJButtonGroup;
    private javax.swing.JButton calculateJButton;
    private javax.swing.JButton clearJButton;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JButton exportJButton;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JButton loadJButton;
    private javax.swing.JMenuItem loadJMenuItem;
    private javax.swing.JLabel maxJLabel;
    private javax.swing.JTextField maxJTextField;
    private javax.swing.JMenuBar menuJMenuBar;
    private javax.swing.JMenu methodJMenu;
    private javax.swing.JLabel minJLabel;
    private javax.swing.JTextField minJTextField;
    private javax.swing.JRadioButton nearestNeighborJRadioButton;
    private javax.swing.JRadioButtonMenuItem nearestNeighborJRadioButtonMenuItem;
    private javax.swing.JMenuItem nearestNeighborTimeJMenuItem;
    private javax.swing.JScrollPane outputJScrollPane;
    private javax.swing.JTextPane outputJTextPane;
    private javax.swing.JButton printJButton;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JLabel quantityJLabel;
    private javax.swing.JTextField quantityJTextField;
    private javax.swing.JMenuItem quitJMenuItem;
    private javax.swing.JDialog randomJDialog;
    private javax.swing.JButton randomPointsJButton;
    private javax.swing.JMenuItem saveJMenuItem;
    private javax.swing.JRadioButton sortedEdgeJRadioButton;
    private javax.swing.JRadioButtonMenuItem sortedEdgeJRadioButtonMenuItem;
    private javax.swing.JMenuItem sortedEdgeTimeJMenuItem;
    private javax.swing.JMenu statisticsJMenu;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      syncRadioButtons<br>
     * @author          Nasser Najib<br>
     * Description      Synchronizes radio buttons from the menu bar to the main frame.<br>
     * 
     * History Log:     04/10/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     *</pre>
     */
    private void syncRadioButtons() {
        if(nearestNeighborJRadioButtonMenuItem.isSelected())
            nearestNeighborJRadioButton.setSelected(true);
        if(sortedEdgeJRadioButtonMenuItem.isSelected())
            sortedEdgeJRadioButton.setSelected(true);
    }

    private void appendOutput(String line) {
        String output = outputJTextPane.getText();
        output = output + line + "\n";
        outputJTextPane.setText(output);
    }

    private void updateTime() {
        nearestNeighborTimeJMenuItem.setText("Nearest Neighbor Run Time = " +
                TSPDriver.getNearestNeighborTime() + " ns");
        sortedEdgeTimeJMenuItem.setText("Sorted Edge Run Time = " +
                TSPDriver.getSortedEdgeTime() + " ns");
    }
    
}
