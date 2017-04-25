package Module1_2.HomeWork1;

import java.util.Scanner;

public class MenuHelper {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean isExit = false;
    private static ArrayHolder arrayHolder;
    private static int choice;

    private static int readInt(String request) {
        System.out.print(request);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print(request);
            }
        }
    }

    private static void initArrayHolder() {
        int[] array = new int[readInt("Enter arrays length: ")];
        for (int i = 0; i < array.length; i++) {
            array[i] = readInt("array [" + (i + 1) + "] = ");
        }
        arrayHolder = new ArrayHolder(array);
    }

    private static void printMenu() {
        System.out.println("");
        System.out.println("Make your choice:");
        System.out.println("1: input array again;");
        System.out.println("2: find number by value;");
        System.out.println("3: sort array;");
        System.out.println("4: print array;");
        System.out.println("5: exit;");
        System.out.println("");
    }

    private static void runFindIndexMenu() {
        int index = -1;
        int number = readInt("Enter a number: ");
        StringBuilder builder = new StringBuilder();
        while ((index = arrayHolder.findIndex(index + 1, number)) != -1) {
            builder.append(index);
            builder.append(", ");
        }
        if (builder.length() > 0) {
            builder.delete(builder.length() - 2, builder.length());
            System.out.println("\nIndex(es) of your number is(are): " + builder.toString());
        } else {
            System.out.println("\nYour number isn't in this array!");
        }
    }

    private static void runSortMenu() {
        arrayHolder.sortArray();
        System.out.println("\nArray was sorted!");
    }

    private static void runPrintMenu() {
        arrayHolder.printArray();
    }

    private static void runExitMenu() {
        System.out.println("bye Bye");
        scanner.close();
        isExit = true;
    }

    private static void doChoice() {
        do {
            choice = readInt("Your choice is ... ");
        } while (choice < 1 || choice > 5);
    }

    private static void runMenu() {
        switch (choice)  {
            case 1: initArrayHolder(); break;
            case 2: runFindIndexMenu(); break;
            case 3: runSortMenu(); break;
            case 4: runPrintMenu(); break;
            default: runExitMenu();
        }
    }

    public static void start() {
        initArrayHolder();
        while (true) {
            printMenu();
            doChoice();
            runMenu();
            if (isExit) return;
        }
    }
}
