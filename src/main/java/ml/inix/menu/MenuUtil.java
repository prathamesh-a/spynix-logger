package ml.inix.menu;

import ml.inix.util.Color;

public class MenuUtil {

    public static String TITLE = Color.CYAN + "\n" +
            " .|'''.|  '||''|.  '||' '|' '|.   '|' '||' '||' '|' \n" +
            " ||..  '   ||   ||   || |    |'|   |   ||    || |   \n" +
            "  ''|||.   ||...|'    ||     | '|. |   ||     ||    \n" +
            ".     '||  ||         ||     |   |||   ||    | ||   \n" +
            "|'....|'  .||.       .||.   .|.   '|  .||. .|   ||. \n\n" +
            Color.WHITE + "[@] Version 0.1.0 \n[@] Author  inix\n";

    public static String DISCLAIMER = Color.RED+ "[!] DISCLAIMER \n" +
            Color.RESET + "This application is for EDUCATIONAL PURPOSE ONLY. \n" +
            "The use is complete responsibility of end-user. \n\n" +
            Color.YELLOW + "Close this window if you wish to exit. \n" +
            Color.RESET + "press "+ Color.GREEN +"[ENTER]"+ Color.RESET +" to continue...";

    public static String SETUP_INFO = (""
            + Color.RED + "          +---------------------------------------------------+\n"
            + Color.RED + "    (__)  | " + Color.YELLOW + "[WARNING] Use Gmail account only!                 " + Color.RED + "|\n"
            + Color.RED + " (|)(00)  | " + Color.WHITE + "E-mail will be sent when it reaches the specified " + Color.RED + "|\n"
            + Color.RED + "  |/(__)\\ | " + Color.WHITE + "timeout. Email will contain key logs, screenshots " + Color.RED + "|\n"
            + Color.RED + "  |_/ _|  | " + Color.WHITE + "and webcam capture.                               " + Color.RED + "|\n"
            + Color.RED + "          +---------------------------------------------------+\n"
            + Color.YELLOW + "[NOTE] Allow access to less secure apps on your gmail account.\n\n");


}
