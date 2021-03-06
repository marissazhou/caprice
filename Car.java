/* Created by   :   Lijuan Marissa Zhou
   Email        :   marissa.lala.joo@gmail.com 
   Time         :   1/10/2014
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.EmptyStackException;

public class Car{

    public static void main(String[] args) {
        try {
            if (args.length>0){
                printStringCar(Integer.valueOf(args[0]));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static int printDistCar(String s) throws IOException{
        if (s == null || s.length() == 0) return 0;
        int dist = 0;
        int sign = -1;
        int speed = 1; 

        for (int i=0; i<s.length(); i++) { 
            if (i != 0 && s.charAt(i) == 'a'){
                speed *= 2;
                if (s.charAt(i-1) == 'r'){
                    speed = 1;
                }
            }
            else if (s.charAt(i) == 'r'){
                sign *= -1 ;
            }
            dist += sign*speed;
        }
        return dist;
    }

    public static String printStringCar(int num) throws IOException{
        ArrayList<Integer> idies = new ArrayList<Integer>();

        while (num > 0) {
            int c = 1;
            while((num>>c)>0) c++;
            idies.add(c);
            num = (1<<c)-num-1;
        }

        StringBuffer sb = new StringBuffer();
        int sign = 1;
        for (int i=0; i<idies.size(); i++) {
            if (i > 0)
                sb.append("r");
                System.out.print("r");
            for (int j=0; j<idies.get(i); j++)
                System.out.print("a");
                sb.append("a");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
