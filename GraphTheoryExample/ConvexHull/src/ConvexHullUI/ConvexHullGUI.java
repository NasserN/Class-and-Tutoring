package ConvexHullUI;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**<pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class            ConvexHullGUI
 * File             ConvexHullGUI.java
 * Description      creates and displays the GUI Form, handles actions and 
 *                  passes inputs to the driver class.
 * @author          Nasser Najib
 * Environment      PC, Windows 10, jdk1.8, NetBeans 8.2
 * Date             04/10/19
 * @version         1.0
 * @see
 * History Log:     04/10/19 - creation.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *</pre>
 */

public class ConvexHullGUI extends javax.swing.JFrame {
    public boolean isVisible = false;
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      ConvexHullGUI
     * @author          Nasser Najib
     * Description      Default constructor for the GUI, sets control properties
     *                  and initializes the form.

     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public ConvexHullGUI() {
        initComponents();
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~~~~~~~~~~JFRAME PROPERTIES~~~~~~~~~~~~~
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Convex Hull Simulator");
        isVisible = true;
        
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~~~~~~~~~~BUTTON PROPERTIES~~~~~~~~~~~~~
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(giftWrappingJRadioButtonMenuItem);
        radioButtons.add(grahamsJRadioButtonMenuItem);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~~~~~~~~INPUT AREA PROPERTIES~~~~~~~~~~~
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        String inputPlaceHolder = "Ex.(X,Y)";
        inputJTextArea.setForeground(Color.GRAY);
        inputJTextArea.setText(inputPlaceHolder);
        inputJTextArea.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                if(inputJTextArea.getText().equals(inputPlaceHolder)){
                    inputJTextArea.setText("");
                    inputJTextArea.setForeground(Color.BLACK);
                }
                
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(inputJTextArea.getText().equals("")){
                    inputJTextArea.setText(inputPlaceHolder);
                    inputJTextArea.setForeground(Color.GRAY);
                }
            }
            
        });
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
        addPointsJLabel = new javax.swing.JLabel();
        inputJTextArea = new javax.swing.JTextField();
        outputJScrollPane = new javax.swing.JScrollPane();
        outputJTextPane = new javax.swing.JTextPane();
        calculateJButton = new javax.swing.JButton();
        randomPointsJButton = new javax.swing.JButton();
        loadJButton = new javax.swing.JButton();
        exportJButton = new javax.swing.JButton();
        printJButton = new javax.swing.JButton();
        giftWrapJRadioButton = new javax.swing.JRadioButton();
        grahamsJRadioButton = new javax.swing.JRadioButton();
        clearJButton = new javax.swing.JButton();
        menuJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        loadJMenuItem = new javax.swing.JMenuItem();
        saveJMenuItem = new javax.swing.JMenuItem();
        clearJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        quitJMenuItem = new javax.swing.JMenuItem();
        methodJMenu = new javax.swing.JMenu();
        giftWrappingJRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        grahamsJRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        statisticsJMenu = new javax.swing.JMenu();
        pointsJMenuItem = new javax.swing.JMenuItem();
        hullPointsJMenuItem = new javax.swing.JCheckBoxMenuItem();
        interiorPointsJMenuItem = new javax.swing.JMenuItem();
        interiorPointsPercJMenuItem = new javax.swing.JMenuItem();
        grahamsTimeJMenuItem = new javax.swing.JMenuItem();
        giftWrapTimeJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();

        randomJDialog.setAlwaysOnTop(true);
        randomJDialog.setMinimumSize(new java.awt.Dimension(261, 250));
        randomJDialog.setResizable(false);

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
                        .addComponent(titleJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, randomJDialogLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(randomJDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(minJLabel)
                            .addComponent(maxJLabel))
                        .addGap(10, 10, 10)
                        .addGroup(randomJDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minJTextField)
                            .addComponent(maxJTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, randomJDialogLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(quantityJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quantityJTextField)))
                .addContainerGap())
            .addGroup(randomJDialogLayout.createSequentialGroup()
                .addGap(84, 84, 84)
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
                .addGap(18, 18, 18)
                .addComponent(acceptJButton)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addPointsJLabel.setText("Enter Point(s):");

        inputJTextArea.setToolTipText("Enter a point in the form (X,Y) and press ENTER");
        inputJTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputJTextAreaKeyTyped(evt);
            }
        });

        outputJTextPane.setEditable(false);
        outputJTextPane.setToolTipText("Output");
        outputJScrollPane.setViewportView(outputJTextPane);

        calculateJButton.setText("Calculate Covex Hull");
        calculateJButton.setToolTipText("Calculate the convex hull");
        calculateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateJButtonActionPerformed(evt);
            }
        });

        randomPointsJButton.setText("Add Random Points");
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

        printJButton.setText("Print Form");
        printJButton.setToolTipText("Prints a screenshot of the program");
        printJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJButtonActionPerformed(evt);
            }
        });

        algorithmJButtonGroup.add(giftWrapJRadioButton);
        giftWrapJRadioButton.setSelected(true);
        giftWrapJRadioButton.setText("Gift Wrapping Method");
        giftWrapJRadioButton.setToolTipText("");
        giftWrapJRadioButton.setActionCommand("");

        algorithmJButtonGroup.add(grahamsJRadioButton);
        grahamsJRadioButton.setText("Graham Scanning");

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

        giftWrappingJRadioButtonMenuItem.setSelected(true);
        giftWrappingJRadioButtonMenuItem.setText("Gift Wrapping Method");
        giftWrappingJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giftWrappingJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        methodJMenu.add(giftWrappingJRadioButtonMenuItem);

        grahamsJRadioButtonMenuItem.setSelected(true);
        grahamsJRadioButtonMenuItem.setText("Graham's Method");
        grahamsJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grahamsJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        methodJMenu.add(grahamsJRadioButtonMenuItem);

        menuJMenuBar.add(methodJMenu);

        statisticsJMenu.setText("Statistics");

        pointsJMenuItem.setText("Total Points = 0");
        statisticsJMenu.add(pointsJMenuItem);

        hullPointsJMenuItem.setText("Hull Points = 0");
        statisticsJMenu.add(hullPointsJMenuItem);

        interiorPointsJMenuItem.setText("Interior Points = 0");
        statisticsJMenu.add(interiorPointsJMenuItem);

        interiorPointsPercJMenuItem.setText("Interior Points Percentage = 0%");
        statisticsJMenu.add(interiorPointsPercJMenuItem);

        grahamsTimeJMenuItem.setText("Graham's Run Time = 0 ms");
        statisticsJMenu.add(grahamsTimeJMenuItem);

        giftWrapTimeJMenuItem.setText("Gift Wrapping Run TIme = 0 ms");
        statisticsJMenu.add(giftWrapTimeJMenuItem);

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
                    .addComponent(giftWrapJRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(calculateJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(randomPointsJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exportJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(printJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(grahamsJRadioButton)
                    .addComponent(clearJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addPointsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(outputJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputJTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputJScrollPane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                        .addComponent(giftWrapJRadioButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPointsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputJTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grahamsJRadioButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void grahamsJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grahamsJRadioButtonMenuItemActionPerformed
        syncRadioButtons();
    }//GEN-LAST:event_grahamsJRadioButtonMenuItemActionPerformed
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      giftWeappingJRadioButtonMenuItemActionPerformed
     * @author          Nasser Najib
     * Description      Handles the event of clicking the radio button. This keeps
     *                  all of the radio buttons in sync.
     *
     * Input            
     * @param           evt - click event.
     * Output
     *
     * History Log:     04/24/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private void giftWrappingJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giftWrappingJRadioButtonMenuItemActionPerformed
        syncRadioButtons();
    }//GEN-LAST:event_giftWrappingJRadioButtonMenuItemActionPerformed
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      loadJButtonActionPerformed
     * @author          Nasser Najib
     * Description      Calls for the backend to load points, displays those points.
     *
     * Input
     * @param           evt - click event.
     * Output
     *
     * History Log:     04/24/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private void loadJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadJButtonActionPerformed
        ArrayList<Point2D> points = ConvexHullDriver.loadPoints();
        //if no points loaded, null is returned
        if(points != null)
            for(int i = 0; i < points.size(); i ++)
                appendOutput(points.get(i));
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
     *                  be processed and the hull to be calculated.
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
        //need at least 3 points to create a hull
        if(ConvexHullDriver.plotSize() > 3){
            if(giftWrapJRadioButton.isSelected())
                ConvexHullDriver.giftWrappingMethod();
            else if(grahamsJRadioButton.isSelected())
                ConvexHullDriver.giftWrappingMethod();
            outputConvex();
            updateStats();
        }
        else{
            JOptionPane.showMessageDialog(null, "You Must Have atleast 3 points "
                    + "to calculate the hull!", "Not Enough Points!", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_calculateJButtonActionPerformed
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      inputJTextArea
     * @author          Nasser Najib
     * Description      Event handler for when a key has been typed into the input
     *                  text area. This filters non numeric values and only allows
     *                  numbers, commas, and parethesis to be typed.
     *
     * Input        
     * @param           evt - Key event
     * Output
     *
     * History Log:     04/24/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private void inputJTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputJTextAreaKeyTyped
        int input;
        char c = evt.getKeyChar();
        input = evt.getKeyChar();
        System.out.println(input);
        // If enter is pressed, process input as a point
        if(c == 10){
            int res = processInput(inputJTextArea.getText());
            if(res == 0){
                //proper format, point is accepted, clear the input
                inputJTextArea.setText("");
            }
            if(res == -1){
                //improper format, warn user, highlight the input
                JOptionPane.showMessageDialog(null, "Invalid Format, please enter"
                        + " a point in the format X,Y or (X,Y)!");
                inputJTextArea.selectAll();
            }
        }
        //only these characters can be typed.
        if (c != '(' && c != ')' && c!= ',' && !Character.isDigit(c))
            evt.consume();
    }//GEN-LAST:event_inputJTextAreaKeyTyped

    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJButtonActionPerformed
        ConvexHullDriver.clear();
        outputJTextPane.setText("");
        updateStats();
    }//GEN-LAST:event_clearJButtonActionPerformed

    private void acceptJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptJButtonActionPerformed
        int quantity;
        double min, max;
        try{
            //try parsing inputs
            quantity = Integer.parseInt(quantityJTextField.getText());
            min = Double.parseDouble(minJTextField.getText());
            max = Double.parseDouble(maxJTextField.getText());
            // no points to generate
            if(quantity <= 0)
                randomJDialog.dispose();
            //only one possible point, and its not generated, it's given.
            else if(min == max)
                JOptionPane.showMessageDialog(null, "Minimum and maximum cannot"
                        + " be the same number!");
            else
                //generate points
                randomPoints(quantity, min, max);
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter numeric values only!");
        }
        randomJDialog.dispose();
    }//GEN-LAST:event_acceptJButtonActionPerformed

    private void printJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJButtonActionPerformed
        ConvexHullDriver.print(this);
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
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      display
     * @author          Nasser Najib
     * Description      Generated code, sets frame properties and displays the form.

     * History Log:     04/10/19 - creation.
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
            java.util.logging.Logger.getLogger(ConvexHullGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConvexHullGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConvexHullGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConvexHullGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConvexHullGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptJButton;
    private javax.swing.JLabel addPointsJLabel;
    private javax.swing.ButtonGroup algorithmJButtonGroup;
    private javax.swing.JButton calculateJButton;
    private javax.swing.JButton clearJButton;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JButton exportJButton;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JRadioButton giftWrapJRadioButton;
    private javax.swing.JMenuItem giftWrapTimeJMenuItem;
    private javax.swing.JRadioButtonMenuItem giftWrappingJRadioButtonMenuItem;
    private javax.swing.JRadioButton grahamsJRadioButton;
    private javax.swing.JRadioButtonMenuItem grahamsJRadioButtonMenuItem;
    private javax.swing.JMenuItem grahamsTimeJMenuItem;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JCheckBoxMenuItem hullPointsJMenuItem;
    private javax.swing.JTextField inputJTextArea;
    private javax.swing.JMenuItem interiorPointsJMenuItem;
    private javax.swing.JMenuItem interiorPointsPercJMenuItem;
    private javax.swing.JButton loadJButton;
    private javax.swing.JMenuItem loadJMenuItem;
    private javax.swing.JLabel maxJLabel;
    private javax.swing.JTextField maxJTextField;
    private javax.swing.JMenuBar menuJMenuBar;
    private javax.swing.JMenu methodJMenu;
    private javax.swing.JLabel minJLabel;
    private javax.swing.JTextField minJTextField;
    private javax.swing.JScrollPane outputJScrollPane;
    private javax.swing.JTextPane outputJTextPane;
    private javax.swing.JMenuItem pointsJMenuItem;
    private javax.swing.JButton printJButton;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JLabel quantityJLabel;
    private javax.swing.JTextField quantityJTextField;
    private javax.swing.JMenuItem quitJMenuItem;
    private javax.swing.JDialog randomJDialog;
    private javax.swing.JButton randomPointsJButton;
    private javax.swing.JMenuItem saveJMenuItem;
    private javax.swing.JMenu statisticsJMenu;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      syncRadioButtons
     * @author          Nasser Najib
     * Description      Synchronizes radio buttons from the menu bar to the main frame.
     * 
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private void syncRadioButtons() {
        if(giftWrappingJRadioButtonMenuItem.isSelected())
            giftWrapJRadioButton.setSelected(true);
        if(grahamsJRadioButtonMenuItem.isSelected())
            grahamsJRadioButton.setSelected(true);
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      processInput
     * @author          Nasser Najib
     * Description      Takes the input and creates a point out of it, adds the
     *                  point to the set, 
     *
     * Input
     * @param
     * Output
     *
     * History Log:
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private int processInput(String text) {
        if(!text.isEmpty()){
            try{
                int parenthesisIndex = 0;
                double xCoord, yCoord;
                //check if first parenthesis exists
                if(text.startsWith("("))
                    //digits start after that
                    parenthesisIndex = 1;
                xCoord = Double.parseDouble(text.substring(parenthesisIndex, text.indexOf(",")));
                if(text.endsWith(")"))
                    //end before the parenthesis if it exists
                    parenthesisIndex = text.length() - 1;
                else
                    parenthesisIndex = text.length();
                yCoord = Double.parseDouble(text.substring(text.indexOf(",") + 1, parenthesisIndex));
                Point2D p = new Point2D.Double();
                p.setLocation(xCoord,yCoord);
                if (ConvexHullDriver.addPoint(p) == 0)
                    appendOutput(p);
                else
                    JOptionPane.showMessageDialog(null, "This point: "
                            + p.toString() + "already exists, it will not be added again.");
                return 0;
            }
            catch(NumberFormatException e){
                return -1;
            }
        }
        return 1;
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      appendOutput
     * @author          Nasser Najib
     * Description      adds a point to the output text area.
     *
     * Input            
     * @param           p - point to be printed
     * Output
     *
     * History Log:     04/24/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private void appendOutput(Point2D p) {
        DecimalFormat df = new DecimalFormat("#.00");
        outputJTextPane.setText(outputJTextPane.getText() + "(" + df.format(p.getX()) + 
                "," + df.format(p.getY()) + ")\n");
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      randomPoints
     * @author          Nasser Najib
     * Description      calls for random points to be generated within certain parameters
     *
     * Input    
     * @param           quantity - number of points
     * @param           min - minimum value (both x and y)
     * @param           max - maximum value (both x and y)
     * Output
     *
     * History Log:
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private void randomPoints(int quantity, double min, double max) {
        ArrayList<Point2D> p = new ArrayList<>();
        p = ConvexHullDriver.randomPoints(quantity, min, max);
        outputJTextPane.setText(outputJTextPane.getText() + "RANDOM POINTS:\n");
        for(int i = 0; i < p.size(); i++)
            appendOutput(p.get(i));
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      outputConvex
     * @author          Nasser Najib
     * Description      retrieves the convex points and adds them to the output text area.

     *
     * History Log:     04/24/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private void outputConvex() {
        Point2D[] p = ConvexHullDriver.getConvexPoints();
        outputJTextPane.setText(outputJTextPane.getText() + "CONVEX HULL POINTS:\n");
        for(int i = 0; i < p.length; i++)
            appendOutput(p[i]);
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      updateStats
     * @author          Nasser Najib
     * Description      updates convex hull statistics.
     *
     *
     * History Log:     04/24/19 - ccreation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private void updateStats() {
        double [] stats = ConvexHullDriver.getStatistics();
        double percentage;
        if(stats[0] == 0)
            percentage = 0;
        else
            percentage = stats[2]/stats[0];
        DecimalFormat perc = new DecimalFormat("0.##%");
        //String s = per.format(percentage);
        pointsJMenuItem.setText("Total Points = " + stats[0]);
        hullPointsJMenuItem.setText("Hull Points = " + stats[1]);
        interiorPointsJMenuItem.setText("Interior Points = " + stats[2]);
        interiorPointsPercJMenuItem.setText("Interior Points Precentage = " + perc.format(percentage));
        grahamsTimeJMenuItem.setText("Graham's Method Run Time = " + stats[4] + "nanos");
        giftWrapTimeJMenuItem.setText("Gift Wrapping Run Time = " + stats[5] + "nanos");
    }
}
