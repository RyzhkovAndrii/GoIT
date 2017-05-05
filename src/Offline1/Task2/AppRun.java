package Offline1.Task2;

public class AppRun {
    public static void main(String[] args) {
        int[] a = new int[10];
        int[] b = new int[10];
        double[] c = new double[10];

        System.out.println("   a  |   b   |        c");
        System.out.println("=================================");

        for (int i = 0; i < a.length; i++) {
            a[i] =  10 + (int) (Math.random() * 11);
            b[i] =  30 + (int) (Math.random() * 11);
            c[i] = Math.sqrt((a[i] * a[i]) + (b[i] * b[i]));
            System.out.println("  " + a[i] + "  |   " + b[i] + "  |   " + c[i]);
        }
    }
}
