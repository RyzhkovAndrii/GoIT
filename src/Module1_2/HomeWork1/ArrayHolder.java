package Module1_2.HomeWork1;

import java.util.Arrays;

public class ArrayHolder {
    private int[] array;

    public ArrayHolder(int[] array) {
        this.array = array;
    }

    public void sortArray() {
        Arrays.sort(array);
    }

    public void printArray() {
        System.out.println(Arrays.toString(array));
    }

    public int findIndex(int startIndex, int value) {
        for (int i = startIndex; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

}