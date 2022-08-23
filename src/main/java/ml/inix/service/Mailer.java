package ml.inix.service;

import ml.inix.Config;

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
                //TODO
            }
        }, Config.TIMEOUT*1000L, Config.TIMEOUT*1000L);
    }
}
