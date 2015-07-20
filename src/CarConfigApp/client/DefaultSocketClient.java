package CarConfigApp.client;

import CarConfigApp.model.Automobile;
import CarConfigApp.server.SocketClientConstants;
import CarConfigApp.server.SocketClientInterface;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Tangent Chang on 7/8/15.
 */
public class DefaultSocketClient extends Thread implements SocketClientInterface, SocketClientConstants {

    //private BufferedReader reader;
    //private BufferedWriter writer;
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
        /*try {
            reader = new BufferedReader
                    (new InputStreamReader(sock.getInputStream()));
            writer = new BufferedWriter
                    (new OutputStreamWriter(sock.getOutputStream()));
        }
        catch (Exception e){
            if (DEBUG) System.err.println
                    ("Unable to obtain stream to/from " + strHost);
            return false;
        }*/
        return true;
    }

    public void handleSession(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("enter function: ");
        String userChoice = userInput.nextLine();


        try{
            OutputStream os = sock.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(os);
            out.writeObject(userChoice);

            if(userChoice.equals("upload")){
                CarModelOptionsIO clientIO = new CarModelOptionsIO();
                System.out.println("client will upload property file in DefaultSocketClient");
                clientIO.uploadProperty(sock);
            }
            else if(userChoice.equals("configure")){
                SelectCarOption clientSelect = new SelectCarOption();
                clientSelect.configureCar(sock, out);


            }
            else{
                System.out.println("User choice is not valid!");
            }
        }
        catch(Exception e)
        {
            //System.out.println("Socket連線有問題 !" );
            System.out.println("IOException :" + e.toString());
        }


        /*try{
            ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());//送出object
            out.writeObject(propObj);
            out.flush();
            out.close();
        }
        catch(java.io.IOException e)
        {
            System.out.println("Socket連線有問題 !" );
            System.out.println("IOException :" + e.toString());
        }

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
        }*/
    }

    public void sendOutput(String strOutput){
        /*try {
            writer.write(strOutput, 0, strOutput.length());
        }
        catch (IOException e){
            if (DEBUG) System.out.println
                    ("Error writing to " + strHost);
        }*/
    }

    public void handleInput(String strInput){
        System.out.println(strInput);
    }

    public void closeSession(){
        try {
           /* writer = null;
            reader = null;*/
            //serverSocket.close();
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

    /*public static void main (String arg[]){  *//* debug main; does daytime on local host *//*
        String strLocalHost = "";
        try{
            strLocalHost = InetAddress.getLocalHost().getHostName();
        }
        catch (UnknownHostException e){
            System.err.println ("Unable to find local host");
        }
        DefaultSocketClient d = new DefaultSocketClient(strLocalHost, iDAYTIME_PORT);
        d.start();
    }*/
}

