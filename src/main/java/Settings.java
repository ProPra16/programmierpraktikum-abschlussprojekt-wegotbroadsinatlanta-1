/**
 * Created by Lionel on 29.06.2016.
 */

// Class for the Project Settings (babystep,timetracking etc)  store boolean values here so they can be changed in the main by dialouge
public class Settings {
    public boolean babystep;
    public boolean timetracking;

    public Settings(boolean b, boolean t){
        this.timetracking = t;
        this.babystep = b;
    }
}
