package ml.inix.util;

public class Color {

    public static String RED  = ("\u001B[31;1m");
    public static String YELLOW = ("\\u001B[33;1m");
    public static String GREEN = ("\\u001B[32;1m");
    public static String BLUE = ("\\u001B[34;1m");
    public static String PURPLE = ("\\u001B[35;1m");
    public static String CYAN = ("\\u001B[36;1m");
    public static String WHITE = ("\\u001B[37;1m");
    public static String BLACK = ("\\u001B[30;1m");
    public static String RESET = ("\\u001B[0;1m");

    private Color() {}
}

//public enum Color {
//    RED ("\u001B[31;1m"),
//    YELLOW("\\u001B[33;1m"),
//    GREEN("\\u001B[32;1m"),
//    BLUE("\\u001B[34;1m"),
//    PURPLE("\\u001B[35;1m"),
//    CYAN("\\u001B[36;1m"),
//    WHITE("\\u001B[37;1m")
//    ;
//
//    private final String val;
//    Color(String s) {
//        this.val = s;
//    }
//}

