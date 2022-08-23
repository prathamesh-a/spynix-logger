package ml.inix.loggers;

import ml.inix.util.Color;
import ml.inix.util.Log;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Screenshot {

    public void capture(String filePath, String fileName) {
        try{
            Robot robot = new Robot();
            Rectangle screen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage image = robot.createScreenCapture(screen);
            ImageIO.write(image, "jpg", new File(filePath + fileName + ".jpg"));
        }
        catch (AWTException | IOException e) {
            Log.out(Color.RED + e.getMessage());
        }
    }

}
