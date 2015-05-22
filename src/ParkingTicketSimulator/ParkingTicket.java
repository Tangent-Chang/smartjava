package ParkingTicketSimulator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Math;
import java.lang.*;

/**
 * Created by Tangent Chang on 5/19/15.
 */
public class ParkingTicket {

    private long ticketID = 0;
    private int fines = 0;
    private ParkedCar illegalCar;
    private PoliceOfficer police;

    ParkingTicket(ParkedCar illegalCar, int overTime, String policeName, String policeBadge){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String now = sdf.format(new Date());
        ticketID = Long.parseLong(now);

        this.illegalCar = illegalCar;

        countFines(overTime);

        police = new PoliceOfficer(policeName,policeBadge);
    }

    //report fine, $25 for first hour and $10 for each additional hour
    void countFines(int overTime){
        int overHours = (int)Math.ceil((float)overTime/60);
        fines = 25 + (overHours-1)*10;
    }

    void printTicket(){
        System.out.println("TicketID: " + ticketID);
        System.out.println("Fines: $" + fines);
        System.out.format("Car Info: %s, %s, %s, %s, %d %n", illegalCar.getMake(), illegalCar.getModel(), illegalCar.getColor(), illegalCar.getLicenseNum(), illegalCar.getParkingMinutes());
        System.out.format("Police Info: %s, %s %n", police.getName(), police.getBadgeNum());
    }

    long getTicketID(){ return ticketID;}
    int getFines(){ return fines;}
    ParkedCar getIllegalCar(){ return illegalCar;}
    PoliceOfficer getPolice(){ return police;}

}
