package CarConfigApp.adapter;

import CarConfigApp.exception.AutoException;
import CarConfigApp.exception.ErrorCode;
import CarConfigApp.exception.ModelError;
import CarConfigApp.model.*;
import CarConfigApp.util.FileIO;

/**
 * Created by Tangent Chang on 6/20/15.
 */
public abstract class ProxyAutomobile {
    private static Fleet fleetObj = new Fleet();

    public void buildAuto(String fileName){
        Automobile autoObj;
        try {
            autoObj = FileIO.buildAutoObject(fileName);
            fleetObj.setAuto(autoObj.getModel(), autoObj);
        }
        catch (AutoException e){
            e.printException();
            e.writeException();
        }
    }
    public void printAuto(String modelName){
        fleetObj.getAuto(modelName).print();
    }
    public void updateOptionSetName(String modelName, String setName, String newName){
        fleetObj.getAuto(modelName).updateOptionset(setName, newName);
    }
    public void updateOptionPrice(String modelName, String setName, String optName, float newPrice){
        fleetObj.getAuto(modelName).updateOption(setName, optName, newPrice);
    }
    public void fixException(int errorNo){
        AutoException e = new AutoException();
        //e.fix(errorNo, fleetObj.getAuto(modelName));
    }
}
