package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class CaptureScreenShot {
    private DateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
    private String destination = "C:\\Users\\makz\\Desktop\\ScreenShot-App\\Screenshots\\";
    private String format = "png";


//    public void setOpacity0(ActionEvent actionEvent) throws Exception{
//
//        Parent home_page_parent = FXMLLoader.load(getClass().getResource("appView.fxml"));
//        Scene home_page_scene = new Scene(home_page_parent);
//        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        primaryStage.setTitle("ScreenShot APP");
//        primaryStage.setScene(home_page_scene);
//        primaryStage.setScene(new Scene(home_page_parent, 400, 350));
//        primaryStage.setOpacity(0);
//    }
//    public void setOpacity1(){}

    public void takeAndSaveFullSS() {
        try {
            Robot robot = new Robot();
            Date date = new Date();
            String fileName = sdf.format(date) + "." + format;

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, format, new File(destination + fileName));

            System.out.println("A full screenshot saved!");
        } catch (AWTException | IOException ex) {
            System.err.println(ex);
        }
    }

    public void takeAndSavePartScreenShotOnDisc() {
    }

    public void takeAndSaveFullScreenShotToBinary() {
    }

    public void takeAndSavePartScreenShotToBinary() {
    }

}
