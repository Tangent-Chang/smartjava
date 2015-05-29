package lab2.Model;

/**
 * Created by Tangent Chang on 5/21/15.
 */
public class Statistics implements Output{
    private int[] lowScores = new int[5];
    private int[] highScores = new int[5];
    private float[] avgScores = new float[5];

    public void findLow(Student[] a){
        for(int j = 0; j<5; j++){
            int i=0;
            int lowest = 100;
            while(i<40 && a[i]!=null && lowest !=0){
                if(a[i].getScores()[j]<lowest){
                    lowest = a[i].getScores()[j];
                }
                i++;
            }
            lowScores[j] = lowest;
        }
    }

    public void findHigh(Student[] a){
        for(int j = 0; j<5; j++) {
            int i=0;
            int highest = 0;
            while (i<40 && a[i] != null && highest != 100) {
                if (a[i].getScores()[j] > highest) {
                    highest = a[i].getScores()[j];
                }
                i++;
            }
            highScores[j] = highest;
        }
    }

    public void findAvg(Student[] a){
        for(int j=0; j<5; j++){
            float avg;
            int i=0;
            int sum=0;
            while(i<40 && a[i]!=null){
                sum = sum + a[i].getScores()[j];
                i++;
            }
            avg = sum/(i+1);
            avgScores[j] = avg;

        }
    }

    public void printResult(){
        System.out.format("High Score %d %d %d %d %d %n", highScores[0], highScores[1], highScores[2], highScores[3], highScores[4]);
        System.out.format("Low Score %d %d %d %d %d %n", lowScores[0], lowScores[1], lowScores[2], lowScores[3], lowScores[4]);
        System.out.format("Average %.2f %.2f %.2f %.2f %.2f %n", avgScores[0], avgScores[1], avgScores[2], avgScores[3], avgScores[4]);

    }

}
