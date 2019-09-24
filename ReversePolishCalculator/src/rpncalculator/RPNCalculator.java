/*
 * RPNCalculator.java
 */

package rpncalculator;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Reverse Polish Notation class. 
 * Handles mathematical operations, stores up to 10 numbers, retains previous
 * operations.
 * @author Nasser Najib
 */
public class RPNCalculator
{
    static final int ROWS = 4;
    static final int COLS = 8;
    protected static final int NUMBER_OF_REGISTERS = 10;
    protected Deque<Double> theStack;   
    protected LinkedList<String> instructions;
    protected double[] registers;
    
    /**
     * Creates a new instance of RPNCalculator
     */
    public RPNCalculator()
    {
        
        registers = new double[NUMBER_OF_REGISTERS];
        instructions = new LinkedList();
        theStack = new LinkedList();
       
    }
    /**
     * Rotates the stack either up or down by moving either the bottom element
     * to the top or the top element to the bottom.
     * @param operation 
     * @return  The top of the stack.
     */
    public double rotateStack(String operation){
        if(operation.equals("Up"))
            theStack.addLast(theStack.pop());
        if(operation.equals("Down"))
            theStack.addFirst(theStack.removeLast());
        return theStack.peekFirst();
    }
    /**
     * Performs a given operation on the two top-most elements in the stack.
     * @param operation
     * @return The result of the mathematical operation.
     * @throws SmallStackException 
     */
    public double handleMath(String operation) throws SmallStackException{
        //Can't do binary math with one number.
        if(theStack.size() < 2)
            throw new SmallStackException("Stack size was less than 2");
        double valA = theStack.pop();
        double valB = theStack.pop();
        if(operation.equalsIgnoreCase("X"))
            operation = "*";
        //double result = 0;
        switch (operation){
            case "+":
                theStack.push(valA + valB);
                break;
            case "-":
                theStack.push(valB - valA);
                break;
            case "*":
                theStack.push(valA * valB);
                break;
            case "/":
                theStack.push(valB/valA);
                break;
            case "%":
                theStack.push(valB%valA);
                break;
            case "^":
                theStack.push(Math.pow(valB, valA));
        }
        return theStack.peekFirst();
    }
     
}
/**
 * Custom exception class to be thrown when a stack size is less than 2, as then
 * there are not enough number to perform any binary operations.
 * @author Nasser Najib
 */
class SmallStackException extends Exception {
    public SmallStackException(String message) {
        super(message);
    }
}
