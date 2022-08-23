package ml.inix;

import ml.inix.menu.Menu;
import ml.inix.util.Color;
import ml.inix.util.Log;

import java.util.Locale;

public class Spynix {

    private Menu menu;

    public Spynix() {
        checkOS();
        this.menu = new Menu();
    }

    private void checkOS() {
        String OS = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        if (!OS.contains("windows")) {
            Log.out(Color.RED + "[ERROR] This Operating System is not supported");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Spynix();
    }
}


//        String path = System.getenv("APPDATA") + "\\Spynix" + "\\logs\\" + dateFormat.format(new Date()) + ".txt";
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
//            bw.write("Hello world!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }