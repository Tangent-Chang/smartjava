package CarConfigApp.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

/**
 * Created by Tangent Chang on 7/14/15.
 */
public class DefaultSocketServer extends Thread implements SocketClientInterface, SocketClientConstants {

    private Socket sock;
    private ServerSocket serverSocket;
    private String strHost;
    private int iPort;
    ObjectInputStream ois;
    IAutoServer autoServer = new BuildCarModelOptions();

    public DefaultSocketServer(String strHost, int iPort) {
        setPort(iPort);
        setHost(strHost);
    }//constructor

    public DefaultSocketServer(ServerSocket serverSocket, Socket sock) {
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
        /*try { //already setup in constructor
            //sock = new Socket(strHost, iPort);
            serverSocket = new ServerSocket(iPort);
        }
        catch(IOException socketError){
            if (DEBUG) System.err.println
                    ("Unable to connect to " + strHost);
            return false;
        }*/

        try {
            ois = new ObjectInputStream(sock.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
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
        }
        return true;*/
    }

    public void handleSession(){

        try {
            //ois.skip(Long.MAX_VALUE);
            String clientOption = (String) ois.readObject();
            System.out.println("from client, clientOption: " + clientOption);

            if(clientOption.equals("upload")){
                ois = new ObjectInputStream(sock.getInputStream());

                System.out.println("server receives property object in DefaultSocketServer");
                Properties propObj = (Properties) ois.readObject();
                System.out.println("server will build auto with property in DefaultSocketServer");
                if(autoServer.buildWithProperty(propObj)){
                    ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
                    //oos.flush();
                    //send confirmation message
                    oos.writeObject("ok");
                    System.out.println("Message sent to the client is " + "ok");
                }
            }
            else if(clientOption.equals("configure")){
                //send client model list
                ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
                oos.writeObject(autoServer.getModelList());
                
                //receive chosen auto name, then send auto obj
                String chosenAutoName = (String) ois.readObject();
                System.out.println("receive auto name in DefaultSocketServer");
                autoServer.sendSelectedAuto(oos, chosenAutoName);
                //sock.shutdownOutput(); /* important */
            }
            else{
                System.err.println("Invalid input from client!!!!!!!!!!");
            }

        }
        catch (EOFException eof) {

        } catch (Exception e) {
            e.printStackTrace();
        }


        /*String strInput = "";
        if (DEBUG) System.out.println ("Handling session with " + strHost + ":" + iPort);
        try {
            while ( (strInput = reader.readLine()) != null)
                handleInput (strInput);
        }
        catch (IOException e){
            if (DEBUG) System.out.println ("Handling session with "
                    + strHost + ":" + iPort);
        }*/
    }

    /*public void sendOutput(String strOutput){
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
    }*/

    public void closeSession(){
        try {
            sock.close();
            serverSocket.close();
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

}
