package Controller;

import java.util.Scanner;

public class Utility {

    static Scanner sc = new Scanner(System.in);

    public static int inputInt() {
        int i = 0;
        while (true) {
            try {
                i = Integer.parseInt(sc.nextLine());
                if (i < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a positive number");
            }
        }
        return i;
    }

    public static double inputDouble() {
        double i = 0;
        while (true) {
            try {
                i = Double.parseDouble(sc.nextLine());
                if (i < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a positive double number");
            }

        }
        return i;

    }

    public static String inputString() {
        String str;
        while (true) {
            str = sc.nextLine();
            if (str.isEmpty()) {
                System.out.println("Please enter bcode is not null");
                continue;
            }
            break;
        }
        return str;
    }
}
