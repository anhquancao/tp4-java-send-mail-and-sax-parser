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

        try {
            socket = new Socket("localhost", 33333);
            Writer output = new OutputStreamWriter(socket.getOutputStream(), "8859_1");
            output.write("LIST etc aquancva@gmail.com");
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
