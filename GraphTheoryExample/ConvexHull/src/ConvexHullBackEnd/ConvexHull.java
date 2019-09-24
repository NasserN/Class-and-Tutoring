
package ConvexHullBackEnd;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**<pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class            ConvexHull
 * File             ConvexHull.java
 * Description      Creates convex hull object
 * @author          Nasser Najib
 * Environment      PC, Windows 10, jdk1.8, NetBeans 8.2
 * Date             04/10/19
 * @version         1.0
 * @see
 * History Log:     04/10/19 - creation.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *</pre>
 */
public class ConvexHull {

    public Point2D getLastPoint() {
        if(size != 0)
            return points.get(size);
        return null;
    }
    //class level variables
    private ArrayList<Point2D> points;
    private ArrayList<Point2D> convexPoints;
    private int size;
    private double grahamsTime, wrapTime;
    public final int GRAHAMS_ALGORITHM = 1;
    public final int GIFT_WRAPPING = 2;
    
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      ConvexHull
     * @author          Nasser Najib
     * Description      Default constructor, initializes variables.

     *
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public ConvexHull(){
        convexPoints = new ArrayList<>();
        points = new ArrayList<>();
        size = 0;
        grahamsTime = 0;
        wrapTime = 0;
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      addPoint
     * @author          Nasser Najib
     * Description      Adds a point to teh set
     *
     * Input        
     * @param           p - A Point2D object to be added to the set.
     * Output
     * @retrun          int signifying whether addig was successful or not.
     * History Log:
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public int addPoint(Point2D p){
        if(linearSearch(p) != 0)
            return -1;
        points.add(p);
        size++;
        return 0;
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      getPoints
     * @author          Nasser Najib
     * Description      Accessor to retrieve a copy of the points.
     *
     * Output
     * @return          Point2D[] containing the points.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public Point2D[] getPoints(){
        Point2D [] ret = new Point2D[points.size()];
        points.toArray(ret);
        return ret;
    }
        /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      getAdded
     * @author          Nasser Najib
     * Description      Accessor to retrieve a copy of the calculated convex points
     *
     * Output
     * @return          Point2D[] containing the points.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public Point2D[] getConvex(){
        Point2D[] ret = new Point2D[convexPoints.size()];
        convexPoints.toArray(ret);
        return ret;
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      calculatedConvexHull
     * @author          Nasser Najib
     * Description      calculates the convex hull, can use one of two methods to do so.
     *
     * Input
     * @param           mode - an integer, either 1 or 2, signiifying the, method to use.
     * Output
     *
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public int calculateConvexHull(int mode) throws InvalidLengthException{
        if(points.size() >= 3){
            Point2D[] convex = new Point2D[points.size()];
            points.toArray(convex);
            long endTime;
            long startTime;
            if(mode == GRAHAMS_ALGORITHM){
                startTime = System.nanoTime();
                convexPoints = GrahamsAlgorithm.grahamScan(convex);
                endTime = System.nanoTime();
                grahamsTime = endTime - startTime;
            }
            else if(mode == GIFT_WRAPPING){
                startTime = System.nanoTime();
                convexPoints = GiftWrapping.wrap(convex);
                endTime = System.nanoTime();
                wrapTime = endTime - startTime;
            }
        }
        else
            throw new InvalidLengthException();
        return -1;
    }
    public String printConvexPoints(){
        return null;
    }
    public String printPoints(){
        return null;
    }
    private int linearSearch(Point2D p){
        for(int i = 0; i < points.size(); i++){
            if(p.equals(points.get(i)))
                return -1;
        }
        return 0;
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      size
     * @author          Nasser Najib
     * Description      accessor to retrieve the size of the set of points
     * 
     * Output           int - the size.
     *
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public int size() {
        return size;
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      getConvexSize
     * @author          Nasser Najib
     * Description      retrieves the number of calculated convex points.
     *
     * Output           int - the size.
     *
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public int getConvexSize(){
        return convexPoints.size();
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      getStats
     * @author          Nasser Najib
     * Description      Calculates the stats and returns them in an array.
     * 
     * Output
     * @return          double[] containing all the stats.
     *                  index 0, number of points
     *                  index 1, number of points that make the convex
     *                  index 2, points inside the hull.
     *                  index 3, percent of points inside the convex
     *                  index 4, grahams algorithm run time
     *                  index 5, gift wrapping run time
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public double[] getStats(){
        double[] stats = new double[6];
        stats[0] = points.size();
        stats[1] = convexPoints.size();
        stats[2] = points.size() - convexPoints.size();
        if(size == 0)
            stats[3] = 0;
        else
            stats[3] = (size - convexPoints.size())/size;
        stats[4] = grahamsTime;
        stats[5] = wrapTime;
        return stats;
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      clear
     * @author          Nasser Najib
     * Description      Resets the object. Clears all variables and sets them
     *                  back to default values.

     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public void clear(){
        points.clear();
        convexPoints.clear();
        size = 0;
        grahamsTime = 0;
        wrapTime = 0;
    }

    public static class InvalidLengthException extends Exception {

        public InvalidLengthException() {
            super("Invalid size, must have at least 3 points.");
        }
    }
}
