package ParkingTicketSimulator;

/**
 * Created by Tangent Chang on 5/19/15.
 */
public class ParkingMeter {
    //report purchased time
    private int purchasedTime;
    private ParkedCar car;

    ParkingMeter(ParkedCar car, int purchasedTime){
        this.car = car;
        this.purchasedTime = purchasedTime;
    }

    int getPurchasedTime(){
        return purchasedTime;
    }

}
