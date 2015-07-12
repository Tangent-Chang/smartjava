package CarConfigApp.server;

import CarConfigApp.model.Properties;

import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Tangent Chang on 7/8/15.
 */
public interface IAutoServer {
    //public void buildWithProperty(Properties properObj);
    public ArrayList<String> getModelList();
    public void sendSelectedAuto(ObjectOutputStream out, String modelName);
}
