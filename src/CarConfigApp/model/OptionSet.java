package CarConfigApp.model;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by Tangent Chang on 6/14/15.
 */
class OptionSet implements Serializable{

    private Option opts [];
    private String name;

    protected OptionSet(){}
    protected OptionSet(String n, int size){
        name = n;
        opts = new Option[size];
    }
    protected OptionSet(String n, int size, Option[] options){
        opts = new Option[size];
        for(int i = 0; i<opts.length;i++){
            opts[i] = new Option(options[i].getName(), options[i].getPrice());
        }
        name = n;
    }

    protected String getName(){return name;}
    protected void setName(String n){ name = n;}
    protected Option[] getOpts(){return opts;}
    //protected void setOpts(int size){ opts = new Option[size];}
    protected void setOpts(String[] names, float[] prices){
        for(int i=0; i<names.length; i++){
            opts[i] = new Option(names[i], prices[i]);
        }
    }
    protected Option getOpt(int i){return opts[i];}
    protected void setOpt(int i, String n, float p){
        opts[i] = new Option();
        opts[i].setName(n);
        opts[i].setPrice(p);
    }

    protected int findOptByName(String n){
        for(int i=0;i<opts.length;i++){
            if(opts[i].getName().equals(n)){return i;}
        }
        return -1;
    }

    protected void deleteOpt(int i){
        for(int j=i; j<opts.length-1; j++){
            opts[j] = opts[j+1];
        }
        opts[opts.length-1] = null;
    }
    protected void deleteOpt(String optName){
        int i = findOptByName(optName);
        for(int j=i; j<opts.length; j++){
            opts[j] = opts[j+1];
        }
        opts[opts.length-1] = null;
    }

    protected void updateOpt(int i, String n, float p){
        opts[i].setName(n);
        opts[i].setPrice(p);
    }
    protected void updateOpt(String optName, String n, float p){
        int i = findOptByName(optName);
        opts[i].setName(n);
        opts[i].setPrice(p);
    }
    protected void updateOpts(String[] names, float[] prices){
        for(int i=0; i<names.length; i++){
            opts[i].setName(names[i]);
            opts[i].setPrice(prices[i]);
        }
    }

    class Option implements Serializable{
        private String name; //this is value too. e.g. red
        private float price;

        protected Option(){}
        protected Option(String n, float p){
            name = n;
            price = p;
        }

        protected String getName(){return name;}
        protected void setName(String n){ name = n;}
        protected float getPrice(){return price;}
        protected void setPrice(float p){price = p;}
        //protected String getValue(){return value;}
        //protected void setValue(){}

    }


}

