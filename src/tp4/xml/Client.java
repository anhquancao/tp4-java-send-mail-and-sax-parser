package tp4.xml;

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
            output.write("<Request>" +
                    "    <ReqName>LIST</ReqName>" +
                    "    <Dir>etc</Dir>" +
                    "    <MailAddress>aquancva@gmail.com</MailAddress>" +
                    "</Request>");
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
