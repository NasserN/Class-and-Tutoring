/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConvexHullBackEnd;

import java.awt.geom.Point2D;
import java.util.Stack;

/**<pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class            HeapSort
 * File             HeapSort.java
 * Description      A heap sort implementation that is specific to sorting 2D points.
 * @author          Nasser Najib
 * Environment      PC, Windows 10, jdk1.8, NetBeans 8.2
 * Date             04/10/19
 * @version         1.0
 * @see
 * History Log:     04/10/19 - creation.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *</pre>
 */
public class HeapSort {
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      sort
     * @author          Nasser Najib
     * Description      Predetermines the heap with respect to the reference point
     *                  then passes to heapify for sorting.
     *
     * Input            
     * @param           arr - set of points to sort
     * @param           p0 - reference point.
     * Output
     *
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    public static void sort(Point2D [] arr, int p0){
        //This should create the initial heap
        for (int i = arr.length / 2 - 1; i >= 0; i--) 
            heapify(arr, arr.length, i, p0);  
        //This is what sorts the heap by breaking it into smaller heaps
        for (int i = (arr.length - 1); i >= 0; i--) { 
            Point2D temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            heapify(arr, i, 0 , p0); 
        }
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      heapify
     * @author          Nasser Najib
     * Description      Determines the sorted array of points with respect to the reference point
     *
     * Input            
     * @param           arr - array of points to be sorted
     * @param           heapLength - length of the predetermined heap
     * @param           i - starting index
     * @param           p0 - index of the reference point
     * Output           No return value.
     *
     * History Log:     04/10/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private static void heapify(Point2D[] arr, int heapLength, int i, int p0) { 
          Point2D ref = arr[p0];
          int largest = i;
          int leftIndex = 2*i+1;
          int rightIndex = 2*i+2;
          if(leftIndex < heapLength && pointCompare(ref, arr[leftIndex], arr[largest]) == -1){
              largest = leftIndex;
          }
          if(rightIndex < heapLength && pointCompare(ref, arr[rightIndex], arr[largest]) == -1){
              largest = rightIndex;
          }
          if(largest != i){
              Point2D swap = arr[i];
              arr[i] = arr[largest];
              arr[largest] = swap;
              heapify(arr, heapLength, largest, p0);
          }
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      pointCompare
     * @author          Nasser Najib
     * Description      Determines whether a point is on, above, or below a line.
     *
     * Input
     * @param           p2 - point to be tested
     * @param           p0 - first end point of the line.
     * @param           p1 - second end point of the line.
     * Output           An integer value representing the points relation to the line.
     *                  -1 - below the line
     *                   1 - abpve the line
     *                   0 - on the line.
     * History Log:
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private static int pointCompare(Point2D p2, Point2D p0, Point2D p1){
        /*
        | A | B |
        |   |   | = A*D - B*C
        | C | D |
        */
        double status = ((p1.getX() - p0.getX()) * (p2.getY() - p0.getY())) - 
                ((p2.getX() - p0.getX()) * (p1.getY() - p0.getY()));
        
        //LEFT TURN/COUNTER-CLOCKWISE
        if(status < 0)
            return -1;
        //RIGHT TURN/CLOCKWISE
        if(status > 0)
            return 1;
        //COLINEAR
        if(status == 0)
            return 0;
        return 0;
    }
}
