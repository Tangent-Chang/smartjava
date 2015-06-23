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
    private static Automobile autoObj;

    public void buildAuto(String fileName){
        try {
            autoObj = FileIO.buildAutoObject(fileName);
        }
        catch (AutoException e){
            e.printException();
        }
    }
    public void printAuto(String modelName){
        autoObj.print();
    }
    public void updateOptionSetName(String modelName, String setName, String newName){
        autoObj.updateOptset(setName, newName);
    }
    public void updateOptionPrice(String modelName, String setName, String optName, float newPrice){
        autoObj.updateOption(setName, optName, newPrice);
    }
}
