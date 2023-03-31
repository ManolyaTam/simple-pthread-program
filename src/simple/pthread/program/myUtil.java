package simple.pthread.program;

public class myUtil {

    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public static void printMessage(String message) {
        System.out.println(message);

    }

    public static void printMessage(String message, String color) {
        color = color.toLowerCase();
        switch (color) {
            case "red":
                System.out.println(RED + message + RESET);
                break;
            case "blue":
                System.out.println(BLUE + message + RESET);
                break;
            case "green":
                System.out.println(GREEN + message + RESET);
                break;
            default:
                System.out.println(message + RESET);
        }
    }
}
