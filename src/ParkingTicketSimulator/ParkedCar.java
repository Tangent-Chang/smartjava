package ParkingTicketSimulator;

/**
 * Created by Tangent Chang on 5/19/15.
 */
public class ParkedCar {
    private String make;
    private String model;
    private String color;
    private String licenseNum;
    private int parkingMinutes;

    ParkedCar(String make, String model, String color, String licenseNum, int parkingMinutes){
        this.make = make;
        this.model = model;
        this.color = color;
        this.licenseNum = licenseNum;
        this.parkingMinutes = parkingMinutes;
    }

    String getMake(){ return make;}
    String getModel(){ return model;}
    String getColor(){ return color;}
    String getLicenseNum(){ return licenseNum;}
    int getParkingMinutes(){ return parkingMinutes;}

    void updateParkingMinutes(int minutes){ parkingMinutes = minutes;}
}
