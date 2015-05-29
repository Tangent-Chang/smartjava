package lab2.Model;

/**
 * Created by Tangent Chang on 5/21/15.
 */
public class Student implements Output {
    private int SID;
    private int scores[] = new int[5];

    public Student(int sid){
        SID = sid;
    }

    public int getSID(){ return SID;}
    public int[] getScores(){ return scores;}
    public void setScores(int[] scores){
        this.scores = scores;
    }

    public void printResult(){
        System.out.format("%s %03d %03d %03d %03d %03d %n", SID, scores[0], scores[1], scores[2], scores[3], scores[4]);
    }
}
