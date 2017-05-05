package Offline1.Task5;

import java.util.Scanner;

public class RepeatingPunctuationMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter your string (to exit from program: enter \"exit\"):");
            String inputString = scanner.nextLine();

            if (inputString.isEmpty()) {
                System.out.println("You don't enter the string!!! Please try again.");
                continue;
            }

            if ("exit".equals(inputString)) return;

            char[] charInputString = inputString.toCharArray();

            StringBuilder builder = new StringBuilder();

            builder.append(charInputString[0]);

            for (int i = 1; i < charInputString.length; i++) {

                if (isPunctuationMarks(charInputString[i]) && charInputString[i] == charInputString[i-1]) {
                    continue;
                }

                builder.append(charInputString[i]);

            }

            System.out.println(builder.toString());
        }
    }

    private static boolean isPunctuationMarks(char symbol) {
        String punctuationMarks = "!?,.\"':;";
        return punctuationMarks.indexOf(symbol) != -1;
    }
}
