package CarConfigApp.model;
import CarConfigApp.exception.AutoException;
import CarConfigApp.util.FileIO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Tangent Chang on 6/14/15.
 */
public class CarConfigAppModelTest {

    Automobile model = new Automobile();
    float delta = 0;

    @Test
    public void automobilePrintTest(){
        try{
            Automobile FW = FileIO.buildAutoObject("car1.txt");
            FW.print();
            FileIO.serializeAuto(FW);
            Automobile newFW = FileIO.deserializeAuto();
            newFW.print();
        }
        catch (AutoException e){
            e.printException();
        }
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
        model.setOptionset("Color");
        String[] names = {"Red", "Blue"};
        float[] prices = {100, 100};
        int i = model.findOptionsetByName("Color");

        for(int j=0; j< names.length; j++){
            model.setOption(i,names[j],prices[j]);
        }

        assertEquals("Color", model.getOptionset(i).getName());
        assertEquals("Blue", model.getOptionset(i).getOption(1).getName());
        float sum = model.getOptionset(0).getOption(0).getPrice() + model.getOptionset(0).getOption(1).getPrice();
        assertEquals(200, sum, delta);
    }

    @Test
    public void initializeTwoOptsetsTest(){
        model.setOptionset("Side impact air bags");
        int i = model.findOptionsetByName("Side impact air bags");
        model.setOption(i, "none", 0);
        model.setOption(i, "selected", 350);

        model.setOptionset("Power moonroof");
        int j = model.findOptionsetByName("Power moonroof");
        model.setOption(j, "none", 0);
        model.setOption(j, "selected", 595);

        assertEquals("none", model.getOptionset(i).getOption(0).getName());
        assertEquals(595, model.getOptionset(j).getOption(1).getPrice(), delta);
    }

    @Test
    public void findOptionByNameTest(){
        model.setOptionset("Color");
        String[] names = {"Red", "Blue", "White", "Black", "Yellow"};
        float[] prices = {0, 0, 0, 0, 0};
        int i = model.findOptionsetByName("Color");
        for(int j = 0; j < names.length; j++){
            model.setOption(i, names[j], prices[j]);
        }

        assertEquals(2, model.getOptionset(i).findOptionByName("White"));
    }

    @Test
    public void deleteOptsetTest(){
        model.setOptionset("Side impact air bags");
        model.setOptionset("Power moonroof");

        assertTrue(model.getOptionsets().size()==2);

        model.deleteOptionset(1);

        assertTrue(model.getOptionsets().size()==1);

    }
    @Test
    public void deleteOptionTest(){
        model.setOptionset("Color");
        String[] names = {"Red", "Blue", "White", "Black", "Yellow"};
        float[] prices = {0, 0, 0, 0, 0};
        int i = model.findOptionsetByName("Color");
        for(int j = 0; j < names.length; j++){
            model.setOption(i, names[j], prices[j]);
        }
        assertTrue(model.getOptionset(i).getOptions().size()==5);

        model.deleteOption(i, 2);
        model.deleteOption(i, 3);
        assertTrue(model.getOptionset(i).getOptions().size()==3);
    }
    @Test
    public void updateOptionTest(){
        model.setOptionset("Color");
        int i = model.findOptionsetByName("Color");
        model.setOption(i, "Red", 100);
        model.setOption(i, "Blue", 100);

        model.updateOption("Color", "Red", 50);

        assertEquals(50, model.getOptionset(i).getOption(0).getPrice(), delta);
    }
    @Test
    public void updateOptsetTest(){
        model.setOptionset("Color");
        model.updateOptionset("Color", "new color");
        assertEquals("new color", model.getOptionset(model.findOptionsetByName("new color")).getName());
    }
}
