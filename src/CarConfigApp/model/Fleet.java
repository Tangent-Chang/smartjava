package CarConfigApp.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Tangent Chang on 6/24/15.
 */
public class Fleet {
    private Map<String, Automobile> autos;

    public Fleet(){
        autos = new LinkedHashMap<String, Automobile>();
    }

    public Automobile getAuto(String key){
        return autos.get(key);
    }
    public void setAuto(String index){
        autos.put(index, new Automobile());
    }
    public void setAuto(String index, Automobile auto){
        autos.put(index, auto);
    }

    public void updateAuto(String index, String maker, String modelName, float price){
        autos.get(index).setMaker(maker);
        autos.get(index).setModel(modelName);
        autos.get(index).setBasePrice(price);
    }

    public String findAuto(String modelName){
        String key = null;
        //Boolean flag = false;

        Map map = new HashMap();
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Automobile e = (Automobile) entry.getValue();
            if(e.getModel() == modelName){
                key = (String) entry.getKey();
                break;
            }
        }
        return key;
    }

    public void deleteAuto(String index){
        autos.remove(index);
    }
}
