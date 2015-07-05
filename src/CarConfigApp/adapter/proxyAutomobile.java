package CarConfigApp.adapter;

import CarConfigApp.exception.AutoException;
import CarConfigApp.model.*;
import CarConfigApp.scale.EditOptions;
import CarConfigApp.scale.FunctionCode;
import CarConfigApp.util.FileIO;

/**
 * Created by Tangent Chang on 6/20/15.
 */
public abstract class ProxyAutomobile {
    private static Fleet fleetObj = new Fleet();

    public Fleet getFleet(){ return fleetObj;}
    public void buildAuto(String fileName){
        Automobile autoObj;
        try {
            autoObj = FileIO.buildAutoObject(fileName);
            fleetObj.setAuto(autoObj.getModelName(), autoObj);
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

    /*public void editModelName(String modelName, String newName){
        EditOptions edit = new EditOptions();
        edit.editModelName(fleetObj.getAuto(fleetObj.findAuto(modelName)), newName);
    }
    public void editModelBasePrice(String modelName, float newPrice){
        EditOptions edit = new EditOptions();
        edit.editModelBasePrice(fleetObj.getAuto(fleetObj.findAuto(modelName)), newPrice);
    }
    public void editOptionsetName(String modelName, String optionsetName, String newName){
        EditOptions edit = new EditOptions();
        String k = fleetObj.findAuto(modelName);
        //int i = fleetObj.getAuto(k).findOptionsetByName(optionsetName);
        edit.editOptionsetName(fleetObj.getAuto(k), optionsetName, newName);
    }
    public void editOptionName(String modelName, String optionsetName, String optionName, String newName){
        EditOptions edit = new EditOptions();
        String k = fleetObj.findAuto(modelName);
        //int i = fleetObj.getAuto(k).findOptionsetByName(optionsetName);
        //int j = fleetObj.getAuto(k).findOptionByName(i,optionName);
        edit.editOptionName(fleetObj.getAuto(k),optionsetName, optionName, newName);
    }
    public void editOptionPrice(String modelName, String optionsetName, String optionName, float newPrice){
        EditOptions edit = new EditOptions();
        String k = fleetObj.findAuto(modelName);
        edit.editOptionPrice(fleetObj.getAuto(k), optionsetName, optionName, newPrice);
    }*/
}
