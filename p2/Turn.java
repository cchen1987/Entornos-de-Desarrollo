package crewmanagement;
/**
 * Class Turn
 * @author chao
 */
public class Turn {
    String day; // it should be upper-case
    int initHour; // integer number between 0 and 23
    int finishHour; // integer number between 0 and 23
    /**
     * Empty constructor with default value
     */
    public Turn() {
        this("", 0, 0);
    }
    /**
     * Overloaded constructor
     * @param day (string)
     */
    public Turn(String day){
        this(day == null ? "" : day.toUpperCase(), 0, 0);
    }
    /**
     * Overloaded constructor
     * @param day string
     * @param initHour integer
     * @param finishHour integer
     */
    public Turn(String day, int initHour, int finishHour){
        if (day != null && initHour >= 0 && initHour < 24 && finishHour >= 0 &&
                finishHour < 24){
            this.day = day.toUpperCase();
            this.initHour = initHour;
            this.finishHour = finishHour;
        }
    }
    /**
     * This method sets day in upper-case
     * @param day string
     */
    public void setDay(String day){
        if (day != null){
            this.day = day.toUpperCase();
        }
    }
    /**
     * This method returns the parameter day in string
     * @return day string
     */
    public String getDay(){
        return day;
    }
    /**
     * This method sets init hour 
     * @param initHour integer number between 0 and 23
     */
    public void setInitHour(int initHour){
        if (initHour >= 0 && initHour < 24){
            this.initHour = initHour;
        }
    }
    /**
     * This method returns the parameter init hour in a integer number
     * @return init hour
     */
    public int getInitHour(){
        return initHour;
    }
    /**
     * This method sets finish hour
     * @param finishHour integer number between 0 and 23
     */
    public void setFinishHour(int finishHour){
        if (finishHour >= 0 && finishHour < 24){
            this.finishHour = finishHour;
        }
    }
    /**
     * This method returns the parameter finish hour in a integer number
     * @return finish hour
     */
    public int getFinishHour(){
        return finishHour;
    }
}
