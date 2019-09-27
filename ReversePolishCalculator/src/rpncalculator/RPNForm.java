/*  RPNForm.java */

package rpncalculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;
/**
 * GUI for Reverse Polish Notation Calculator
 * @author Paul Bladek (GUI)
 * @author Nasser Najib (Function)
 */
public class RPNForm extends JFrame
{
    public static final int FRAME_WIDTH = 660;
    public static final int FRAME_HEIGHT = 330;
    public static final String MACROFILE = "macroFile.txt";
    public static final Color DIGIT_BACKGROUND = new Color(0xf0, 0xf6, 0xff);
    
    private Container contentPane;
    private JPanel displayPanel;
    private JLabel RPNLabel; 
    private JTextField displayTextField;
    private JPanel buttonPanel;
    private JButton[][] buttonGrid;
    
    private RPNCalculator calc;
    private boolean helpMode = false;
    private boolean recordMode = false;
    private boolean msgOn = false;
    private boolean commandPerformed = false;
    private boolean decimalOn = false;
    private boolean getOn = false;
    private boolean setOn = false;
    private String inString = "";
    private String displayString = "";
        
    /**
     * Creates and displays a window of the class RPNClaculator.
     * @param args the command-line arguments
     */
    public static void main(String[] args)
    {
        RPNForm gui = new RPNForm();
        gui.setVisible(true);
    }
    
    /**
     * constructor -- set up the form
     */
    public RPNForm()
    {  
        calc = new RPNCalculator();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("  RPN Calculator");
        setLocation(40, 40);
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        setDisplayPanel();
    }
    
    /**
     * sets up the displayPanel
     */
    public final void setDisplayPanel()
    {
        /**
         * inner class -- listens for any button actions
         */
        class StatusListener implements ActionListener
        {
            /**
            * deal with an action
            * @param event --the actionEvent performed
            */
            @Override
            public void actionPerformed(ActionEvent event)
            { 
                dealWith(event.getActionCommand());
                displayTextField.requestFocusInWindow();
            }  
        }
        
        /**
         * inner class -- listens for any button actions
         */
        class DisplayListener implements KeyListener
        {
            /**
            * not implemented
            * @param event --the actionEvent performed
            */
            @Override
            public void keyPressed(KeyEvent event)
            {}
            /**
            * deal with a keystroke
            * @param event --the actionEvent performed
            */
            @Override
            public void keyReleased(KeyEvent event)
            {
                char c = event.getKeyChar();
                if(event.getKeyCode() == KeyEvent.VK_SHIFT)
                    return;
                if(event.getKeyCode() == KeyEvent.VK_BACK_SPACE ||
                        event.getKeyCode() == KeyEvent.VK_DELETE)
                {
                    displayString = displayTextField.getText();
                    return;
                }
                
                displayTextField.setText(displayString);
                if(validChar(c))
                    dealWith(String.valueOf(c)); 
                displayTextField.requestFocusInWindow();
            }
            /**
            * not implemented
            * @param event --the actionEvent performed
            */
            @Override
            public void keyTyped(KeyEvent event)
            {}   
        }
        KeyListener displayListener = new DisplayListener();
        ActionListener buttonListener = new StatusListener();

        
        displayPanel = new JPanel( );
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.X_AXIS));
        displayPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,
                new Color(0XCC, 0X99, 0XFF)));   
        RPNLabel = new JLabel(" RPN ");
        RPNLabel.setBackground(new Color(0X33, 0X00, 0X66));
        RPNLabel.setFont(new Font("Courier New", 1, 36));
        RPNLabel.setForeground(new Color(0x66, 0x33, 0x66));      
        displayPanel.add(RPNLabel);

        displayTextField = new JTextField("");
        displayTextField.setFont(new Font("Courier New", 1, 24));
        displayTextField.setHorizontalAlignment(JTextField.RIGHT);
        displayTextField.setActionCommand("Enter");
        displayTextField.addKeyListener(displayListener);
        displayPanel.add(displayTextField);
        contentPane.add(displayPanel, BorderLayout.NORTH);        

        buttonPanel = new JPanel( );
        buttonPanel.setBackground(new Color(0xff, 0xef, 0xdf));
        buttonPanel.setLayout(new GridLayout(RPNCalculator.ROWS,
                RPNCalculator.COLS));
        buttonPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,
                new Color(0X99, 0XFF, 0XFF)));
        buttonGrid = new JButton[RPNCalculator.ROWS][RPNCalculator.COLS];

        for(int i = 0; i < RPNCalculator.ROWS; i++)
        {
            for(int j = 0; j < RPNCalculator.COLS; j++)
            {
                buttonGrid[i][j]  = new JButton();
                buttonGrid[i][j].setFont(new Font("Courier New", 1, 16));
                buttonGrid[i][j].addActionListener(buttonListener);
                buttonGrid[i][j].setBorder(BorderFactory.createBevelBorder(1));
                buttonPanel.add(buttonGrid[i][j]);
            }
        }
        buttonGrid[0][0].setText("Exit");
        buttonGrid[0][1].setText("C");
        buttonGrid[0][2].setText("CE");
        buttonGrid[0][3].setFont(new Font("Courier New", 1, 20));
        buttonGrid[0][3].setBackground(DIGIT_BACKGROUND );
        buttonGrid[0][3].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[0][3].setText("7");
        buttonGrid[0][4].setFont(new Font("Courier New", 1, 20));
        buttonGrid[0][4].setBackground(DIGIT_BACKGROUND );
        buttonGrid[0][4].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[0][4].setText("8");
        buttonGrid[0][5].setFont(new Font("Courier New", 1, 20));
        buttonGrid[0][5].setBackground(DIGIT_BACKGROUND );
        buttonGrid[0][5].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[0][5].setText("9");
        buttonGrid[0][6].setText("+");
        buttonGrid[0][7].setText("x");
        buttonGrid[1][0].setText("Set");
        buttonGrid[1][1].setText("Get");
        buttonGrid[1][2].setText("Up");
        buttonGrid[1][3].setFont(new Font("Courier New", 1, 20));
        buttonGrid[1][3].setBackground(DIGIT_BACKGROUND );
        buttonGrid[1][3].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[1][3].setText("4");
        buttonGrid[1][4].setFont(new Font("Courier New", 1, 20));
        buttonGrid[1][4].setBackground(DIGIT_BACKGROUND );
        buttonGrid[1][4].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[1][4].setText("5");
        buttonGrid[1][5].setFont(new Font("Courier New", 1, 20));
        buttonGrid[1][5].setBackground(DIGIT_BACKGROUND );
        buttonGrid[1][5].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[1][5].setText("6");
        buttonGrid[1][6].setText("-");
        buttonGrid[1][7].setText("/");
        buttonGrid[2][0].setText("Load");
        buttonGrid[2][1].setText("Save");
        buttonGrid[2][2].setText("Down");
        buttonGrid[2][3].setFont(new Font("Courier New", 1, 20));
        buttonGrid[2][3].setBackground(DIGIT_BACKGROUND );
        buttonGrid[2][3].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[2][3].setText("1");
        buttonGrid[2][4].setFont(new Font("Courier New", 1, 20));
        buttonGrid[2][4].setBackground(DIGIT_BACKGROUND );
        buttonGrid[2][4].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[2][4].setText("2");
        buttonGrid[2][5].setFont(new Font("Courier New", 1, 20));
        buttonGrid[2][5].setBackground(DIGIT_BACKGROUND );
        buttonGrid[2][5].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[2][5].setText("3");
        buttonGrid[2][6].setText("^");
        buttonGrid[2][7].setText("%");
        buttonGrid[3][0].setText("Rec");
        buttonGrid[3][1].setText("Run");
        buttonGrid[3][2].setText("?");
        buttonGrid[3][3].setText("+/-");
        buttonGrid[3][4].setFont(new Font("Courier New", 1, 20));
        buttonGrid[3][4].setBackground(DIGIT_BACKGROUND );
        buttonGrid[3][4].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[3][4].setText("0");
        buttonGrid[3][5].setText(".");
        buttonGrid[3][6].setText("1/n");
        buttonGrid[3][7].setFont(new Font("Courier New", 1, 15));
        buttonGrid[3][7].setBackground(new Color(0xf6, 0xf0, 0xff));
        buttonGrid[3][7].setForeground(new Color(0x99, 0x00, 0x66));
        buttonGrid[3][7].setText("Enter");

        contentPane.add(buttonPanel, BorderLayout.CENTER);
        disableAlpha(); 
    }
    
    /**
     * deal with an action
     * @param actionCommand --the actionEvent performed
     */
    public void dealWith(String actionCommand)
    {
        int index = 0;
        System.out.println(actionCommand);
        if(msgOn)
        {
            msgOn = false;
            displayTextField.setForeground(Color.BLACK);
            if(recordMode)
                displayTextField.setForeground(Color.MAGENTA);
            displayTextField.setText("");
        }
        try
        {
            
            if(helpMode)
            {
                displayHelp(actionCommand);
                helpMode = false;
                return;
            }
            else
                inString = displayTextField.getText();
            if(setOn || getOn){
                try{
                    index = Integer.parseInt(actionCommand);
                }
                catch(NumberFormatException ex){
                    getOn = false;
                    setOn = false;
                    return;
                }
            }
            /*
            * Returns number from the register.
            */
            if(getOn)
            {
                double value = calc.registers[index];
                displayTextField.setText(Double.toString(value));
                recordAction(actionCommand);
                getOn = false;
                return;
            }
            /*
            * Sets a number at a register.
            */
            if(setOn)
            {
                calc.registers[index] = calc.theStack.peek();
                setOn = false;
                recordAction(actionCommand);
                return;
            }
            /*
            * Displays help options for the commands.
            */
            if(actionCommand.equals("?"))
            {
                helpMode = true;
                displayTextField.setForeground(new Color(0, 0X99, 0X66));
                displayTextField.setText(inString = "?");
            }
            else if(actionCommand.equals("Exit"))
                System.exit(0);
            /*
            Exports the recorded commands
            */
            else if(actionCommand.equals("Save"))
            {
                //Only allow this to be done if we're not recording
                if(!recordMode)
                    exportProgram();
            }
            /*
            * Loads previously saved commands.
            */
            else if(actionCommand.equals("Load"))
            {
                if(!recordMode)
                    loadProgram();
            }
            /*
            * Records input commands
            */
            else if(actionCommand.equals("Rec"))
            {
                toggleRecord();
            }
            /*
            * Runs previously loaded commands.
            */
            else if(actionCommand.equals("Run"))
            {
                if(recordMode)
                    toggleRecord();
                runProgram();
            }
            /*
            * Clears the stack and the display
            */
            else if(actionCommand.equals("C")
                    || actionCommand.equals("c"))
            {           
                decimalOn = false;
                displayTextField.setText("");
                calc.theStack.clear();
                inString = "";
                recordAction(actionCommand);
            }
            /*
            * Clears the previous entry.
            */
            else if(actionCommand.equals("CE"))
            {
                decimalOn = false;
                if(calc.theStack.size() > 0)
                    calc.theStack.removeFirst();
                if(calc.theStack.size() <= 1){
                    displayTextField.setText("");
                    recordAction(actionCommand);
                    return;
                }
                double value = calc.theStack.peek();
                displayTextField.setText(Double.toString(value));
            }
            /*
            * Toggles the ability to retrieve numbers from the registers
            */
            else if(actionCommand.equals("Get"))
            {           
                getOn = true;
            }
            /*
            * Sets a register
            */
            else if(actionCommand.equals("Set"))
            {           
                setOn = true;
            }
            /*
            * Submits a command
            */
            else if(actionCommand.equals("Enter")
                    || actionCommand.equals("\n"))
            {           
                if(!inString.equals("")){
                    double value = Double.parseDouble(inString);
                    calc.theStack.addFirst(value);
                    commandPerformed = true;
                }
            }
            /*
            * Returns the multiplicative inverse of a number
            */
            else if (actionCommand.equals("1/n"))                 
            {           
                if(!inString.equals("")){
                    try{
                        double denominator = Double.parseDouble(inString);
                        if(denominator == 0){
                            msgOn = true;
                            displayTextField.setForeground(new Color(0, 0X99, 0X66));
                            displayTextField.setText("Error");
                        }
                        else{
                            double value = 1/denominator;
                            displayTextField.setText(Double.toString(value));
                        }
                    }
                    catch(NumberFormatException ex){
                        displayTextField.setText("");
                    }
                    commandPerformed = true;
                }
                    
            }
            /*
            * Toggles pos and neg symbol.
            */
            else if(actionCommand.equals("+/-"))
            {
                if(commandPerformed)
                    inString = "";
                if(inString.startsWith("-"))
                    inString = inString.substring(1);
                else
                    inString = "-" + inString;
                displayTextField.setText(inString);
                commandPerformed = false;
            }
            /*
            * Enables user to input decimals
            */
            else if (actionCommand.equals("."))                 
            {           
                if(!decimalOn){
                    decimalOn = true;
                    if(commandPerformed){
                        inString = "";
                        commandPerformed = false;
                    }
                    if(inString.equals("") || inString.equals("-"))
                        displayTextField.setText(inString + "0.");
                    else
                        displayTextField.setText(inString.substring
                            (0, inString.length() -1 ));
                }
            }
            /*
            * Handle's numeric input
            */
            else if(Character.isDigit(actionCommand.charAt(0)))    
            {   
                if(commandPerformed){
                    inString = "";
                    commandPerformed = false;
                }
                try{
                    double value = Double.parseDouble(actionCommand);
                    if(decimalOn)
                        displayTextField.setText(inString + 
                                Integer.parseInt(actionCommand));
                    else if(inString.equals("") || inString.equals("-"))
                       displayTextField.setText(inString + String.valueOf(value));
                    else{
                        inString = inString.substring(0, inString.length() - 2);
                        displayTextField.setText(inString + String.valueOf(value));
                    }   
               }
               catch(NumberFormatException ex){
                   msgOn = true;
                   displayTextField.setForeground(new Color(0, 0X99, 0X66));
                   displayTextField.setText("Error");
               }
            }
            else
            {           
                //Handles mathematical operations
                if(actionCommand.equals("Up") || actionCommand.equals("Down"))
                    displayTextField.setText(Double.toString(calc.rotateStack(actionCommand)));
                else{
                    try{
                        displayTextField.setText(Double.toString(calc.handleMath(actionCommand)));
                    }
                    catch(SmallStackException ex){
                        msgOn = true;
                        displayTextField.setForeground(new Color(0, 0X99, 0X66));
                        displayTextField.setText("Error");
                        
                    }
                }
            }
            recordAction(actionCommand);
        }
        catch(Exception e)
        {
            displayTextField.setText("");
        }
       
        
    } 

    /**
     * displays the appropriate help
     * @param actionCommand the command from the triggering event
     */
    private void  displayHelp(String actionCommand)
    {
        msgOn = true;
        switch (actionCommand) {
            case "Exit":
                displayTextField.setText("Exit: Exits program");
                break;
            case "C":
            case "c":
                displayTextField.setText("C: Clears entire stack");
                break;
            case "CE":
                displayTextField.setText("CE: Clears entry (top element)");
                break;
            case "+":
                displayTextField.setText("+: adds top  2 elements");
                break;
            case "x":
            case "X":
            case "*":
                displayTextField.setText("x: multiplies top 2 elements");
                break;
            case "Set":
                displayTextField.setText("Set: Sets register (0-9)");
                break;
            case "Get":
                displayTextField.setText("Get: gets register (0-9)");
                break;
            case "Up":
                displayTextField.setText("Up: Rotates stack up");
                break;
            case "-":
                displayTextField.setText("-: subtracts top 2 elements");
                break;
            case "/":
                displayTextField.setText("/: divides top 2 elements");
                break;
            case "Load":
                displayTextField.setText("Load: Loads program from file");
                break;
            case "Save":
                displayTextField.setText("Save: Saves program to file");
                break;
            case "Down":
                displayTextField.setText("Down: Rotates stack down");
                break;
            case "^":
                displayTextField.setText("^: exponent");
                break;
            case "%":
                displayTextField.setText("%: Mods top 2 elements");
                break;
            case "Rec":
                displayTextField.setText("Rec: Program mode on/off");
                break;
            case "Run":
                displayTextField.setText("Run: Runs program");
                break;
            case "?":
                displayTextField.setText("?: press ? then key for help");
                break;
            case "+/-":
                displayTextField.setText("+/-: changes sign of number");
                break;
            case "1/n":
                displayTextField.setText("1/n: inverts the number");
                break;
            case "Enter":
                displayTextField.setText("Enter: element to stack");
                break;
            default:
                displayTextField.setText("");
                break;
        }
    }

   

    /**
     * 
     * @param c the character to test
     * @return true is c is valid, false otherwise
     */
    private boolean validChar(char c)
    {
        if(Character.isDigit(c))
            return true;
        switch(c)
        {
            case '+':
            case '-':
            case '*':
            case 'x':
            case 'X':
            case '/':
            case 'C':
            case 'c':
            case '^':
            case '%':
            case '?':
            case '.':
            case '\r':
            case '\n':
            return true;
        }
        return false;
    }
    
    /**
     * disables non-numeric-related keys
     */
    private void disableAlpha()
    {
        for(char c = '\0'; c < '%'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = '&'; c < '*'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = ':'; c <= '?'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = '@'; c <= 'C'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = 'D'; c <= 'X'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = 'Y'; c <= '^'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = '_'; c <= 'c'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = 'd'; c <= 'x'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        for(char c = 'y'; c <= '~'; c++)
            displayTextField.getInputMap().put(KeyStroke.getKeyStroke(c),
                            "none");
        
        displayTextField.getInputMap().put(KeyStroke.getKeyStroke('/'),
                            "none");
    }
    /**
     * exportProgram()
     * Exports the commands that were recorded into a text file for future execution.
     */
    
    private void exportProgram() {
        PrintWriter writer;
        PrintStream out;
        File outFile = new File("macroFile.txt");
        try {
        out = new PrintStream(outFile);
        for(int i = 0; i < calc.instructions.size(); i++){
            out.println(calc.instructions.get(i));
        }
        out.close();
        }
        catch (IOException ex) {
            msgOn = true;
            displayTextField.setForeground(new Color(0, 0X99, 0X66));
            displayTextField.setText("Error");
        }
                
    }
    /**
     * loadProgram()
     * Loads a previously exported set of commands for execution.
     */
    private void loadProgram() {
        File macro = new File("macroFile.txt");
        if(macro.exists() && macro.canRead()){
            try {
                Scanner scanner = new Scanner(macro);
                calc.instructions.clear();
                while(scanner.hasNextLine())
                    calc.instructions.add(scanner.nextLine());
                scanner.close();
            } catch (FileNotFoundException ex) {
                msgOn = true;
                displayTextField.setText("Error");
            }
        }
        else{
            msgOn = true;
            displayTextField.setForeground(new Color(0, 0X99, 0X66));
            displayTextField.setText("Error no file");
        }
    }
    /**
     * toggleRecord()
     * Toggles the recording feature's look and enables/disables the record feature.
     */
    private void toggleRecord() {
        if(recordMode){
            displayTextField.setForeground(Color.BLACK);
            buttonGrid[3][0].setForeground(Color.BLACK);
        }
        else{
            displayTextField.setForeground(Color.MAGENTA);
            buttonGrid[3][0].setForeground(Color.MAGENTA);
        }
        recordMode = !recordMode;
    }
    /**
     * recordAction();
     * Handles the recording by adding commands to a list of instructions.
     * @param actionCommand 
     */
    private void recordAction(String actionCommand){
        if(recordMode)
            if(!actionCommand.equals("Rec"))
                calc.instructions.add(actionCommand);
    }
    /**
     * runProgram()
     * Runs the previously recorded/loaded commands.
     */
    private void runProgram() {
        for(int i = 0; i < calc.instructions.size(); i++)
            dealWith(calc.instructions.get(i));
    }
}





