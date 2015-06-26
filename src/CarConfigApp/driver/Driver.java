package CarConfigApp.driver;

import CarConfigApp.adapter.BuildAuto;
import CarConfigApp.exception.AutoException;
import CarConfigApp.model.Automobile;

/**
 * Created by Tangent Chang on 6/14/15.
 */
public class Driver {

        public static void main(String [] args) {
            BuildAuto testDriver = new BuildAuto();
            testDriver.buildAuto("car1.txt");
            //testDriver.updateOptionPrice("haha", "Color", "Infra-Red Clearcoat", 100);
            //testDriver.updateOptionSetName("haha", "Color", "Color choice");
            testDriver.printAuto("Focus Wagon ZTW");
        }
}
