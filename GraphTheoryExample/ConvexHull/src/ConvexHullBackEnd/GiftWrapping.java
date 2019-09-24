/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConvexHullBackEnd;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**<pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class            GiftWrapping
 * File             GiftWrapping.java
 * Description      Contains the gift wrapping algorith for solving a convex hull.
 * @author          Nasser Najib
 * Environment      PC, Windows 10, jdk1.8, NetBeans 8.2
 * Date             4/10/19
 * @version         1.0
 * @see
 * History Log:     4/10: Created
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *</pre>
 */
public class GiftWrapping {
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      findReferencePoint
     * @author          Nasser Najib
     * Description      Finds the starting point, p0, for the gift wrappign algorithm.
     *                  This point is the right-most bottom-most point.
     *
     * Input            
     * @param           Point2d[] points - Set of points
     * Output           int value containing the index of the starting point.
     *
     * History Log:     4/10/19 - creatoin.
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
        System.out.println("REF: " + points[h0]);
        return h0;
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      wrap
     * @author          Nasser Najib
     * Description      Performs the wrapping algorithm to solve the convex hull.
     *
     * Input
     * @param           arr - Set of points. 
     * Output           ArrayList<Point2D> containing the convex hull points.
     *
     * History Log:     04/10/19 - creation.     
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public static ArrayList<Point2D> wrap(Point2D[] arr){
        ArrayList<Point2D> convex = new ArrayList<>();
        int h0 = findReferencePoint(arr);
        int hX = h0;
        do{
            convex.add(arr[hX]);
            int next = (hX + 1)%arr.length;
            for(int i = 0; i < arr.length; i++){
                int stat = status(arr[hX], arr[i], arr[next]);
                if(stat > 0){
                    System.out.println(arr[i]);
                    next = i ;
                }
            }
                hX = next;
        }while(!arr[hX].equals(arr[h0]));
        System.out.println(convex);
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
        if(status < 0)
            return -1;
        if(status > 0)
            return 1;
        if(status == 0)
            return 0;
        return 0;
    }
}