package CarConfigApp.client;

import CarConfigApp.adapter.BuildAuto;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by Tangnet Chang on 7/10/15.
 */
public class CarModelOptionsIO {
    //BuildAuto auto = new BuildAuto();
    //Socket client = new Socket();
    //private String serverAddress = "127.0.0.1";
    //private int serverPort = 8765;

    //a. Read data from the Properties file;
    //create properties object, using the load method, which transfers the object from the client to server, using ObjectStream.
    public void uploadProperty(Socket client){
        Properties properObj= new Properties();
        //InetSocketAddress isa = new InetSocketAddress(this.serverAddress, this.serverPort);
        try {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Enter file name: ");
            String fileName = userInput.nextLine();

            FileInputStream in = new FileInputStream(fileName);
            properObj.load(in);
            //client.connect(isa, 10000);
            OutputStream oos = client.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(oos);
            out.writeObject(properObj);

            client.shutdownOutput(); /* important */

            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            //ois.skip(Long.MAX_VALUE);
            String confirmation = (String) ois.readObject();
            System.out.println("from server : " + confirmation);


            in.close();
            out.close();


            //b. Receive a response from the Server, verifying that the Car Model object is created successfully.


        } catch (Exception e) {
            //System.out.println("Socket連線有問題 !");
            System.out.print("Error: " + e);
            System.exit(1);
        }

    }


    //c. Use CreateAuto interface to build Automobile and handle different type of files, passed in filetype.
}
