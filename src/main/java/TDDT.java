import FileIO.Project;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import sun.rmi.server.Activation$ActivationSystemImpl_Stub;

/**
 * Created by Lionel on 28.06.2016.
 */
public class TDDT {
    public Project Task = null;
    public Settings settinge = new Settings(true,true);

    public TDDT(){
    }
    public void setTask(Project p){
        this.Task = p;
        System.out.println(p.code + p.test); //Debug Project übergabe
        //controller.fieldgreen.setText(p.code);
    }

}
