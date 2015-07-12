package CarConfigApp.server;

import CarConfigApp.adapter.BuildAuto;
import CarConfigApp.model.Automobile;
import CarConfigApp.model.Properties;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Tangent Chang on 7/8/15.
 */
public class BuildCarModelOptions implements IAutoServer{
    static private BuildAuto auto = null;
    
    public ArrayList<String> getModelList(){
        ArrayList<String> list = new ArrayList<String>();
        if(auto != null){
            list = auto.getModelList();
        }
        return list;
    }
    public void sendSelectedAuto(ObjectOutputStream out, String modelName){
        auto.sendSelectedAuto(out, modelName);
    }

}
