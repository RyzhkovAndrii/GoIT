package ConnectingTime;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by Andrii Ryzhkov on 24.05.2017.
 *
 */

class ConnectingHolder {

    private static final String LOG_FILE_PATH = "D:\\GoIT\\IdeaProjects\\GoIT\\src\\ConnectingTime\\sessions_log.txt";
    private static final String PERIOD_FILE_PATH = "D:\\GoIT\\IdeaProjects\\GoIT\\src\\ConnectingTime\\period.txt";

    private boolean checkDate(long date, long start, long finish) {
        return date >= start && date <= finish;
    }

    private long dateParse(String sDate) throws ParseException {
        return new SimpleDateFormat("dd.MM.yy hh:mm:ss").parse(sDate).getTime();
    }

    void processing() throws FileNotFoundException, ParseException {

        Scanner logFile = new Scanner(new File(LOG_FILE_PATH));
        Scanner periodFile = new Scanner(new File(PERIOD_FILE_PATH));

        long startPeriod = dateParse(periodFile.nextLine());
        long finishPeriod = dateParse(periodFile.nextLine());

        while(logFile.hasNextLine()) {
            Connecting connecting = new Connecting(logFile.nextLine());
            if (checkDate(connecting.getConnectingTime(),startPeriod, finishPeriod)) {
                System.out.println(connecting.getIp());
            }
        }

        logFile.close();
        periodFile.close();
    }
}
