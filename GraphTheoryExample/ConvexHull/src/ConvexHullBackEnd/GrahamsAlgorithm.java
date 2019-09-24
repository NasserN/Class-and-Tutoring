package ConvexHullBackEnd;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Stack;

/**<pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class            GrahamsAlgorithm
 * File             GrahamsAlgorithm.java
 * Description      Solves a convex hull using Grahams algorithm. O(n log(n))
 * @author          Nasser Najib
 * Environment      PC, Windows 10, jdk1.8, NetBeans 8.2
 * Date             04/10/19
 * @version         1.0
 * @see
 * History Log:     04/10/19 - creation.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *</pre>
 */
public class GrahamsAlgorithm {
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      findReferencePoint
     * @author          Nasser Najib
     * Description      Determines the reference point for the convex hull calculation.
     *
     * Input            
     * @param           points - set of points.
     * Output           
     * @return          An integer value containing the index of the reference point.
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private static int findReferencePoint(Point2D[] points){
        int h0 = 0;
        for(int i = 0; i < points.length; i++){
            if(points[i].getY() <= points[h0].getY())
                if(points[i].getX() >= points[h0].getX())
                    h0 = i;
        }
    return h0;
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      grahamScan
     * @author          Nasser Najib
     * Description      Performs the graham scan algorithm and returns the solved
     *                  convex hull points.
     *
     * Input
     * @param           arr - set of points
     * Output
     * @return          ArrayList containing the convex hull points.
     * History Log:     04/10/19 creation/
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public static ArrayList<Point2D> grahamScan(Point2D[] arr) 
            throws ConvexHull.InvalidLengthException{
        
        int h0 = findReferencePoint(arr);
        ArrayList<Point2D> convex = new ArrayList<>();
        HeapSort.sort(arr, h0);
        Stack<Point2D> stack = filterColinear(arr);
        int filteredPointCount = 0;
        if(arr.length - filteredPointCount < 3)
            throw new ConvexHull.InvalidLengthException();
        for(int i = 0; i < arr.length; i++){
            if(convex.size() == 3)
                break;
            else if(arr[i] != null)
                convex.add(arr[i]);
        }
        Point2D refA = convex.get(2);
        Point2D refB = convex.get(1);
        for(int i = 3; i < arr.length; i++){
            if(arr[i] != null){
                if(status(refA, refB, arr[i]) > 0){
                    refB = refA;
                    refA = arr[i];
                    convex.add(arr[i]);
                }
            }
        }
        return convex;
    }
        /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      status
     * @author          Nasser Najib
     * Description      Determines whether a point is above, bellow, or between two other points.
     *
     * Input            
     * @param           p0 - first point on the line
     * @param           p1 - second point on the line
     * @param           p2 - tested point.
     * Output           An integer value that signifies it's position
     *                  1 - point is above
     *                  -1 - point is bellow
     *                  0 - point is between (colinear)
     *
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private static int status(Point2D p0, Point2D p1, Point2D p2){

        double status = (p1.getY() - p0.getY()) * (p2.getX() - p1.getX())
                - (p1.getX() - p0.getX()) * (p2.getY() - p1.getY());
        //BELLOW LINE - CW
        if(status < 0)
            return -1;
        //ABOVE LINE - CCW
        if(status > 0)
            return 1;
        //ON LINE - COLINEAR
        if(status == 0)
            return 0;
        return 0;
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      filterColinear
     * @author          Nasser Najib
     * Description      filters out colinear points, keeping the point furthest
     *                  from the reference point.
     *
     * Input        
     * @param           arr - set of SORTED points.
     * Output
     *
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private static Stack<Point2D> filterColinear(Point2D[] arr) {
        System.out.println("Filter");
        Point2D ref = new Point2D.Double();
        ref = arr[0];
        Stack<Point2D> stack = new Stack<>();
        stack.push(ref);
        for(int i = 1; i < arr.length - 1; i++){
            int status = status(ref,arr[i],arr[i+1]);
            if(status > 0){
                if(arr[i].distance(ref) < arr[i+1].distance(ref)){
                    arr[i] = ref;
                    ref = arr[i+1];
                    if(stack.peek().equals(arr[i+1]))
                        stack.pop();
                    stack.push(arr[i+1]);
                }
                else if(arr[i].distance(arr[0]) > arr[i+1].distance(arr[0])){
                    arr[i+1] = arr[i];
                    if(stack.peek().equals(arr[i]))
                        stack.pop();
                    stack.push(arr[i]);
                }
            }
            else{
                ref = arr[i];
                stack.push(arr[i+1]);
            }
        }
        return stack;
    }
}
