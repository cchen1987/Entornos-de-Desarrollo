package crewmanagement;
/**
 * Class Employee
 * @author chao
 */
public class Employee {
    String name;
    String surName;
    String dni;
    Turn[] turn; // the size of the array should be between 0 and 7
    /**
     * Empty constructor with default value
     */
    public Employee(){
        this("","","");
    }
    /**
     * Overloaded constructor with 2 parameters
     * @param name string
     * @param surName string
     */
    public Employee(String name, String surName){
        this("", name == null ? "" : name, surName == null ? "" : surName);
    }
    /**
     * Overloaded constructor with 3 parameters
     * @param name string
     * @param surName string
     * @param dni string
     */
    public Employee(String dni, String name, String surName){
        if (name != null && surName != null && isValidDNI(dni)){
            this.name = name;
            this.surName = surName;
            this.dni = dni;
        }
    }
    /**
     * This method sets the name of the employee
     * @param name string
     */
    public void setName(String name){
        if (name != null){
            this.name = name;
        }
    }
    /**
     * This method returns the name of the employee
     * @return name string
     */
    public String getName(){
        if (name != null) {
            return name;
        }
        return "";
    }
    /**
     * This method sets the surname of the employee
     * @param surName string
     */
    public void setSurname(String surName){
        if (surName != null){
            this.surName = surName;
        }
    }
    /**
     * This method returns the surname of the employee
     * @return surName string
     */
    public String getSurname(){
        if (surName != null) {
            return surName;
        }
        return "";
    }
    /**
     * This method returns the name and surname in upper-case or not, depending on the parameters
     * @param nameInUpperCase boolean
     * @param surNameInUpperCase boolean
     * @return 
     */
    public String getFullName(boolean nameInUpperCase, boolean surNameInUpperCase){
        if (nameInUpperCase && surNameInUpperCase){
            if (name != null && surName != null) {
                return name.toUpperCase() + ", " + surName.toUpperCase();
            }
            else if (name == null && surName != null) {
                return surName.toUpperCase();
            }
            else if (name != null && surName == null) {
                return name.toUpperCase();
            }
            return "";
        }
        else if (nameInUpperCase && ! surNameInUpperCase){
            if (name != null && surName != null) {
                return name.toUpperCase() + ", " + surName;
            }
            else if (name == null && surName != null) {
                return surName;
            }
            else if (name != null && surName == null) {
                return name.toUpperCase();
            }
            return "";
        }
        else if (! nameInUpperCase && surNameInUpperCase){
            if (name != null && surName != null) {
                return name + ", " + surName.toUpperCase();
            }
            else if (name == null && surName != null) {
                return surName.toUpperCase();
            }
            else if (name != null && surName == null) {
                return name;
            }
            return "";
        }
        else {
            if (name != null && surName != null) {
                return name + ", " + surName;
            }
            else if (name == null && surName != null) {
                return surName;
            }
            else if (name != null && surName == null) {
                return name;
            }
            return "";
        }
    }
    /**
     * This method sets the dni of the employee
     * @param dni string
     */
    public void setDNI(String dni){
        if (isValidDNI(dni)){
            this.dni = dni;
        }
    }
    /**
     * This method returns the dni of the employee
     * @return dni string
     */
    public String getDNI(){
        return dni;
    }
    /**
     * This method checks that the dni is valid
     * @param adni String
     * @return 
     */
    public boolean isValidDNI(String adni){
        if (adni != null){
            int numberCount = 0;
            String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
            
            for (int i = 0; i < adni.length() - 1; i++) {
                if (adni.charAt(i) >= '0' && adni.charAt(i) <= '9')
                    numberCount++;
            }
            
            if (numberCount == 8) {
                int n = Integer.parseInt(adni.substring(0, 8)) % 23;
                
                if (letters.charAt(n) == adni.toUpperCase().charAt(8)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    /**
     * This method returns the number of available turns
     * @return turn.length
     */
    public int getTurnCount(){
        if (turn == null){
            return 0;
        }
        return turn.length;
    }
    /**
     * This method adds a new turn to an employee
     * @param newTurn Turn[]
     */
    public void addTurn(Turn newTurn){
        if (getTurnCount() < 7 && newTurn != null){
            int count = getTurnCount();
            Turn[] tempTurn = new Turn[count + 1];

            for (int i = 0; i < getTurnCount(); i++) {
                tempTurn[i] = turn[i];
            }
            tempTurn[count] = newTurn;
            turn = tempTurn;
        }
    }
    /**
     * This method returns the turn at index entered by user
     * @param anIndex Turn
     * @return 
     */
    public Turn getTurnAt(int anIndex){
        if (anIndex < getTurnCount() && anIndex >= 0){
            return turn[anIndex];
        }
        return null;
    }
    /**
     * This method checks if the entried turn exists
     * @param aDay string
     * @return 
     */
    public boolean existTurn(String aDay){
        if (getTurnCount() > 0 && aDay != null) {
            for (int i = 0; i < getTurnCount(); i++) {
                if (turn[i].getDay().equals(aDay.toUpperCase())) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * This method removes the turn at the day that user entried if exists
     * @param aDay string
     */
    public void removeTurn(String aDay){
        if (aDay != null) {
            aDay = aDay.toUpperCase();
            if (existTurn(aDay)){
                int count = 0;

                for (int i = 0; i < turn.length; i++) {
                    if (turn[i].getDay().equals(aDay)) {
                        count++;
                    }
                }
                Turn[] newTurn = new Turn[getTurnCount() - count];
                count = 0;

                for (int i = 0; i < turn.length; i++) {
                    if (! turn[i].getDay().equals(aDay)){
                        newTurn[count] = turn[i];
                        count++;
                    }
                }
                turn = newTurn;
            }
        }
    }
    /**
     * This method returns turns that are asigned to the employee
     * @return turn Turn[]
     */
    public Turn[] getTurns(){
        if (getTurnCount() > 0) {
            Turn[] tempTurn = new Turn[getTurnCount()];
            
            for (int i = 0; i < getTurnCount(); i++) {
                tempTurn[i] = turn[i];
            }
            return tempTurn;
        }
        return null;
    }
}
