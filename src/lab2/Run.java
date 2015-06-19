package lab2;

import lab2.Exception.CustomException;
import lab2.Model.Statistics;
import lab2.Model.Student;
import lab2.Util.Util;

/**
 * Created by Tangent Chang on 5/27/15.
 */
public class Run {
    public static void main(String [] args) {
        Student lab2 [] = new Student[40]; //Populate the student array
        Util util = new Util();

        try{
            lab2 = util.readData("student_scores.txt", lab2);
            Statistics statlab2 = new Statistics();
            statlab2.findHigh(lab2);
            statlab2.findLow(lab2);
            statlab2.findAvg(lab2);

            String title = "Stud Q1  Q2  Q3  Q4  Q5";
            System.out.println(title);

            for(Student each: lab2){
                if(each!=null) {
                    each.printResult();
                }
            }
            // Print the data and statistics
            statlab2.printResult();
        }
        catch(CustomException c){
            System.out.println("Error -- " + c.getErrorNo() + c.getErrorMsg());

        }


    }
}
