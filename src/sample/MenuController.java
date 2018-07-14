package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


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
        captureSS.takeAndSaveFullScreenShotOnDisc();
    }

    @FXML
    public void openContainingFolder() {
        try {
            Runtime.getRuntime().exec("explorer C:\\Users\\makz\\Desktop\\ScreenShot-App\\Screenshots");  //only windows
            System.out.println("folder");
        } catch (java.io.IOException e) {
            System.out.println("problem z folderem");
        }

    }

}
