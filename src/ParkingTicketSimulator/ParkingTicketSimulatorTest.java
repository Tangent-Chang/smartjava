package ParkingTicketSimulator;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Tangent Chang on 5/20/15.
 */
public class ParkingTicketSimulatorTest {

    ParkedCar bmw = new ParkedCar("BMW","320i","red","ABC-2345",150);
    ParkedCar toyota = new ParkedCar("Toyota","Camry XSE","red","OHZ-7788",80);
    ParkingMeter meter1 = new ParkingMeter(bmw, 60);
    ParkingMeter meter2 = new ParkingMeter(toyota, 80);
    PoliceOfficer john = new PoliceOfficer("John", "01023");

    @Test
    //one police issue a ticket to a illegal car with 1.5 hours overtime.
    public void illegalTest(){
        ParkingTicket ticket = john.examineExpiration(bmw, meter1);
        assertTrue(ticket.getFines() == 35);
    }

    @Test
    public void legalTest(){
        ParkingTicket ticket = john.examineExpiration(toyota, meter2);
        assertNull(ticket);
    }

    @Test
    public void checkTwiceTest(){
        ParkingTicket ticket1 = john.examineExpiration(toyota, meter2);
        assertNull(ticket1);
        toyota.updateParkingMinutes(180);
        ParkingTicket ticket2 = john.examineExpiration(toyota, meter2);
        assertTrue(ticket2.getFines() == 35);
    }
}
