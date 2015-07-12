package CarConfigApp.server;

import CarConfigApp.adapter.BuildAuto;

import java.io.ObjectOutputStream;

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
