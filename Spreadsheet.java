/* Created by   :   Lijuan Marissa Zhou
   Email        :   marissa.lala.joo@gmail.com 
   Time         :   1/10/2014
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Stack;
import java.util.EmptyStackException;

public class Spreadsheet{

    public static void main(String[] args) {
        try {
            if (args.length>0){
                decToExcel(args[0]);
                excelToDec(args[1]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void decToExcel(String s) throws IOException{
        StringBuffer result = new StringBuffer();
        int value = Integer.parseInt(s);
        char digit = (char)('A' + (value -1)%26);
        result.append(digit);
        while ((value-1)%26 > 0) {
            value = ( value - 1)/26;
            digit = (char)('A' + (value -1)%26);
            result.append(digit);
        }
        System.out.println(result.toString());
    }

    public static void excelToDec(String s) throws IOException{
        int result = 0;
        for (int i=0; i<s.length(); i++){
            result *= 26;
            result += s.charAt(i)-'A'+1;
        }
        System.out.println(result);
    }
}
