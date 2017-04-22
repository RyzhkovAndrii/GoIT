package Module1_1.HomeWork2;

import java.util.Scanner;

public class HomeWork2App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            array[i] = sc.nextInt();
        }

        sc.close();

        ArrayHolder arrayHolder = new ArrayHolder(array);

        System.out.println("Initial array: " + arrayHolder.arrayToString());
        arrayHolder.sortArray();
        System.out.println("Sorted array: " + arrayHolder.arrayToString());
    }
}
