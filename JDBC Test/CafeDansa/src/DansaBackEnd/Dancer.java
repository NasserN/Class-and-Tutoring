/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
 * Class        Dancer<br>
 * File         Dancer.java<br>
 * Description  Dancer object, stores basic information about dancers<br>
 *
 * @author Nasser Najib Environment PC, Windows 10, jdk1.8, NetBeans 8.2 Date<br>
 * @version 1.0
 */
package DansaBackEnd;
public class Dancer implements Comparable {
    //class level variables
    String firstName, lastName, phone, skill, style, email;
    int years, compareMode = 0;
    
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      Dancer<br>
     * @author          Nasser Najib<br>
     * Description      Default constructor, initializes variables<br>
     * History Log:     05/15/19 - creation<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     */
    public Dancer(){
        //initalize variables
        firstName = "";
        lastName = "";
        phone = "";
        skill = "";
        style = "";
        email = "";
        years = 0;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      Dancer<br>
     * @author          Nasser Najib<br>
     * Description      overloaded constructor, initializes variables to passed args<br>
     * History Log:     05/15/19 - creation<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @param firstName
     * @param lastName
     * @param style
     * @param skill
     * @param years
     * @param phone
     * @param email
     */
    public Dancer(String firstName, String lastName, String style,
            String skill, int years, String phone, String email){
        //initialize variable to argument values
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.skill = skill;
        this.style = style;
        this.email = email;
        this.years = years;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getFirstName<br>
     * @author          Nasser Najib<br>
     * Description      accessor for the dancers first name<br>
     * History Log:     05/15/19 - creation<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @return 
     */
    public String getFirstName(){
        return firstName;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getLastName<br>
     * @author          Nasser Najib<br>
     * Description      acccessor for the dancers last name<br>
     * History Log:     05/15/19 - creation.
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * </pre>
     * @return 
     */
    public String getLastName(){
        return lastName;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getSkill<br>
     * @author          Nasser Najib<br>
     * Description      accessor for the dancers proficiency level<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @return 
     */
    public String getSkill(){
        return skill;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getStyle<br>
     * @author          Nasser Najib<br>
     * Description      accessor for the dancers style<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @return 
     */
    public String getStyle(){
        return style;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getEmail<br>
     * @author          Nasser Najib<br>
     * Description      accessor for the dancers email address<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @return 
     */
    public String getEmail(){
        return email;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getPhone<br>
     * @author          Nasser Najib<br>
     * Description      accessor for the dancers phone number<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @return 
     */
    public String getPhone() {
        return phone;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      getYears<br>
     * @author          Nasser Najib<br>
     * Description      accessor for the number of years a dancer has danced<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @return 
     */
    public int getYears() {
        return years;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      setFirstName<br>
     * @author          Nasser Najib<br>
     * Description      mutator for the dancer's first name<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @param first
     */
    public void setFirstName(String first){
        firstName = first;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      setLastName<br>
     * @author          Nasser Najib<br>
     * Description      mutator for the dancers last name<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @param last
     */
    public void setLastName(String last){
        lastName = last;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      setPhoneNumber <br>
     * @author          Nasser Najib<br>
     * Description      mutator for the dancer's phone number<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber){
        phone = phoneNumber;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      setYears<br>
     * @author          Nasser Najib<br>
     * Description      mutator for the dancer's number of years dancing<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @param years
     */
    public void setYears(int years){
        this.years = years;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      setStyle<br>
     * @author          Nasser Najib<br>
     * Description      mutator for the style of dancing<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @param style
     */
    public void setStyle(String style){
        this.style = style;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      setSkill<br>
     * @author          Nasser Najib<br>
     * Description      mutator for the dancer's proficiency level<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @param skill
     */
    public void setSkill(String skill){
        this.skill = skill;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      setEmail<br>
     * @author          Nasser Najib<br>
     * Description      mutator for the dancer's email address<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      toString<br>
     * @author          Nasser Najib<br>
     * Description      returns a strign representation of the dancer<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @return 
     */
    @Override
    public String toString(){
        return firstName + "," + lastName + "," + style + "," + skill + "," + years + 
                "," + phone + "," + email;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      setCompareMode<br>
     * @author          Nasser Najib<br>
     * Description      sets field to compare dancers by.<br>
     *                      0 = first name<br>
     *                      1 = last name<br>
     *                      2 = years experience<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @param mode
     */
    public void setCompareMode(int mode){
        if(mode > 2)
            mode = 0;
        compareMode = mode;
    }
    /** <pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
     * Method Name      compareTo<br>
     * @author          Nasser Najib<br>
     * Description      Compares two objects values<br>
     * History Log:     05/15/19 - creation.<br>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * </pre>
     * @param t
     * @return 
     */
    @Override
    public int compareTo(Object t){
        Dancer d;
        int ret = 0;
        if(getClass() != t.getClass())
            return -1;
        d = (Dancer)t;
        if(compareMode == 0)
            ret = firstName.compareTo(d.getFirstName());
        if(compareMode == 1)
            ret = lastName.compareTo(d.getLastName());
        if(compareMode == 2){
            if(years < d.getYears())
                return -1;
            else if(years == d.getYears())
                return 0;
            else
                return 1;
        }
        return ret;
    }
}