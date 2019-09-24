package ConvexHullUI;

import ConvexHullBackEnd.*;
import java.awt.Component;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
/**<pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class            ConvexHullDriver
 * File             Driver of the convex hull application. This class acts as a
 *                  buffer between the front and back ends. This class contains
 *                  all the mutual methods from the CLI and GUI, it processes the
 *                  inputs and passes them to the backend to calculations.
 * Description
 * @author          Nasser Najib
 * Environment      PC, Windows 10, jdk1.8, NetBeans 8.2
 * Date             04/10/19
 * @version         1.0
 * @see 
 * History Log:     04/10/10 - creation.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *</pre>
 */
public class ConvexHullDriver {
    private static FileIO fileIO;
    private static ConvexHull convex;
    private static ConvexHullGUI gui;
    public static void main(String[] args) {
        gui = new ConvexHullGUI();
        gui.display();
        fileIO = new FileIO("Text file containing points", "TXT");
        convex = new ConvexHull();
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      addPoint
     * @author          Nasser Najib
     * Description      Adds a point to the convex hull set for calculation.
     *
     * Input
     * @param           p - A Point2D object representing a point in the set to
     *                  to be processed.
     * Output
     * @return          An integer signifying whether adding the point was successful.
     *                  -1 - the point already exist and cannot be added again
     *                   0 - the point was successfully added.
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public static int addPoint(Point2D p){
        return convex.addPoint(p);
    }
    public static ArrayList<Point2D> randomPoints(int quantity, double min, double max){
        ArrayList<Point2D> randPoints = new ArrayList<>();
        for(int i = 0; i < quantity; i++){
            double randX = (Math.random() * ((max - min) + 1)) + min;
            double randY = (Math.random() * ((max - min) + 1)) + min;
            Point2D temp = new Point2D.Double(randX, randY);
            if(addPoint(temp) != 0)
                i--;
            else
                randPoints.add(temp);
        }
        return randPoints;
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      loadPoints
     * @author          Nasser Najib
     * Description      Loads points from a text file and adds them to the convex.

     * Output
     * @return          ArrayList containing the added points;
     * History Log:
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public static ArrayList<Point2D> loadPoints(){;
        try{
            //initialize local variables.
            ArrayList<Point2D> points = new ArrayList<>();
            File inputFile = fileIO.loadFile(); //lauches file chooser
            String input;
            double x, y = 0;
            int pointsLoaded = 0;
            String xCoord,yCoord;
            if(inputFile.exists() && inputFile.canRead()){
                try {
                    Scanner scanner = new Scanner(inputFile);
                    while(scanner.hasNext()){
                        input = scanner.nextLine();
                        //Each input is in the (X,Y) format
                        xCoord = input.substring(1, input.indexOf(","));
                        yCoord = input.substring(input.indexOf(",") + 1, input.indexOf(")"));;
                        x = Double.parseDouble(xCoord);
                        y = Double.parseDouble(yCoord);
                        Point2D p = new Point2D.Double(x, y);
                        //No duplicates allowed
                        if(addPoint(p) != 0)
                            JOptionPane.showMessageDialog(null, "This point: "
                            + p.toString() + "already exists, it will not be added again.");
                        else{
                            pointsLoaded++;
                            points.add(p);
                        }
                    }
                } catch (FileNotFoundException ex){
                    JOptionPane.showMessageDialog(null, "Error reading file",
                            "Please make sure the file exists and is "
                            + "a readable text file!", ERROR_MESSAGE);
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Error reading points! Please "
                            + "make sure there is only 1 point per line in the format "
                            + "(X,Y) \n" + pointsLoaded + " points loaded", 
                            "Error Reading Points!", ERROR_MESSAGE);
                }

            }
            return points;
        }
        catch(NullPointerException ex){
            return null;
        }
        
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      savePoints
     * @author          Nasser Najib
     * Description      Constructs a string containing the points, sends it to 
     *                  FileIO for exporting to text file.
     *
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public static void savePoints(){
        
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      print
     * @author          Nasser Najib
     * Description      Calls the PrintUtilities and prints the form.
     * Input
     * @Param           c - component to be printed
     * 
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    static void print(Component c) {
        PrintUtilities.printComponent(c);
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      grahamsMethod
     * @author          Nasser Najib
     * Description      Calls Graham's Algorithm to solve the convex.

     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public static void grahamsMethod(){
        try {
            convex.calculateConvexHull(convex.GRAHAMS_ALGORITHM);
        } catch (ConvexHull.InvalidLengthException ex) {
            
        }
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      giftWrapMethod
     * @author          Nasser Najib
     * Description      calls the gift wrapping algorithm to solve the convex.
     *
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public static void giftWrappingMethod(){
        try {
            convex.calculateConvexHull(convex.GIFT_WRAPPING);
        } catch (ConvexHull.InvalidLengthException ex) {
            
        }
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      plotSize
     * @author          Nasser Najib
     * Description      returns the number of points in the plot.
     *
     * Output
     * @return          int - the size of the graph before it's been solved.
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public static int plotSize(){
        return convex.size();
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      getStatistics
     * @author          Nasser Najib
     * Description      retrieves and returns the statistics from the convex hull
     *
     * Output
     * @return          double[] containing the statistics
     *                  index 0, number of points
     *                  index 1, number of points that make the convex
     *                  index 2, points inside the hull.
     *                  index 3, percent of points inside the convex
     *                  index 4, grahams algorithm run time
     *                  index 5, gift wrapping run time
     * History Log:
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public static double[] getStatistics(){
        return convex.getStats();
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      getLastPoint
     * @author          Nasser Najib
     * Description      returns the last added point

     * Output
     * @return          Point2D - last added point.
     * History Log:
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public static Point2D getLastPoint() {
        return convex.getLastPoint();
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      clear
     * @author          Nasser Najib
     * Description      calls the convex hull clear method
     *
     * History Log:     04/24/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    static void clear() {
        convex.clear();
    }
    static Point2D[] getConvexPoints(){
        return convex.getConvex();
    }


}
