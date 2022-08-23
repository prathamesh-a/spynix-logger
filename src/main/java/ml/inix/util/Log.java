package ml.inix.util;

import java.util.concurrent.TimeUnit;

public class Log {

    public static void out(String args) {
        System.out.println(args);
    }

    public static void clear() {
        System.out.print("\033\143");
    }

    public static boolean isValidMail(String email) {
        if(email == null) return false;
        return email.trim().matches("[a-zA-Z_][\\w]*[-]{0,4}[\\w]+@[a-zA-Z0-9]+.[a-zA-Z]{2,6}");
    }

    public static void wait(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
