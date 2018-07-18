package sample;


import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;

import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;



public class CaptureScreenShot {
    private DateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
    private String destination = "C:\\Users\\makz\\Desktop\\ScreenShot-App\\Screenshots\\";
    private String format = "png";


    public BufferedImage takeAndSaveFullSS() {
        BufferedImage screenFullImage = null;
        try {
            Robot robot = new Robot();
            Date date = new Date();
            String fileName = sdf.format(date) + "." + format;
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, format, new File(destination + fileName));
            System.out.println("A full screenshot saved!");
        } catch (AWTException | IOException ex) {
            System.err.println(ex);
        }
        return screenFullImage;
    }

    public String takeAndUploadFullSsToImgur(){
        String link = null;
        try {
            Robot robot = new Robot();
            Date date = new Date();
            String fileName = sdf.format(date) + "." + format;
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            File image = new File(destination + fileName);
            ImageIO.write(screenFullImage, format, image);
            link = getLink(Uploader.upload(image));
            System.out.println("A full uploaded saved!" + getLink(Uploader.upload(image)));
            image.deleteOnExit();
        } catch (AWTException | IOException ex) {
            System.err.println(ex);
        }
        return link;
    }

    public void copySsToClipboard(BufferedImage screenFullImage) {
        MenuController.CLIPBOARD.setContents(new ClipboardImage(screenFullImage), null);
        System.out.println("screen copy to clipboard");
    }
    public void copyUrlToClipboard(String link) {
        StringSelection linkCpy = new StringSelection(link);
        MenuController.CLIPBOARD.setContents(linkCpy, null);
        System.out.println("url copy to clipboard");
    }


    private String getLink(String jsonResponse)
    {
        Pattern pattern = Pattern.compile("link\":\"(.*?)\"");
        Matcher matcher = pattern.matcher(jsonResponse);
        matcher.find();
        return matcher.group().replace("link\":\"", "").replace("\"", "").replace("\\/", "/");
    }
}
