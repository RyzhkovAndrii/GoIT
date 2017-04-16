package HomeWork1_2;

import java.util.Scanner;

public class HomeWork1_2{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            array[i] = sc.nextInt();
        }

        ArrayHolder arrayHolder = new ArrayHolder(array);

        System.out.println("Initial array: " + arrayHolder);
        arrayHolder.sortArray();
        System.out.println("Sorted array: " + arrayHolder);
    }
}
