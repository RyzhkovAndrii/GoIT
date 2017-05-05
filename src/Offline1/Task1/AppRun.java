package Offline1.Task1;

import java.math.BigDecimal;

public class AppRun {

    public static void main(String[] args) {
        String[] product = {"Хлеб", "Молоко", "Сахар", "Каша", "Кофе", "Чай", "Кефир", "Помидор", "Огурец", "Картошка"};
        //double[] price = {4.5, 8, 7.5, 3, 7.8, 10.5, 6.6, 2.3, 5.6, 5};
        BigDecimal[] price = new BigDecimal[10];
        price[0] = new BigDecimal(4.5);
        price[1] = new BigDecimal(8);
        price[2] = new BigDecimal(7.5);
        price[3] = new BigDecimal(3);
        price[4] = new BigDecimal(7.8);
        price[5] = new BigDecimal(10.5);
        price[6] = new BigDecimal(6.6);
        price[7] = new BigDecimal(2.1);
        price[8] = new BigDecimal(5.6);
        price[9] = new BigDecimal(5);

        BigDecimal result = BigDecimal.ZERO;
        //double result = 0;

        for (int i = 0; i < product.length; i++) {
            System.out.println((i + 1) + " " + product[i] + " " + price[i].doubleValue());
            //result += price[i];
            result = result.add(price[i]);
        }

        BigDecimal average = result.divide(new BigDecimal(price.length),2, BigDecimal.ROUND_HALF_UP);

        //System.out.println("Средняя цена товаров = " + result / price.length);
        System.out.println("Средняя цена товаров = " + average.doubleValue());
    }

}
