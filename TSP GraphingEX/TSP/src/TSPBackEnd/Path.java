
package TSPBackEnd;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class        Path
 * File         Path.Java
 * Description      Path object, contains two locations and a distance
 *
 * @author Nasser Najib Environment PC, Windows 10, jdk1.8, NetBeans 8.2 Date
 * @version 1.0
 */
public class Path implements Comparable {
    double distance;
    Location a, b;
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      Path<br>
     * @author          Nasser Najib<br>
     * Description      Default constructor<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    public Path(){
        a = null;
        b = null;
        distance = 0;
        
    }
     /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      Path<br>
     * @author          Nasser Najib<br>
     * Description      OVERLOADED constructor<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    public Path(Location a, Location b){
        this.a = a;
        this.b = b;
        distance = calculateDistance();
    }
    
    private double calculateDistance() {
        double x1, x2, y1, y2, dist;
        x1 = a.getX();
        x2 =  b.getX();
        y1 = a.getY();
        y2 = b.getY();
        dist = ((x2*x2) - (x1*x1)) + ((y2*y2)-(y1*y1));
        dist = Math.sqrt(Math.abs(dist));
        return dist;
    }
    public double getDistance(){
        return distance;
    }
    @Override
    public String toString(){
        String ret = "";
        ret = a.getName() + " ----> " + b.getName() + " Cost: " + distance;
        return ret;
    }
    public Location getHead(){
        return a;
    }
    public Location getTail(){
        return b;
    }

    @Override
    public int compareTo(Object t) {
        Path p;
        if(getClass() != t.getClass())
            return -1;
        p = (Path) t;
        if(p.getDistance() > this.distance)
            return -1;
        if(p.getDistance() < this.distance)
            return 1;
        if(p.getDistance() == this.distance)
            return 0;
        return -1;
    }
}
