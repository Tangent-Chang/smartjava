package CarConfigApp.model;
import CarConfigApp.util.FileIO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Tangent Chang on 6/14/15.
 */
public class CarConfigAppModelTest {

    Automobile model = new Automobile("BMW", 30000);
    float delta = 0;

    @Test
    public void automobilePrintTest(){
        FileIO file = new FileIO();
        Automobile FW = file.buildAutoObject("car1.txt");
        FW.print();
        file.serializeAuto(FW);
        Automobile newFW = file.deserializeAuto();
        newFW.print();
    }

    @Test
    public void automobileBasicGetSetTest(){
        model.setName("BMW 3 series");
        model.setBasePrice(36900);
        assertEquals("BMW 3 series",model.getName());
        assertEquals(36900, model.getBasePrice(),delta);
    }

    @Test
    public void initializeOneOptsetTest(){
        model.setOptset(0, "Color", 2);
        int i = model.findOptsetByName("Color");
        String[] names = {"Red", "Blue"};
        float[] prices = {100, 100};
        model.setOptions(i,names,prices);

        assertEquals("Color", model.getOptset(i).getName());
        assertEquals("Blue", model.getOptset(i).getOpt(1).getName());
        float sum = model.getOptset(0).getOpt(0).getPrice() + model.getOptset(0).getOpt(1).getPrice();
        assertEquals(200, sum, delta);
    }

    @Test
    public void initializeTwoOptsetsTest(){
        String[] setNames = {"Side impact air bags", "Power moonroof"};
        int[] optSizes = {2, 2};
        model.setOptsets(3,setNames, optSizes);

        String[] optNames1 = {"none","selected"};
        float[] optPrices1 = {0, 350};
        model.setOptions(model.findOptsetByName("Side impact air bags"), optNames1, optPrices1);

        String[] optNames2 = {"none","selected"};
        float[] optPrices2 = {0, 595};
        model.setOptions(model.findOptsetByName("Power moonroof"), optNames2, optPrices2);

        assertEquals("none", model.getOptset(3).getOpt(0).getName());
        assertEquals(595, model.getOptset(4).getOpt(1).getPrice(), delta);
    }


}
