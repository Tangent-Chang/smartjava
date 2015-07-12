package CarConfigApp.adapter;

import CarConfigApp.exception.AutoException;
import CarConfigApp.model.*;
import CarConfigApp.scale.EditOptions;
import CarConfigApp.scale.FunctionCode;
import CarConfigApp.util.FileIO;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Tangent Chang on 6/20/15.
 */
public abstract class ProxyAutomobile {
    private static Fleet fleetObj = new Fleet();

    public Fleet getFleet(){ return fleetObj;}

    public void buildAuto(String fileName, int fileType){
        Automobile autoObj;
        try {
            switch(fileType){
                case 1:  //previous text file
                    autoObj = FileIO.buildAutoObject(fileName);
                    fleetObj.setAuto(autoObj.getModelName(), autoObj);
                    break;
                case 2:  //properties file
                    autoObj = new Automobile();
                    Properties properObj = FileIO.buildWithProperty(fileName);
                    autoObj.setModelName(properObj.getModelName());
                    autoObj.setMaker(properObj.getMaker());
                    autoObj.setOptionsets(properObj.getOptionsets());
                    fleetObj.setAuto(autoObj.getModelName(), autoObj);
                    break;
            }
        }
        catch (AutoException e){
            e.printException();
            e.writeException();
        }
    }
    public void printAuto(String modelName){
        fleetObj.getAuto(fleetObj.findAuto(modelName)).print();
    }
    public void updateOptionSetName(String modelName, String setName, String newName){
        fleetObj.getAuto(fleetObj.findAuto(modelName)).updateOptionset(setName, newName);
    }
    public void updateOptionPrice(String modelName, String setName, String optName, float newPrice){
        fleetObj.getAuto(fleetObj.findAuto(modelName)).updateOption(setName, optName, optName, newPrice);
    }
    public void fixException(int errorNo){
        AutoException e = new AutoException();
        //e.fix(errorNo, fleetObj.getAuto(modelName));
    }

    public void editOptions(String modelName, FunctionCode func, String[] args){
        String k = fleetObj.findAuto(modelName);
        EditOptions edit = new EditOptions(func, args, fleetObj.getAuto(k));
        edit.run();
        //edit.editOptions(fleetObj.getAuto(k), func, args);
    }

    /*public void buildWithProperty(Properties properObj){
        Automobile autoObj = new Automobile();
        //Properties properObj = FileIO.buildWithProperty(fileName);
        //parse properties obj to auto obj
        autoObj.setModelName(properObj.getModelName());
        autoObj.setMaker(properObj.getMaker());
        autoObj.setOptionsets(properObj.getOptionsets());

        fleetObj.setAuto(autoObj.getModelName(), autoObj);
    }*/

    public ArrayList<String> getModelList(){
        ArrayList<String> nameList = new ArrayList<>();

        Iterator iter = fleetObj.getAutos().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Automobile a = (Automobile) entry.getValue();
            nameList.add(a.getModelName());
        }
        return nameList;
    }
    public void sendSelectedAuto(ObjectOutputStream out, String modelName){
        String k = fleetObj.findAuto(modelName);
        Automobile a = fleetObj.getAuto(k);
        FileIO.serializeAuto(a);
    }
}
