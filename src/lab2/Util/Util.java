package lab2.Util;

import lab2.Exception.CustomException;
import lab2.Model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by Tangent Chang on 5/21/15.
 */
public class Util {

    public static Student[] readFile(String filename, Student[] stu) throws CustomException {

        try {
            FileReader file = new FileReader(filename);
            BufferedReader buff = new BufferedReader(file);
            boolean eof = false;
            int sNum = 0;
            buff.readLine(); //to skip title row
            while (!eof) {
                String line = buff.readLine();
                if (line == null){
                    eof = true;
                }
                else {
                    if(sNum < 40){
                        stu[sNum] = accessScores(line);
                        sNum++;
                    }
                    else{
                        throw new CustomException(1, "over 40 students");
                    }
                }
            }
            buff.close();
        }
        catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }

        return stu;
    }

    static public Student accessScores(String line){
        StringTokenizer st = new StringTokenizer(line);
        Student a = new Student(Integer.parseInt(st.nextToken()));
        int[] scores = new int[5];
        int i = 0;
        while (st.hasMoreTokens()) {
            scores[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        a.setScores(scores);
        return a;
    }
}
