package Offline1.Task6;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter your word (to exit from program: enter \"exit\"):");
            String inputString = scanner.nextLine();

            if (inputString.isEmpty()) {
                System.out.println("You don't enter the word!!! Please try again.");
                continue;
            }

            inputString = inputString.toLowerCase().trim();

            if ("exit".equals(inputString)) return;

            String message = isPalindrome(inputString) ? "The word IS a palindrome" : "The word is NOT a palindrome";

            System.out.println(message);
        }
    }

    private static boolean isPalindrome(String inputString) {
        char[] inputCharArray = inputString.toCharArray();

        for (int i = 0; i < inputCharArray.length / 2; i++) {

            if (inputCharArray[i] != inputCharArray[inputCharArray.length - i - 1]) {
                return false;
            }

        }

        return true;
    }

    /*private static boolean isPalindrome(String inputString) {
        return inputString.equals(new StringBuilder(inputString.trim().toLowerCase()).reverse().toString()) ? true : false;
    }*/
}
