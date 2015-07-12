package CarConfigApp.server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Tangent Chang on 7/8/15.
 */
public class DefaultSocketClient extends Thread implements SocketClientInterface, SocketClientConstants {

    private BufferedReader reader;
    private BufferedWriter writer;
    private Socket sock;
    private ServerSocket serverSocket;
    private String strHost;
    private int iPort;

    public DefaultSocketClient(String strHost, int iPort) {
        setPort(iPort);
        setHost(strHost);
    }//constructor

    public DefaultSocketClient(ServerSocket serverSocket, Socket sock) {
        this.serverSocket = serverSocket;
        this.sock = sock;
    }

    public void run() {
        if (openConnection()) {
            handleSession();
            closeSession();
        }
    }//run

    public boolean openConnection(){

        try {
            sock = new Socket(strHost, iPort);
        }
        catch(IOException socketError){
            if (DEBUG) System.err.println
                    ("Unable to connect to " + strHost);
            return false;
        }
        try {
            reader = new BufferedReader
                    (new InputStreamReader(sock.getInputStream()));
            writer = new BufferedWriter
                    (new OutputStreamWriter(sock.getOutputStream()));
        }
        catch (Exception e){
            if (DEBUG) System.err.println
                    ("Unable to obtain stream to/from " + strHost);
            return false;
        }
        return true;
    }

    public void handleSession(){
        String strInput = "";
        if (DEBUG) System.out.println ("Handling session with "
                + strHost + ":" + iPort);
        try {
            while ( (strInput = reader.readLine()) != null)
                handleInput (strInput);
        }
        catch (IOException e){
            if (DEBUG) System.out.println ("Handling session with "
                    + strHost + ":" + iPort);
        }
    }

    public void sendOutput(String strOutput){
        try {
            writer.write(strOutput, 0, strOutput.length());
        }
        catch (IOException e){
            if (DEBUG) System.out.println
                    ("Error writing to " + strHost);
        }
    }

    public void handleInput(String strInput){
        System.out.println(strInput);
    }

    public void closeSession(){
        try {
            writer = null;
            reader = null;
            sock.close();
        }
        catch (IOException e){
            if (DEBUG) System.err.println
                    ("Error closing socket to " + strHost);
        }
    }

    public void setHost(String strHost){
        this.strHost = strHost;
    }

    public void setPort(int iPort){
        this.iPort = iPort;
    }

    public static void main (String arg[]){
   /* debug main; does daytime on local host */
        String strLocalHost = "";
        try{
            strLocalHost =
                    InetAddress.getLocalHost().getHostName();
        }
        catch (UnknownHostException e){
            System.err.println ("Unable to find local host");
        }
        DefaultSocketClient d = new DefaultSocketClient
                (strLocalHost, iDAYTIME_PORT);
        d.start();
    }

}

