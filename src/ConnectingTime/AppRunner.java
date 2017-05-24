package ConnectingTime;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by Andrii Ryzhkov on 24.05.2017.
 *
 */
public class AppRunner {

    private static final String LOG_FILE_PATH = "D:\\GoIT\\IdeaProjects\\GoIT\\src\\ConnectingTime\\sessions_log.txt";
    private static final String PERIOD_FILE_PATH = "D:\\GoIT\\IdeaProjects\\GoIT\\src\\ConnectingTime\\period.txt";

    public static void main(String[] args) throws FileNotFoundException, ParseException {

        ConnectingHolder holder = new ConnectingHolder();

        Scanner logFile = new Scanner(new File(LOG_FILE_PATH));
        Scanner periodFile = new Scanner(new File(PERIOD_FILE_PATH));

        String startDate = periodFile.nextLine();
        String finishDate = periodFile.nextLine();

        while(logFile.hasNextLine()) {
            Connecting connecting = new Connecting(logFile.nextLine());
            if (holder.isConnectingInPeriod(connecting, startDate, finishDate)) {
                System.out.println(connecting.getIp());
            }
        }

        logFile.close();
        periodFile.close();

    }

}
