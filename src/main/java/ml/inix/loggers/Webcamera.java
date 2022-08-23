package ml.inix.loggers;

import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Webcamera {

    public static void capture(String filePath, String fileName, int width, int height) throws IOException {
        Webcam webcam = Webcam.getDefault();

        if (webcam != null) {
            webcam.setViewSize(new Dimension(width, height));
            webcam.open();
            ImageIO.write(webcam.getImage(), "PNG", new File(filePath + fileName + ".png"));
            webcam.close();
        }

    }

}
