package HomeWork1_2;

import java.util.Arrays;

public class ArrayHolder {
    int[] array;

    public ArrayHolder(int[] array){
        this.array = array;
    }

    public void sortArray(){
        Arrays.sort(array);
    }

    @Override
    public String toString() {
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            s1.append(array[i]);
            s1.append(" ,");
        }
        s1.append(array[array.length - 1]);
        return s1.toString();
    }
}
