
package TSPBackEnd;

import java.util.ArrayList;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
 * Class            SortedEdges<br>
 * File             SortedEdges.java<br>
 * Description      Sorted edges algorithm for solving the traveling salesman problem<br>
 *
 * @author Nasser Najib <br>
 * Environment PC, Windows 10, jdk1.8, NetBeans 8.2 <br>
 * Date             06/01/19<br>
 * @version 1.0
 */
public class SortedEdges {
    private static ArrayList<Path> paths = new ArrayList<>();
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      calculateSortedEdges<br>
     * @author          Nasser Najib<br>
     * Description      Calling this returns a solution to the TSP in an array list,
     * utilizes heapsort for sorting the line segments.<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @param locations
     * @return ArrayList
     */
    public static ArrayList<Path> calculateSortedEdges(ArrayList<Location> locations){
        //generate all possible paths
        generatePaths(locations);
        HeapSort<Path> sort = new HeapSort<>(paths);
        //sort by increasing cost
        sort.sort();
        Path prev = paths.get(0);
        //traverse and compare
        for(int i = 0; i < paths.size(); i++){
            Path curr = paths.get(i);
            Location head = curr.getHead();
            Location tail = curr.getTail();
            if(completesCircuit(curr, i, locations.size())){
                paths.remove(i);
                i--;
            }
            else if((head.getDegree() >= 2)){
                paths.remove(i);
                i--;
            }
            else if((tail.getDegree() >= 2)){
                paths.remove(i);
                i--;
            }
            else{
                head.incrementDegree();
                tail.incrementDegree();
            }                
        }
        //clean up
        resetDegrees(locations);  
        return paths;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      generatePaths<br>
     * @author          Nasser Najib<br>
     * Description      Generates all possible paths, no duplicates. Used for testing.<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    private static void generatePaths(ArrayList<Location> locations) {
        paths.clear();
        for(int i = 0; i < locations.size() - 1; i++){
            Location a = locations.get(i);
            for(int j = i + 1; j < locations.size(); j++){
                Location b = locations.get(j);
                Path temp = new Path(a, b);
                paths.add(temp);
            }
        }
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      completesCircuit<br>
     * @author          Nasser Najib<br>
     * Description      Determines whether a line segment will complete the circuit<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    private static boolean completesCircuit(Path curr, int index, int max){
        if(index < 2)
            return false;
        int matchCount = 0;
        int openEnds = 0;
        if(curr.getHead().getDegree() >= 1)
            matchCount++;
        if(curr.getTail().getDegree() >= 1)
            matchCount++;
        //count open ends
        for(int i = index; i > 0; i--){
            Path comp = paths.get(i);
            if(comp.getHead().getDegree() < 2)
                openEnds++;
            if(comp.getTail().getDegree() < 2)
                openEnds++;
        }
        //triangles are a special case
        if (index == 2 && matchCount == 2)
            return true;
        //last line should complete the circuit, work around to prevent it triggering
        if(index == max && openEnds == 0)
            return false;
        //short circuit if there are less than 2 open ends at all times
        if (matchCount >= 2 && openEnds < 2)
            return true;
        return false;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      resetDegrees<br>
     * @author          Nasser Najib<br>
     * Description      Resets the degree counts to allow the points to be solved again without issue.<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    private static void resetDegrees(ArrayList<Location> locations){
        for(int i = 0; i < locations.size(); i++)
            locations.get(i).resetDegree();
    }
}