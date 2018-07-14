package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;


public class MenuController{
    // public Button takeFullSS;
    public Button openFolderWithSS;
    // public Button takeAndUploadSS;
    // public Button editSS;
    // public Button copySS;
    // public Button copySSUrl
    CaptureScreenShot captureSS = new CaptureScreenShot();




    @FXML
    public void takeAndSaveFullScreenShotOnDisc() {
        captureSS.takeAndSaveFullSS();

    }

    @FXML
    public void openContainingFolder() {
        try {
            Runtime.getRuntime().exec("explorer C:\\Users\\makz\\Desktop\\ScreenShot-App\\Screenshots");  //only windows
            System.out.println("folder");
        } catch (java.io.IOException e) {
            System.out.println("error/folder");
        }

    }

}
