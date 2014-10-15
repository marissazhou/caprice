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

public class Bit{

    public static void main(String[] args) {
        try {
            if (args.length>0){
                byte[] d = new byte[]{(byte)10101001, (byte)01001100};
                byte[] p = new byte[]{(byte)10100000};
                ArrayList<Integer> r = bitPatternMatch(d, 14, p, 3);
                for (int i=0; i<r.size(); i++) { 
                    System.out.print(r.get(i));
                    System.out.print(" ");
                }
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    /** bit manipulation, return all indices of matched pattern, kmp?
      * 
      * @param d byte[] of data
      * @param ld length of data, ignore the extra ones
      * @param p byte[] of pattern 
      * @param lp lenght of pattern
      * @return int[] of indices that matches the pattern 
      * @see 
      *
    */
    public static ArrayList<Integer> bitPatternMatch(byte[] d, int ld, byte[] p, int lp) {
        if (d == null || p == null) return null;
        int i = 0, j = 0;
        ArrayList<Integer> r = new ArrayList<Integer>();
        while (i<=ld) {
            i++;
            continue;
        }
        return r;
    }
}
