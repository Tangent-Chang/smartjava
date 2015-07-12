package CarConfigApp.driver;

import CarConfigApp.adapter.BuildAuto;
import CarConfigApp.model.Automobile;
import CarConfigApp.scale.EditOptions;
import CarConfigApp.scale.FunctionCode;

/**
 * Created by Tangent Chang on 6/14/15.
 */
public class Driver {

        public static void main(String [] args) {
            BuildAuto testDriver = new BuildAuto();
            testDriver.buildAuto("car1.txt", 1);
            //testDriver.updateOptionPrice("haha", "Color", "Infra-Red Clearcoat", 100);
            //testDriver.updateOptionSetName("haha", "Color", "Color choice");
            testDriver.printAuto("Focus Wagon ZTW");

            //instantiation of BuildAuto
            //Create two threads using EditOptions, which will modify the same model as LinkedHashMap instance of Automobile (static object) in proxyAutomotive class instance.

            //args = set name, option name, new option name, new option price
            String[] parameter1 = {"Color", "Liquid Grey Clearcoat Metallic", "Grey", ""};
            String[] parameter2 = {"Color", "Liquid Grey Clearcoat Metallic", "", "100"};
            Automobile auto = testDriver.getFleet().getAuto("Focus Wagon ZTW");
            Thread t1 = new Thread(new EditOptions(FunctionCode.EDIT_OPTION_NAME, parameter1, auto), "t1");
            Thread t2 = new Thread(new EditOptions(FunctionCode.EDIT_OPTION_PRICE, parameter2, auto), "t2");

            t2.start();
            t1.start();
        }
}
