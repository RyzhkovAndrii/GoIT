package ConnectingTime;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * Created by Andrii Ryzhkov on 24.05.2017.
 *
 */
public class AppRunner {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        ConnectingHolder helper = new ConnectingHolder();
        helper.processing();
    }



}
