package tp4.client;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * Created by caoquan on 2/28/17.
 */
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        for (int i = 0; i < 1; i++) {
            try {
                socket = new Socket("localhost", 33333);


                Writer output = new OutputStreamWriter(socket.getOutputStream(), "8859_1");
                output.write("LIST etc dstung610@gmail.com");
                output.flush();


            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
