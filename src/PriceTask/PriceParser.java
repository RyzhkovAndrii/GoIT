package PriceTask;

public class PriceParser {

    public static int setPrice(String stringPrice) {
        int price = 0;
        int i = 0;
        char[] buf = stringPrice.toCharArray();

        while (i < buf.length && !Character.isDigit(buf[i])) {
            i++;
        }

        while (i < buf.length && Character.isDigit(buf[i])) {
            price = price * 10 + Character.getNumericValue(buf[i]);
            i++;
        }

        for (int j = 1; j < 3; j++) {
            price *= 10;
            if ((i + j < buf.length) && Character.isDigit(buf[i + j])) {
                price += Character.getNumericValue(buf[i + j]);
            }
        }

        return price;
    }

    public static String getStringPrice(int price) {

        StringBuilder stringPrice = new StringBuilder("$");
        stringPrice.append(price / 100);
        stringPrice.append(",");

        if (price % 100 < 10) {
            stringPrice.append("0");
        }

        stringPrice.append(price % 100);

        return stringPrice.toString();
    }

}
