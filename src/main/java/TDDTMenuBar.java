import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Lionel on 01.07.2016.
 */
public class TDDTMenuBar {

    public static Stage settings;

    public MenuBar TopMenu(){
        MenuBar mBar = new MenuBar();
        Menu ActionMenu = new Menu("Action");
        MenuItem loadTemplate = new MenuItem("Lade Template");
        loadTemplate.setOnAction(this::handleloadTemplate);///Action bei Template laden -----> implementieren:: Lionel
        loadTemplate.setAccelerator(KeyCombination.keyCombination("Ctrl+L"));  //mal testen klingt gut ;D
        MenuItem settingsItem = new MenuItem("Einstellungen");
        settingsItem.setOnAction(this::handlesettings);
        ActionMenu.getItems().addAll(loadTemplate,settingsItem);
        mBar.getMenus().add(ActionMenu);
        return mBar;
    }

    private void handlesettings(ActionEvent event){
        //Change stage to setting scene and add Layout ---> Radiobuttons
        DEBUG.out("handleloadSettings");
        try{settingsView();}catch (IOException ex){ex.printStackTrace();}
    }

    private void handleloadTemplate(ActionEvent event){
        DEBUG.out("handleloadTemplate");
        try{loadTemplateView();}catch (IOException ex){ex.printStackTrace();}
    }

    private void loadTemplateView() throws IOException{
        FXMLLoader startloader = new FXMLLoader(getClass().getResource("load.fxml"));
        Parent loadroot = startloader.load();
        Main.Bp.setCenter(loadroot);
    }

    private void settingsView() throws IOException{
        /*FXMLLoader settingsloader = new FXMLLoader(getClass().getResource("settings.fxml"));  // Design ----> Ando
        Parent loadsettings = settingsloader.load();
        Main.Bp.setCenter(loadsettings);*/
        settings = new Stage();
        settings.setTitle("Feature-Einstellungen");
        DesignCheckBox ds = new DesignCheckBox();
        Scene s = ds.DesignCheckBox();
        settings.setScene(s);
        settings.show();
    }
}
