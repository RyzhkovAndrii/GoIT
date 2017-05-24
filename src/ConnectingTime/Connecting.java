package ConnectingTime;

/**
 * Created by Andrii Ryzhkov on 24.05.2017.
 *
 */

class Connecting {

    private String ip;
    private int port;
    private int sessionID;
    private long connectingTime;
    private int connectingID;
    private String log;

    Connecting(String log) {

        String[] logArray = log.split(" ");
        String[] ipPort = logArray[0].split(":");

        this.log = log;
        this.ip = ipPort[0];
        this.port = Integer.parseInt(ipPort[1]);
        this.sessionID = Integer.parseInt(logArray[1]);
        this.connectingTime = Long.parseLong(logArray[2]);
        this.connectingID = Integer.parseInt(logArray[3]);
    }

    String getIp() {
        return ip;
    }

    long getConnectingTime() {
        return connectingTime;
    }
}
