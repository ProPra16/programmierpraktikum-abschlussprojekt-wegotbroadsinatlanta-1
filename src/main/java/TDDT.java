import FileIO.Project;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * Created by Lionel on 28.06.2016.
 */
public class TDDT {
    public Project Task = null;
    public Settings settings = new Settings(true,true);

    public TDDT(){
    }

    public void setTask(Project p){
        this.Task = p;
        System.out.println(p.code + p.test); //Debug Project übergabe
        try{
            FXMLLoader mainloader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent mainparent = mainloader.load();
            Main.Bp.setCenter(mainparent);
            TDDTController tcontroller = mainloader.getController();
            tcontroller.setLeftTextArea(p.code);
            tcontroller.setRightTextArea(p.test);
        }catch (IOException ex){ex.printStackTrace();}
    }
}
