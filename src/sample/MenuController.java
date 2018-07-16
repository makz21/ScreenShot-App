package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.io.IOException;


public class MenuController {
    public static final Clipboard CLIPBOARD =
            Toolkit.getDefaultToolkit().getSystemClipboard();
    public Button takeFullSS;
    public Button openFolderWithSS;
    // public Button takeAndUploadSS;
    // public Button editSS;
    // public Button copySS;
    // public Button copySSUrl
    CaptureScreenShot captureSS = new CaptureScreenShot();


    @FXML
    public void takeAndSaveFullScreenShotOnDisc() throws IOException {
        takeFullSS.getScene().getWindow().setOpacity(0);
        captureSS.takeAndSaveFullSS();
        takeFullSS.getScene().getWindow().setOpacity(1);
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
