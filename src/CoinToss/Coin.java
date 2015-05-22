package CoinToss;

import java.util.Random;

/**
 * Created by Tangent Chang on 5/19/15.
 */
public class Coin {

    String sideUp;
    Coin(){
        toss();
    }

    void toss(){
        Random rand = new Random();
        Boolean  face = rand.nextBoolean();
        if(face == true){ sideUp = "tails";}
        else { sideUp = "heads";}
    }
    public String getSideUp(){
        return sideUp;
    }
}
