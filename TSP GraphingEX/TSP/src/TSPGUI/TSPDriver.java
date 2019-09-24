/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
 * Class        TSPDriver<br>
 * File         TSPDriver.java<br>
 * Description  Driver class for the Traveling salesman problem, buffer for the GUI and the back end magic<br>
 *
 * @author Nasser Najib Environment PC, Windows 10, jdk1.8, NetBeans 8.2 <br>
 * Date         06/01/19<br>
 * @version 1.0<br>
 */
package TSPGUI;

import TSPBackEnd.FileIO;
import TSPBackEnd.Location;
import TSPBackEnd.NearestNeighbor;
import TSPBackEnd.Path;
import TSPBackEnd.PrintUtilities;
import TSPBackEnd.SortedEdges;
import TSPBackEnd.Validation;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author Nasser Najib
 */
public class TSPDriver {
    static long nearestNeighborTime = 0;
    static long sortedEdgeTime = 0;
    static StringTokenizer tokenizer;
    static Validation validator = new Validation();
    static TSPGUI gui = new TSPGUI();
    static ArrayList<Location> locations = new ArrayList<>();
    static ArrayList<Path> paths = new ArrayList<>();
    public static void main(String[] args) {
        gui.display();
        //createPaths();
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      loadFromFile<br>
     * @author          Nasser Najib<br>
     * Description      Reads location information from a text, sends it for <br>
     * validation, then stores it in an ArrayList<br>
     * History Log:<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * </pre>
     */
    public static void loadFromFile(){
        FileIO load = new FileIO("Text File" , "txt");
        try{
            //traverse the file
            Scanner scanner = new Scanner(load.loadFile());
            String input = "";
            while(scanner.hasNext()){
                input = scanner.nextLine();
                //validates and adds to array list
                parseInput(input);
            }
        }
        //error in format
        catch(NoSuchElementException ex){
            JOptionPane.showMessageDialog(null, "Wrong file format, file should be formatted as:"
                    + "\nlocationName locationXCoordinate locationYCoordinate\n"
                    + "(ex. Seattle 33 45)","Error loading points!", ERROR_MESSAGE);
            
        }
        catch(FileNotFoundException ex){
            System.out.println("Err");
        }
        catch(NullPointerException ex){
            System.out.println("No file selected");
        }
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      parseInput<br>
     * @author          Nasser Najib<br>
     * Description      Processes inputs, validates input, if valid theyre added to the array list<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * </pre>
     */
    private static void parseInput(String input) throws NoSuchElementException{
        //delimited by spaces
        tokenizer = new StringTokenizer(input, " ");
        Location loc = new Location();
        String name = "", locX = "", locY = "";
        while(tokenizer.hasMoreTokens()){
            name = tokenizer.nextToken();
            locX = tokenizer.nextToken();
            locY = tokenizer.nextToken();
        }
        //validate
        if(validator.isLettersOnly(name) && validator.isNumeric(locX) && validator.isNumeric(locY)){
            loc = new Location(name, Double.parseDouble(locX), Double.parseDouble(locY));
        }
        //filter out duplicates
        if(!locations.contains(loc)){
            locations.add(loc);
        }
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      printForm<br>
     * @author          Nasser Najib<br>
     * Description      Pritns off a screenshot of the form<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    static void printForm(TSPGUI aThis) {
        PrintUtilities.printComponent(aThis);
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getLocations<br>
     * @author          Nasser Najib<br>
     * Description      accessor method for the locations<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    public static ArrayList<Location> getLocations(){
        return locations;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      calculateNN<br>
     * @author          Nasser Najib<br>
     * Description      Calculates the tour using the nearest neighbor method<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    public static ArrayList<Path> calculateNN(){
        //empty
        if(locations.isEmpty()){
            errorCalculating();
            return null;
        }
        //for statistics
        long startTime = System.nanoTime();
        paths = NearestNeighbor.findNearestNeighbor(locations);
        nearestNeighborTime = System.nanoTime() - startTime;
        return paths;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      calculateSortedEdge<br>
     * @author          Nasser Najib<br>
     * Description      calculates the tour using the sorted edge algorithm<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    public static ArrayList<Path> calculateSortedEdge(){
        //empty
        if(locations.isEmpty()){
            errorCalculating();
            return null;
        }
        //for statistics
        long startTime = System.nanoTime();
        paths = SortedEdges.calculateSortedEdges(locations);
        sortedEdgeTime = System.nanoTime() - startTime;
        return paths;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      errorCalculating<br>
     * @author          Nasser Najib<br>
     * Description      Handles errors while calculating the tour, just shows a message dialog<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    private static void errorCalculating(){
        JOptionPane.showMessageDialog(null, "No ponits have been loaded, tour cannot be calculated!", 
                "Error calculating tour!", ERROR_MESSAGE);
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getCost<br>
     * @author          Nasser Najib<br>
     * Description      Accessor for the cost of the tour<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    public static int getCost(){
        if(paths.isEmpty()){
            errorCalculating();
            return 0;
        }
        int cost = 0;
        for(int i = 0; i < paths.size(); i++)
            cost += paths.get(i).getDistance();
        return cost;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getNearestNeighborTime<br>
     * @author          Nasser Najib<br>
     * Description      Accessor for the NN algorithms stats<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    public static long getNearestNeighborTime(){
        return nearestNeighborTime;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getSortedEdgeTime<br>
     * @author          Nasser Najib<br>
     * Description      Accessor for the SE algorithm statistic<br>
     * History Log:06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    public static long getSortedEdgeTime(){
        return sortedEdgeTime;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * Method Name      clear
     * @author          Nasser Najib
     * Description      clears the locations and solutions
     * History Log:     06/01/19
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    static void clear() {
        paths.clear();
        locations.clear();
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      generateRandomPoints<br>
     * @author          Nasser Najib<br>
     * Description      Generates random points, checks to prevent duplicates<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    static void generateRandomPoints(int quantity, double min, double max) {
        for(int i = 0; i < quantity; i++){
            char randChar = (char) ((Math.random() * ((90 - 65) + 1)) + 65);
            double randX = (Math.random() * ((max - min) + 1)) + min;
            double randY = (Math.random() * ((max - min) + 1)) + min;
            Location temp = new Location(String.valueOf(randChar), randX, randY);
            if(locations.contains(temp))
                i--;
            else
                locations.add(temp);
        }
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      saveToFile<br>
     * @author          Nasser Najib<br>
     * Description      Sends current set of points to be saved to a text file.<br>
     * History Log:     06/01/19<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    static void saveToFile() {
        String[] locs = new String[locations.size()];
        for(int i = 0; i < locs.length; i++)
            locs[i] = locations.get(i).toString();
        FileIO output = new FileIO("Text File", "txt");
        output.saveFile(locs);
    }
}
