package CarConfigApp.util;

import CarConfigApp.exception.AutoException;
import CarConfigApp.exception.ModelError;
import CarConfigApp.model.Automobile;
//import CarConfigApp.model.Option;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Created by Tangent Chang on 6/14/15.
 */
public class FileIO {
    public static Automobile buildAutoObject(String fileName) throws AutoException{
        Automobile model = new Automobile();
        try{
            FileReader file = new FileReader(fileName);
            BufferedReader buff = new BufferedReader(file);
            boolean eof = false;

            String line;
            for(int i=0; i<2; i++){
                line = buff.readLine();
                if(line == null){eof = true;}
                else{
                    String[] array = line.split(": ");
                    try{
                        if(array.length == 2){
                            if(i == 0){
                                model.setName(array[1]);
                            }
                            else if(i == 1){
                                try {
                                    float basePrice = NumberFormat.getNumberInstance(java.util.Locale.US).parse(array[1]).floatValue();
                                    model.setBasePrice(basePrice);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        else{
                            if(i == 0){ throw new AutoException(ModelError.MISSING_MODEL_NAME);}
                            else if(i == 1){ throw new AutoException(ModelError.MISSING_MODEL_PRICE);}
                        }
                    }
                    catch(AutoException e){
                        e.fix(e.getErrorCode().getNumber(), model);
                    }
                }
            }

            int i = 0; //number of line
            while(!eof){
                line = buff.readLine();
                if (line == null) {
                    eof = true;
                }
                else{
                    String[] optionSet = line.split(": "); //setName + options
                    try {
                        if (optionSet.length != 2 || optionSet[0].isEmpty() || optionSet[1].isEmpty()) {
                            throw new AutoException(ModelError.MISSING_OPTIONSET_DATA);
                        } else {
                            String[] options = optionSet[1].split("; "); //(optionName + price)*n
                            model.setOptset(i, optionSet[0], options.length);
                            for (int j = 0; j < options.length; j++) {
                                String[] option = options[j].split(", "); //optionName + price
                                if (option.length < 2) {
                                    throw new AutoException(ModelError.MISSING_OPTION_DATA);
                                } else {
                                    try {
                                        float price = NumberFormat.getNumberInstance(java.util.Locale.US).parse(option[1]).floatValue();
                                        model.setOption(i, j, option[0], price);
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                }

                            }
                        }
                    }
                    catch(AutoException e){
                        e.fix(e.getErrorCode().getNumber(), model);
                    }

                }
                i++;
            }
            buff.close();
        }
        catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
        return model;
    }

    public static void serializeAuto(Automobile car){
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("car.dat"));
            out.writeObject(car);
            out.close();
        }
        catch(Exception e){
            System.out.print("Error: " + e);
            System.exit(1);
        }
    }

    public static Automobile deserializeAuto(){
        Automobile newCar = null;
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("car.dat"));
            newCar = (Automobile) in.readObject();
        }
        catch(Exception e){
            System.out.print("Error: " + e);
            System.exit(1);
        }
        return newCar;
    }
}
