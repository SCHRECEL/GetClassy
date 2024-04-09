import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SafeInput {
    public static int getNonNegativeInt(Scanner scanner, String prompt) {
        int value = -1;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt + ": ");
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a non-negative integer.");
                }
            } else {
                scanner.next();
                System.out.println("Please enter a valid non-negative integer.");
            }
        }
        return value;
    }
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do
        {
            System.out.print("\n" +prompt + ": ");
            retString = pipe.nextLine();
        }while(retString.length() == 0);
        return retString;

    }
    public static int getInt(Scanner pipe, String prompt) {
        int value = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                validInput = true;
            } else {
                String trash = pipe.next();
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        pipe.nextLine();

        return value;
    }
    public static double getDouble(Scanner pipe, String prompt) {
        double value = 0.0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                validInput = true;
            } else {
                String trash = pipe.next();
                System.out.println("Invalid input. Please enter a valid double value.");
            }
        }
        pipe.nextLine();

        return value;
    }
    /*
     * @param low    the low value for the input range (inclusive)
     * @param high   the high value for the input range (inclusive)
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int value = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                if (value >= low && value <= high) {
                    validInput = true;
                } else {
                    System.out.println("Input out of range. Please enter a value between " + low + " and " + high + ".");
                }
            } else {
                String trash = pipe.next();
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }


        pipe.nextLine();

        return value;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double value = 0.0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                if (value >= low && value <= high) {
                    validInput = true;
                } else {
                    System.out.println("Input out of range. Please enter a value between " + low + " and " + high + ".");
                }
            } else {
                String trash = pipe.next();
                System.out.println("Invalid input. Please enter a valid double value.");
            }
        }

        pipe.nextLine();

        return value;
    }
    /* @return true for Yes (Y/y) and false for No (N/n)
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean validInput = false;
        boolean response = false;

        while (!validInput) {
            System.out.print("\n" + prompt + " [Y/N]: ");
            String input = pipe.next().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                validInput = true;
                response = true;
            } else if (input.equals("n") || input.equals("no")) {
                validInput = true;
                response = false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.");
            }
        }
        pipe.nextLine();
        return response;
    }
    /* @param regEx  the regular expression pattern in Java String format to use for matching
     * @return a string that matches the specified regular expression
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        boolean validInput = false;
        String input = "";

        while (!validInput) {
            System.out.print("\n" + prompt + ": ");
            input = pipe.nextLine();
            if (Pattern.matches(regEx, input)) {
                validInput = true;
            } else {
                System.out.println("Input does not match the required pattern.");
            }
        }

        return input;
    }
    public static void prettyHeader(String msg) {
        int totalWidth = 60;
        int messageWidth = msg.length();
        int sideStars = (totalWidth - messageWidth - 6) / 2; //
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();

        // second row  centered message.
        System.out.print("***");
        for (int i = 0; i < sideStars; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < sideStars; i++) {
            System.out.print(" ");
        }
        // for odd lengths.
        if (messageWidth % 2 != 0) {
            System.out.print(" ");
        }
        System.out.println("***");

        // bottom row
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();

    }

}