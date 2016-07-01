import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Created by Lionel on 01.07.2016.
 */
public class TDDTMenuBar {

    public MenuBar TopMenu(){
        System.out.println("init menubar");
        MenuBar mBar = new MenuBar();
        Menu ActionMenu = new Menu("Action");
        MenuItem loadTemplate = new MenuItem("Lade Template");
        loadTemplate.setOnAction(this::handleloadTemplate);///Action bei Template laden -----> implementieren:: Lionel
        // loadTemplate.setAccelerator(KeyCombination.keyCombination("Ctrl+L");  //mal testen klingt gut ;D
        MenuItem settingsItem = new MenuItem("Einstellungen");
        settingsItem.setOnAction(this::handlesettings);
        ActionMenu.getItems().addAll(loadTemplate,settingsItem);
        mBar.getMenus().add(ActionMenu);
        return mBar;
    }

    private void handlesettings(ActionEvent event){
        //Change stage to setting scene and add Layout ---> Radiobuttons
        DEBUG.out("handleloadSettings");
    }

    private void handleloadTemplate(ActionEvent event){
        DEBUG.out("handleloadTemplate");
        Main.tcontroller.setTextAreaGreen("Hallo");
    }
}
