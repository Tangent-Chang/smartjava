package CarConfigApp.client;

import CarConfigApp.model.Automobile;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Tangent Chang on 7/10/15.
 */
public class SelectCarOption {
    public void configureCar(Socket client, ObjectOutputStream out){
        Scanner userInput = new Scanner(System.in);

        try{
            //receive model list from server
            InputStream is = client.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            ArrayList<String> modelList = (ArrayList<String>) ois.readObject();
            //display list
            for(String each : modelList){
                System.out.println(each);
            }

            //send server selected model name
            System.out.println("enter model name: ");
            String selectedAuto = userInput.nextLine();
            //OutputStream os = client.getOutputStream();
            //ObjectOutputStream out = new ObjectOutputStream(os);
            out.writeObject(selectedAuto);
            System.out.println("client receive " + selectedAuto);

            //receive that auto obj
            Automobile chosenAuto = (Automobile) ois.readObject();
            System.out.println("client receive auto obj: " + chosenAuto.getModelName());

            //configure: receive and display auto's options, then user make choice (send decision to server), and repeat
            chosenAuto.makeChoice();
        }
        catch(Exception e)
        {
            //System.out.println("Socket連線有問題 !" );
            System.out.println("IOException :" + e.toString());
        }

    }
}
