package lab2;

/**
 * Created by Tangent Chang on 5/21/15.
 */
public class Statistics {
    int[] lowScores = new int[5];
    int[] highScores = new int[5];
    float[] avgScores = new float[5];

    void findLow(Student[] a){}
    void findHigh(Student[] a){}
    void findAvg(Student[] a){}

    public static void main(String [] args) {
        Student lab2 [] = new Student[40]; //Populate the student array
        lab2 = Util.readFile("student_scores.txt", lab2);
        System.out.println(lab2[0].getSID());
        //Statistics statlab2 = new Statistics();
        //statlab2.findLow(lab2);//add calls to findhigh and find average //Print the data and statistics
    }

}
