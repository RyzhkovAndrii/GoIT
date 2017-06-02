package module2_2;

/**
 * Created by Andrii Ryzhkov on 02.06.2017.
 *
 */

public class IntCollectionTestApp {

    public static void main(String[] args) {

        FixedSizeQueue<Integer> testQueue1 = new FixedSizeQueue<>(6);
        for (int i = 1; i < 7 ; i++) {
            testQueue1.add(i);
        }
        System.out.println(testQueue1);

        FixedSizeQueue<Integer> testQueue2 = new FixedSizeQueue<>(testQueue1);
        for (int i = 1; i < 12 ; i++) {
            testQueue2.add(i);
        }
        System.out.println(testQueue2);

        System.out.println(testQueue2.get(3));

        FixedSizeQueue<Integer> testQueue3 = new FixedSizeQueue<>(testQueue2);
        testQueue3.add(testQueue1);
        testQueue3.add(54);
        testQueue3.add(8);
        System.out.println(testQueue3);
    }

}
