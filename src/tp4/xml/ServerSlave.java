package tp4.xml;

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

            ReqList reqList = new ReqList();
            reqList.list(inputString);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Slave");
    }
}
