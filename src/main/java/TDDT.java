import FileIO.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import sun.rmi.server.Activation$ActivationSystemImpl_Stub;

/**
 * Created by Lionel on 28.06.2016.
 */
public class TDDT {
    public Project Task = null;
    public Settings settinge = new Settings(true,true);

    public TDDT(){
    }

    public MenuBar TopMenu(){
        MenuBar mBar = new MenuBar();
        Menu ActionMenu = new Menu("Action");
        MenuItem loadTemplate = new MenuItem("Lade Template");
        loadTemplate.setOnAction(this::handleloadTemplate); ///Action bei Template laden -----> implementieren:: Lionel
        MenuItem settingsItem = new MenuItem("Einstellungen");
        loadTemplate.setOnAction(this::handlesettings);
        ActionMenu.getItems().addAll(loadTemplate,settingsItem);
        mBar.getMenus().add(ActionMenu);
        return mBar;
    }

    private void handlesettings(ActionEvent event){
        //Change stage to setting scene and add Layout ---> Radiobuttons
        //Main.openSettings();
    }

    private void handleloadTemplate(ActionEvent event){
        //
        System.out.println("DEBUG::  handleloadTemplate");
        Main.tcontroller.setTextAreaGreen("Hallo");
    }


    public void setTask(Project p){
        this.Task = p;
        System.out.println(p.code + p.test); //Debug Project übergabe
        //controller.fieldgreen.setText(p.code);
    }

}
