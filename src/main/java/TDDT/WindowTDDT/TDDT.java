package TDDT.WindowTDDT;

import TDDT.Main;
import TDDT.FileIO.Project;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

/**
 * Created by Lionel on 28.06.2016.
 */
public class TDDT {
    public Project Task = null;
    public static int currenttask;
    public TDDT(){
    }

    public void setTask(Project p){
        this.Task = p;
        System.out.println(p.code + p.test); //Debug Project übergabe
        try{
            FXMLLoader mainloader = new FXMLLoader(getClass().getResource("../sample.fxml"));
            Parent mainparent = mainloader.load();
            Main.Bp.setCenter(mainparent);
            TDDTController tcontroller = mainloader.getController();
            tcontroller.setLeftTextArea(p.code);
            tcontroller.setRightTextArea(p.test);
        }catch (IOException ex){ex.printStackTrace();}
    }

    public String getCode(){
        String s ="";
        try{
            FXMLLoader mainloader = new FXMLLoader(getClass().getResource("../sample.fxml"));
            Parent mainparent = mainloader.load();
            Main.Bp.setCenter(mainparent);
            TDDTController tcontroller = mainloader.getController();
            s = tcontroller.getLeftTextArea();
        }catch (IOException ex){ex.printStackTrace();}
        return s;
    }

    public String getTest(){
        String s ="";
        try{
            FXMLLoader mainloader = new FXMLLoader(getClass().getResource("../sample.fxml"));
            Parent mainparent = mainloader.load();
            Main.Bp.setCenter(mainparent);
            TDDTController tcontroller = mainloader.getController();
            s = tcontroller.getRightTextArea();
        }catch (IOException ex){ex.printStackTrace();}
        return s;
    }
}
