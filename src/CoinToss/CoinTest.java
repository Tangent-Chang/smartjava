package CoinToss;

/**
 * Created by Tangent Chang on 5/19/15.
 */
public class CoinTest {
    public static void main(String[] args) {

        int headNum = 0;
        int tailNum = 0;

        Coin penny = new Coin();
        System.out.println("Initial side up:" + penny.getSideUp());
        for(int i=0; i<20; i++){
            penny.toss();
            System.out.println(i+1 + ". " + penny.getSideUp());
            if(penny.getSideUp()=="heads"){ headNum++;}
            else{ tailNum++;}
        }

        System.out.println("Number of times of heads:" + headNum);
        System.out.println("Number of times of tails:" + tailNum);
    }
}
