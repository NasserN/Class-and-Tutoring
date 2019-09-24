package DansaBackEnd;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
 * Class        DansaDB<br>
 * File         DansaDB.Java<br>
 * Description  Handles all communication with the SQL database, this class builds
 *              the tables, populates them, modifies them, and mines them.<br>
 *
 * @author Nasser Najib Environment PC, Windows 10, jdk1.8, NetBeans 8.2 Date<br>
 * @version 1.0
 */
public class DansaDB {
    private final String URL = "jdbc:mysql://localhost/DansaDB", 
            USERNAME = "scott", PASSWORD = "tiger";
    private Statement stmt;
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      DansaDB<br>
     * @author          Nasser Najib<br>
     * Description      Default constructor, this initializes the database<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    public DansaDB(){
        initializeJDBC();
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      establishConnection<br>
     * @author          Nasser Najib<br>
     * Description      creates and returns the connection to the database<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    private Connection establishConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");  //load class driver
        Connection con = DriverManager.getConnection(URL + "?createDatabaseIfNotExist=true", 
                USERNAME, PASSWORD);  //open connection
        return con;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      initializeJDBS<br>
     * @author          Nasser Najib<br>
     * Description      Checks if tables exist, if they do NOT then they are created<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    private int initializeJDBC(){
        try{
            Connection con = establishConnection();
            stmt = con.createStatement();
            DatabaseMetaData dbmd = con.getMetaData();
            try{
                ResultSet tables = dbmd.getTables(null, null, "Dancers", null);
                //create new tables
                if(!tables.next())
                    stmt.executeUpdate("CREATE TABLE Dancers (PK INTEGER(10) AUTO_INCREMENT, firstName" +
                            " VARCHAR(25), lastName VARCHAR(25), danceStyleFK INTEGER, "
                            + "proficiencyFK INTEGER, yearsDancing INTEGER, "
                            + "phoneNumber VARCHAR(15), email VARCHAR(50), PRIMARY KEY(PK))");
                tables = dbmd.getTables(null, null, "DanceStyles", null);
                if(!tables.next())
                    stmt.executeUpdate("CREATE TABLE DanceStyles (PK INTEGER(10) AUTO_INCREMENT,"
                            + "danceStyle VARCHAR(25), PRIMARY KEY(PK))");
                tables = dbmd.getTables(null, null, "DanceLevels", null);
                if(!tables.next())
                    stmt.executeUpdate("CREATE TABLE DanceLevels (PK INTEGER(10) AUTO_INCREMENT, "
                            + "proficiency VARCHAR(25), PRIMARY KEY(PK))");
            }
            catch(SQLException ex){
                ex.printStackTrace();
                return -1;
            }
            con.close();
        }
        catch(Exception e){
            return -1;
        }
        return 0;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      addDancer<br>
     * @author          Nasser Najib<br>
     * Description      Adds dancer to the database<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    public int addDancer(Dancer dancer){
        try {
            Connection con = establishConnection();
            stmt = con.createStatement();
            if(duplicateCheck(dancer)){
                con.close();
                stmt.close();
                return -1;
            }
            //get PKs for foreign tables
            int styleKey = getDanceKey(dancer.getStyle());
            int levelKey = getLevelKey(dancer.getSkill()); //should update to FK links
            stmt.execute("INSERT INTO dancers (firstName, lastName, danceStyleFK, "
                    + "proficiencyFK, yearsDancing, phoneNumber, email) VALUES (" 
                    + "'" + dancer.getFirstName() + "', '" + dancer.getLastName() 
                    + "', " + styleKey + ", " + levelKey 
                    + ", " + dancer.getYears() + ", '" + dancer.getPhone() 
                    + "', '"+ dancer.getEmail() + "')");
            return 0;
        } 
        catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        //return 0;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      updateDancer<br>
     * @author          Nasser Najib<br>
     * Description      modifies the data pertaining to a specified dancer<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @param original
     * @param update
     * @return 
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public int updateDancer(Dancer original, Dancer update) throws ClassNotFoundException, SQLException{
        Connection con = establishConnection();
        stmt = con.createStatement();
        if(duplicateCheck(update))
            return -1;
        ResultSet rs = search(original);
        rs.next();
        int dancerKey = rs.getInt("PK");
        System.out.println(dancerKey);
        int levelKey = getLevelKey(update.getSkill());
        int styleKey = getDanceKey(update.getStyle());
        
        //execute
        stmt.execute("UPDATE dancers SET firstName = '"
                + update.getFirstName() + "', lastName = '" + update.getLastName()
                + "', danceStyleFK = " + styleKey + ", proficiencyFK = " + levelKey
                + ", yearsDancing = " + update.getYears() + ", phoneNumber = '" 
                + update.getPhone() + "', email = '" + update.getEmail() + "' WHERE PK = " + dancerKey);
        return 0;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      search<br>
     * @author          Nasser Najib<br>
     * Description      This method searches through the database and returns a
     *                  ResultSet object containing the search results<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    private ResultSet search(Dancer comp) throws ClassNotFoundException, SQLException{
        Connection con = establishConnection();
        int styleKey = getDanceKey(comp.getStyle());
        int levelKey = getLevelKey(comp.getSkill());
        
        //execute
        String q = "SELECT * FROM dancers WHERE firstName "
                + "= '" + comp.getFirstName() + "' and lastName = '" + comp.getLastName() +
                "' and danceStyleFK = " + styleKey + " and proficiencyFK = " + levelKey +
                " and yearsDancing = " + comp.getYears() + " and phoneNumber = '" +
                comp.getPhone() + "' and email = '" + comp.getEmail() + "'";
        System.out.println(q);
        ResultSet rs = stmt.executeQuery(q);
        return rs;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      duplicateCheck<br>
     * @author          Nasser Najib<br>
     * Description      Checks if a member already exists within the database
     *                      returns true if the member exists, false otherwise<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    private boolean duplicateCheck(Dancer comp) throws ClassNotFoundException, SQLException{
        ResultSet rs = search(comp);
        return rs.next();
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getLevelKey<br>
     * @author          Nasser Najib<br>
     * Description      Locates a proficiency level inside the database and returns
     *                  the primary key referring to that.<br>
     *                      --TO DO: UPDATE TO PK/FK REFERENCING<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * </pre>
     */
    private int getLevelKey(String level) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM DanceLevels WHERE proficiency = '"
                    + level + "'");
            if(!rs.next()){
                stmt.execute("INSERT INTO DanceLevels(proficiency) VALUES('" + level + "')");
                return getLevelKey(level);
            }
            else{
                return rs.getInt("PK");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DansaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getDanceKey<br>
     * @author          Nasser Najib<br>
     * Description      Locates a dance style within the database and returns the
     *                  primary key referring to that.<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    private int getDanceKey(String style) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM DanceStyles WHERE danceStyle = '"
                    + style + "'");
            if(!rs.next()){
                stmt.execute("INSERT INTO DanceStyles(danceStyle) VALUES ('" +
                        style + "')");
                return getDanceKey(style);
            }
            else{
                return rs.getInt("PK");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DansaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getDancers<br>
     * @author          Nasser Najib<br>
     * Description      Selects all dancers from the table and returns them in
     *                  an arraylist object.<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @return          ArrayList 
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public ArrayList<Dancer> getDancers() throws SQLException, ClassNotFoundException{
        Connection con = establishConnection();
        ArrayList<Dancer> dancers = new ArrayList();
        stmt = con.createStatement();
        String first = "", last = "", style = "", level = "", phone = "", email = "";
        int styleKey, levelKey, exp = 0;
        int count = 0;
        ResultSet rs = stmt.executeQuery("SELECT * FROM dancers");
        while(rs.next()){
            System.out.println(++count);
            first = rs.getString("firstName");
            last = rs.getString("lastName");
            styleKey = rs.getInt("danceStyleFK");
            levelKey = rs.getInt("proficiencyFK");
            phone = rs.getString("phoneNumber");
            email = rs.getString("email");
            exp = rs.getInt("yearsDancing");
            style = getStyle(styleKey);
            level = getLevel(levelKey);
            Dancer add = new Dancer(first,last,style,level,exp,phone,email);
            dancers.add(add);
        }
        con.close();
        stmt.close();
        return dancers;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getStyle<br>
     * @author          Nasser Najib<br>
     * Description      returns the string associated with the danceStyles primary key<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    private String getStyle(int pK) throws SQLException, ClassNotFoundException{
        Connection con = establishConnection();
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM DanceStyles WHERE PK = " + pK);
        rs.next();
        return rs.getString("danceStyle");
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getLevel<br>
     * @author          Nasser Najib<br>
     * Description      returns the string associated with the proficiency primary key<br>
     * History Log:<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    private String getLevel(int pK) throws SQLException, ClassNotFoundException{
        Connection con = establishConnection();
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM DanceLevels WHERE PK = " + pK);
        rs.next();
        return rs.getString("proficiency");
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      remove<br>
     * @author          Nasser Najib<br>
     * Description      removes a member from the table<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @param delete
     * @return 
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public int remove(Dancer delete) throws ClassNotFoundException, SQLException{
        Connection con = establishConnection();
        stmt = con.createStatement();
        ResultSet rs = search(delete);
        if(!rs.next())
            return 0;
        int dancerKey = rs.getInt("PK");
        stmt.execute("DELETE FROM dancers WHERE PK = " + dancerKey);
        return 0;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      clearDB<br>
     * @author          Nasser Najib<br>
     * Description      Clears all the data in the database<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void clearDB() throws ClassNotFoundException, SQLException{
        Connection con = establishConnection();
        stmt = con.createStatement();
        stmt.execute("TRUNCATE TABLE dancers");
        stmt.execute("TRUNCATE TABLE danceStyles");
        stmt.execute("TRUNCATE TABLE danceLevels");
        //initializeJDBC(); //re-initialize
    }

    
}
