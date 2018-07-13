package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;


public class MenuController {
    public Button openFolderWithSS;

    @FXML
    public void openContainingFolder() throws IOException {
        Runtime.getRuntime().exec("explorer C:\\Users\\makz\\Desktop\\ScreenShot-App\\Screenshots");
        System.out.println("folder");
    }

}
