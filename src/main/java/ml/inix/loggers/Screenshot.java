package ml.inix.loggers;

import ml.inix.Config;
import ml.inix.util.Color;
import ml.inix.util.Log;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Screenshot {

    public static void capture() {
        String fileName = "screenshot_" + new Date().toString().replace(" ", "_").replace(":", "-");
        try{
            Robot robot = new Robot();
            Rectangle screen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage image = robot.createScreenCapture(screen);
            ImageIO.write(image, "jpg", new File(Config.PATH_SCREENSHOT + fileName + ".jpg"));
        }
        catch (AWTException | IOException e) {
            Log.out(Color.RED + e.getMessage());
        }
    }

    public static void main(String[] args) {
        capture();
    }

}
