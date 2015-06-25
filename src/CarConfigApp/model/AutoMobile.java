package CarConfigApp.model;

import java.io.Serializable;

/**
 * Created by Tangent Chang on 6/14/15.
 */
public class Automobile implements Serializable{
    //private String make;
    private String modelName;
    private OptionSet optSets[];
    private float basePrice;
    private int setsSize = 5;

    public Automobile(){
        optSets = new OptionSet[setsSize];
    }
    public Automobile(String n){
        modelName = n;
        optSets = new OptionSet[setsSize];
    }
    public Automobile(String n, float price){
        modelName = n;
        basePrice = price;
        optSets = new OptionSet[setsSize];
    }

    public String getName(){return modelName;}
    public void setName(String n){ modelName = n;}
    public float getBasePrice(){return basePrice;}
    public void setBasePrice(float p){ basePrice = p;}

    public OptionSet getOptset(int setIndex){return optSets[setIndex];}
    //initialize one optset of optsets
    public void setOptset(int setIndex, String setName, int optSize){
        optSets[setIndex] = new OptionSet(setName, optSize);
    }
    public void setOptset(int setIndex, String setName, int optSize, String[] optNames, float[] optPrices){
        optSets[setIndex] = new OptionSet(setName, optSize);
        optSets[setIndex].setOpts(optNames, optPrices);
    }
    public OptionSet[] getOptsets(){ return optSets;}
    //initialize all optset of optsets
    public void setOptsets(int start, String[] setNames, int[] optSizes){
        for(int i=0; i<setNames.length; i++){
            optSets[start+i] = new OptionSet(setNames[i], optSizes[i]);
        }
    }

    public void setOption(int setIndex, int optIndex, String optName, float optPrice){
        //optSets[i] = new OptionSet(setName);
        optSets[setIndex].setOpt(optIndex,optName,optPrice);
    }
    public void setOptions(int setIndex, String[] optNames, float[] optPrices){
        //optSets[i] = new OptionSet(n, optNames.length);
        optSets[setIndex].setOpts(optNames, optPrices);
    }

    //get the index of optionset
    public int findOptsetByName(String optsetName){
        for(int i=0;i<optSets.length;i++){
            if(optSets[i] == null){ }
            else if(optSets[i].getName().equals(optsetName)){return i;}
        }
        return -1;
    }
    //get the index of option
    public int findOptionByName(int setIndex, String optName){
        int i = optSets[setIndex].findOptByName(optName);
        return i;
    }

    public void deleteOptset(int setIndex){
        for(int j=setIndex; j<optSets.length-1; j++){
            optSets[j] = optSets[j+1];
        }
        optSets[optSets.length-1] = null;
    }
    public void deleteOption(int setIndex, int optIndex){
        optSets[setIndex].deleteOpt(optIndex);
    }

    public void updateOption(String optsetName, String optName, float p){
        int i = findOptsetByName(optsetName);
        int j = findOptionByName(i, optName);
        optSets[i].updateOpt(j, optName, p);
    }
    public void updateOption(int setIndex, int optIndex, String optName, float p){
        optSets[setIndex].updateOpt(optIndex, optName, p);
    }
    public void updateOptset(String setName, String newName){
        int i = findOptsetByName(setName);
        optSets[i].setName(newName);
    }
    public void updateOptset(int setIndex, String setName, String[] names, float[] prices){
        optSets[setIndex].setName(setName);
        optSets[setIndex].updateOpts(names, prices);
    }

    public void print(){
        System.out.format("Name: %s %nBase Price: %f %nSets quantity: %d %n", modelName, basePrice, optSets.length);
        for(int i=0; i<optSets.length; i++){
            System.out.print(optSets[i].getName()+"\n");
            for(int j=0; j<optSets[i].getOpts().length; j++){
                System.out.print(" "+optSets[i].getOpt(j).getName()+", "+optSets[i].getOpt(j).getPrice()+"\n");
            }
        }

    }
}
