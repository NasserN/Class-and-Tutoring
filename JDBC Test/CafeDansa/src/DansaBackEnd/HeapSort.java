/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DansaBackEnd;

import java.util.ArrayList;

/**<pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
 * Class            HeapSort<br>
 * File             HeapSort.java<br>
 * Description      A heap sort implementation that is generic<br>
 * @author          Nasser Najib<br>
 * Environment      PC, Windows 10, jdk1.8, NetBeans 8.2<br>
 * Date             04/10/19<br>
 * @version         1.0<br>
 * @param <E><br>
 * History Log:     04/10/19 - creation.<br>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *</pre>
 */
public class HeapSort<E extends Comparable> {
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      HeapSort<br>
     * @author          Nasser Najib<br>
     * Description      constructor for the heap object<br>
     *
     * Input            <br>
     * @param           arr - set of objects to sort<br>
     * Output<br>
     *
     * History Log:     04/10/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    ArrayList<E> arr;
    public HeapSort (ArrayList<E> arr){
        this.arr = arr;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      sort<br>
     * @author          Nasser Najib<br>
     * Description      Predetermines the heap then passes to heapify for sorting.<br>
     * History Log:<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    public void sort(){
        //This should create the initial heap
        for (int i = arr.size() / 2 - 1; i >= 0; i--) 
            heapify(arr, arr.size(), i);  
        //This is what sorts the heap by breaking it into smaller heaps
        for (int i = (arr.size() - 1); i >= 0; i--) { 
            E temp = arr.get(0); 
            arr.set(0, arr.get(i));
            arr.set(i, temp);
            heapify(arr, i, 0); 
        }
    }
    /**<pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      heapify<br>
     * @author          Nasser Najib<br>
     * Description      Determines the sorted array of objects<br>
     *
     * Input            <br>
     * @param           arr - array of objects to be sorted<br>
     * @param           heapLength - length of the predetermined heap<br>
     * @param           i - starting index<br>
     * Output           No return value.<br>
     *
     * History Log:     04/10/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *</pre>
     */
    private void heapify(ArrayList<E> arr, int heapLength, int i) { 
          int largest = i;
          int leftIndex = 2*i+1;
          int rightIndex = 2*i+2;
          if(leftIndex < heapLength && arr.get(leftIndex).compareTo(arr.get(largest)) >= 1){
              largest = leftIndex;
          }
          if(rightIndex < heapLength && arr.get(rightIndex).compareTo(arr.get(largest)) >= 1){
              largest = rightIndex;
          }
          if(largest != i){
              E temp = arr.get(i); 
              arr.set(i, arr.get(largest));
              arr.set(largest, temp);
              heapify(arr, heapLength, largest);
          }
    }
}
