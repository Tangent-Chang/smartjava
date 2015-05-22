package lab2;

/**
 * Created by Tangent Chang on 5/21/15.
 */
public class Student {
    private int SID;
    private int scores[] = new int[5];

    Student(int sid){
        SID = sid;
    }

    public int getSID(){ return SID;}
    public int[] getScores(){ return scores;}
    public void setScores(int[] scores){
        this.scores = scores;
    }

    public void printInfo(){}
}
