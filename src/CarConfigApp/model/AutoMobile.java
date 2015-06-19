package CarConfigApp.model;

import java.io.Serializable;

/**
 * Created by Tangent Chang on 6/14/15.
 */
public class Automobile implements Serializable{
    private String name;
    private OptionSet optSets[];
    private float basePrice;

    public Automobile(){}
    public Automobile(String n){
        name = n;
        optSets = new OptionSet[5];
    }
    public Automobile(String n, float price){
        name = n;
        basePrice = price;
        optSets = new OptionSet[5];
    }

    public String getName(){return name;}
    public void setName(String n){ name = n;}
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
        optSets[setIndex].findOptByName(optName);
        return -1;
    }

    public void deleteOptset(int setIndex){
        for(int j=setIndex; j<optSets.length; j++){
            optSets[j] = optSets[j+1];
        }
        optSets[optSets.length-1] = null;
    }
    public void deleteOption(int setIndex, int optIndex){
        optSets[setIndex].deleteOpt(optIndex);
    }

    public void updateOption(int i, int j, String optName, float p){
        optSets[i].updateOpt(j, optName, p);
    }
    public void updateOptset(int i, String[] names, float[] prices){
        optSets[i].updateOpts(names, prices);
    }

    public void print(){
        System.out.format("Name: %s %nBase Price: %f %nSets quantity: %d %n", name, basePrice, optSets.length);
        for(int i=0; i<optSets.length; i++){
            System.out.print(optSets[i].getName()+"\n");
            for(int j=0; j<optSets[i].getOpts().length; j++){
                System.out.print(" "+optSets[i].getOpt(j).getName()+", "+optSets[i].getOpt(j).getPrice()+"\n");
            }
        }

    }
}
