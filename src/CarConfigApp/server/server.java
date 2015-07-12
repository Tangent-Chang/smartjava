package CarConfigApp.server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Tangent Chang on 7/8/15.
 */
public class server {
    private ServerSocket serverSocket = null;
    private final int serverPort = 4444;  // 要監控的port

    public server() {
        try {
            serverSocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + serverPort);
            System.exit(1);
        }
    }

    public void run(){
        DefaultSocketClient clientSocket = null;
        BufferedInputStream in;

        try{
            clientSocket = new DefaultSocketClient(serverSocket, serverSocket.accept());
            //clientSocket.setSoTimeout(15000);

        }
        catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
    }
}
