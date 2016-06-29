import FileIO.Project;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Created by Lionel on 28.06.2016.
 */
public class TDDT {
    public Project Task = null;
    public TDDTController controller = new TDDTController();

    public TDDT(){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample.fxml"));
        controller = loader.getController();
    }

    public MenuBar TopMenu(){
        MenuBar mBar = new MenuBar();
        Menu ActionMenu = new Menu("Action");
        MenuItem loadTemplate = new MenuItem("Lade Template");
        loadTemplate.setOnAction(this::handleloadTemplate); ///Action bei Template laden -----> implementieren:: Lionel
        ActionMenu.getItems().addAll(loadTemplate);
        mBar.getMenus().add(ActionMenu);
        return mBar;
    }

    private void handleloadTemplate(ActionEvent event){
        controller.test();
    }

    public void setTask(Project p){
        this.Task = p;
        System.out.println(p.code + p.test); //Debug Project übergabe
        //controller.fieldgreen.setText(p.code);
    }

}
