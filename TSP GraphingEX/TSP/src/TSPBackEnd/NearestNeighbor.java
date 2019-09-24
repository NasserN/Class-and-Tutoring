
package TSPBackEnd;

import java.util.ArrayList;
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
 * Class            NearestNeighbor<br>
 * File             NearestNeighbor.java<br>
 * Description      Solves the TSP using the nearest neighbor, greedy edge algorithm<br>
 *
 * @author Nasser Najib Environment PC, Windows 10, jdk1.8, NetBeans 8.2 Date<br>
 * @version 1.0
 */
public class NearestNeighbor {    
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      findNearestNeighbor<br>
     * @author          Nasser Najib<br>
     * Description      Finds the nearest neighbor solution, returns paths in an arraylist<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    public static ArrayList<Path> findNearestNeighbor(ArrayList<Location> p){
        ArrayList<Path> paths = new ArrayList<>();
        Path nearest = null, comp = null;
        Location curr = p.get(0), next = null, lastVisited = null;
        for(int j = 0; j < p.size(); j++){
            comp = nearest;
            nearest = null;
            for(int i = 0; i < p.size(); i++){
                next = p.get(i);
                if(!next.isVisited() && !next.equals(curr)){
                    if(comp == null || !comp.getHead().equals(next)){
                        comp = new Path(curr, next);
                        if(nearest == null){
                            nearest = comp;
                            lastVisited = next;
                        }
                        else if(comp.getDistance() < nearest.getDistance()){
                            nearest = comp;
                            lastVisited = next;
                        }
                    }
                }
            }
            lastVisited.setVisited(true);
            curr = lastVisited;
            paths.add(nearest);
        }
        resetVisited(p);
        return paths;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      resetedVisited<br>
     * @author          Nasser Najib<br>
     * Description      Resets the visited status of each point so they can be reused<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    private static void resetVisited(ArrayList<Location> p) {
        for(int i = 0; i < p.size(); i++)
            p.get(i).setVisited(false);
        
    }
}
