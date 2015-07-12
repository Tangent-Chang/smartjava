package CarConfigApp;

import CarConfigApp.adapter.BuildAuto;
import org.junit.Test;


/**
 * Created by Tangent Chang on 7/9/15.
 */
public class CarConfigAppTest {
    @Test
    public void buildWithPropertyTest(){
        BuildAuto testDriver = new BuildAuto();
        testDriver.buildAuto("car.properties", 2);
        testDriver.printAuto("Prius");
        //System.out.println(testDriver.getModelList().get(0));
    }
}
