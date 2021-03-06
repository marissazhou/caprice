/* Created by   :   Lijuan Marissa Zhou
   Email        :   marissa.lala.joo@gmail.com 
   Time         :   1/10/2014
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.EmptyStackException;

public class DP{

    public static void main(String[] args) {
        try {
            if (args.length>0){
                System.out.println(numDecodings("123"));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    /** Decode ways, here only consider 01-26, more general to consider 001-n, n can be any number, log(10)(n) decide how many numbers to look back.
      * 
      * @param s the string to decode like '1235478' 
      * @return how many ways to decode the string
      * @see 
      *
    */
    public static int numDecodings(String s) throws IOException{
        if (s==null || s.length()==0) return 0;
        int[] nums = new int[s.length()+1];
        nums[0] = 1; 
        nums[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i<s.length()+1; i++) {
            if (s.charAt(i-1) != '0') nums[i] = nums[i-1]; 
            if (isValidChar(s.charAt(i-2),s.charAt(i-1))) nums[i] += nums[i-2]; 
        }
        return nums[s.length()];
    }
    public static boolean isValidChar(char c1, char c2) throws IOException{
        int v = (c1 - '0') * 10 + (c2 - '0');
        return v >= 10 && v <= 26;
    }
}
