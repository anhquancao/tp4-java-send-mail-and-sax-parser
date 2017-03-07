package tp4.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by caoquan on 2/28/17.
 */
public class ServerSlave implements Runnable {
    InputStream inputStream;

    public ServerSlave(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "8859_1"));
            String inputString = bufferedReader.readLine();
            String[] splittedStrings = inputString.split(" ");
            String application = splittedStrings[0];
            if (application.equals("LIST")) {
                String directoryName = splittedStrings[1];
                String email = splittedStrings[2];
//                System.out.println("LIST " + directoryName + " " + email);
                ReqList reqList = new ReqList();
                reqList.list(directoryName, email);
            } else {
                System.out.println("NOT LIST");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Slave");
    }
}
