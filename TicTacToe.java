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

public class TicTacToe{

    public static HashMap<String> dictionary = new HashMap<String>();

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

    public static String playGame(char[][] chars) throws IOException{
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
