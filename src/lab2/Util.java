package lab2;

import com.sun.tools.javac.util.ArrayUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Tangent Chang on 5/21/15.
 */
public class Util {

    static Student[] readFile(String filename, Student[] stu){

        try {
            FileReader file = new FileReader(filename);
            BufferedReader buff = new BufferedReader(file);
            boolean eof = false;
            int sNum = 0;
            while (!eof && sNum<40) {
                String line = buff.readLine();
                if (line == null){
                    eof = true;
                }
                else {
                    String[] splited = line.split(" ");
                    Student a = new Student(Integer.parseInt(splited[0])); //要剔除第一列，那是文字
                    int[] scores = {Integer.parseInt(splited[1]),Integer.parseInt(splited[2]),Integer.parseInt(splited[3]),Integer.parseInt(splited[4]),Integer.parseInt(splited[5])};
                    a.setScores(scores);
                    stu[sNum] = a;
                    sNum++;
                }
            }
            buff.close();
        }
        catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }

        return stu;
    }

    static void writeFile(){}
}
