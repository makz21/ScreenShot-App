package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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


    public void takeAndSaveFullSS() {
        try {
            Robot robot = new Robot();
            Date date = new Date();
            String fileName = sdf.format(date) + "." + format;

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, format, new File(destination + fileName));
            MenuController.CLIPBOARD.setContents(new ClipboardImage(screenFullImage), null);
            System.out.println("screenshot clipboard");

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
