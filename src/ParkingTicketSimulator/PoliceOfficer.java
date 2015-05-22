package ParkingTicketSimulator;

/**
 * Created by Tangent Chang on 5/19/15.
 */
public class PoliceOfficer {
    private String name;
    private String badgeNum;

    PoliceOfficer(String name, String badgeNum){
        this.name = name;
        this.badgeNum = badgeNum;
    }

    //determine expiration based on info of parkedcar and parkingmeter
    ParkingTicket examineExpiration(ParkedCar car, ParkingMeter meter){
        int parkingMinutes = car.getParkingMinutes();
        int purchasedTime = meter.getPurchasedTime();
        int overTime = parkingMinutes - purchasedTime;
        if(overTime > 0){ return issueTicket(car, overTime, name, badgeNum);}
        else{ return null;}
    }

    //issue parking ticket if expired
    ParkingTicket issueTicket(ParkedCar car, int overTime, String policeName, String policeBadge){
        ParkingTicket newTicket = new ParkingTicket(car, overTime, policeName, policeBadge);
        newTicket.printTicket();
        return newTicket;
    }

    String getName(){ return name;}
    String getBadgeNum(){ return badgeNum;}
}
