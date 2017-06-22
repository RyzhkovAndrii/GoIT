package ConnectingTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Andrii Ryzhkov on 24.05.2017.
 *
 */

class ConnectingHolder {

    private boolean checkDate(long date, long start, long finish) {
        return date >= start && date <= finish;
    }

    private long dateParse(String sDate) throws ParseException {
        return new SimpleDateFormat("dd.MM.yy hh:mm:ss").parse(sDate).getTime();
    }

    boolean isConnectingInPeriod(Connecting connecting, String start, String finish) throws ParseException {
        return checkDate(connecting.getConnectingTime(), dateParse(start), dateParse(finish));
    }

}
