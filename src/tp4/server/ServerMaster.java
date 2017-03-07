package tp4.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by caoquan on 2/28/17.
 */
public class ServerMaster {
    private ServerSocket serverSocket;

    public ServerMaster(int port) {
        try {
            System.out.println("Server listen at: " + port);
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerMaster serverMaster = new ServerMaster(33333);
        serverMaster.manageClient();
    }

    public void manageClient() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Accept");
                ServerSlave slave = new ServerSlave(socket.getInputStream());
                Thread slaveThread = new Thread(slave);
                slaveThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
