
package TSPBackEnd;

import java.util.Objects;
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
 * Class            Location<br>
 * File             Location.java<br>
 * Description      Location object, contains name, X coordinate and Y coordinate.<br>
 *
 * @author Nasser Najib Environment PC, Windows 10, jdk1.8, NetBeans 8.2 Date<br>
 * @version 1.0
 */
public class Location {
    //private fields
   private boolean visited;
   private String name;
   private double x, y;
   int degree;
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      Location<br>
     * @author          Nasser Najib<br>
     * Description      Default Constructor<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
   public Location(){
       visited = false;
       name = "";
       x = 0;
       y = 0;
       degree = 0;
   }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      Location<br>
     * @author          Nasser Najib<br>
     * Description      Overlaoded Constructor<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
   public Location(String name, double x, double y){
       degree = 0;
       visited = false;
       this.name = name;
       this.x = x;
       this.y = y;
   }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getX<br>
     * @author          Nasser Najib<br>
     * Description      Accessor for the X Coordinate<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
   public double getX(){
       return x;
   }
   
       /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getY<br>
     * @author          Nasser Najib<br>
     * Description      Accessor for the Y Coordinate<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
   public double getY(){
       return y;
   }
       /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getName<br>
     * @author          Nasser Najib<br>
     * Description      Accessor for the location Name<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
   public String getName(){
       return name;
   }
       /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      isVisited<br>
     * @author          Nasser Najib<br>
     * Description      Accessor for the visited status<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
   boolean isVisited(){
       return visited;
   }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      incrementDegree<br>
     * @author          Nasser Najib<br>
     * Description      mutator to incerement the degree<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
   public void incrementDegree(){
       degree = degree + 1;
   }
   /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      decrementDegree<br>
     * @author          Nasser Najib<br>
     * Description      mutator to decerement the degree<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
   public void decrementDegree(){
       degree = degree - 1;
   }
   /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getDegree<br>
     * @author          Nasser Najib<br>
     * Description      accessor for the degree<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
   public int getDegree(){
       return degree;
   }
   /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      resetDegree<br>
     * @author          Nasser Najib<br>
     * Description      rest for the degree<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
   public void resetDegree(){
       degree = 0;
   }
    /**
     *
     * @param o
     * @return
     */
    @Override
   public boolean equals(Object o){
       if(getClass() != o.getClass())
           return false;
       Location comp = (Location) o;
       if(name.equals(comp.name))
           return true;                 //no two locations with the same name.
       if(name.equals(comp.name) && x == comp.x && y == comp.y)
           return true;
       return false;
   }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    void setVisited(boolean set) {
        visited = set;
    }
    @Override
    public String toString(){
        return name + " " + x + " " + y;
    }


}