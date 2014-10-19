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
                /*
                byte[] d = new byte[]{(byte)10101001, (byte)01001100};
                byte[] p = new byte[]{(byte)10100000};
                ArrayList<Integer> r = bitPatternMatch(d, 14, p, 3);
                for (int i=0; i<r.size(); i++) { 
                    System.out.print(r.get(i));
                    System.out.print(" ");
                }
                */
                int i = numOfBits(Integer.valueOf(args[0]));
                System.out.println(i);
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

    /** get number of bits in a integer
      * 
      * @param n the number
      * @return int number of 1s in binary
      * @see 
      *
    */
    public static int numOfBits(int n){
        int rst = 0;
        while (n != 0){
            n = n & (n-1);
            rst++;
        }
        return rst; 
    }

    /** Reverse the ith lowest bit
      *
      * @param i the index 
      * @return reversed number
      * @see 
      *
    */
    public static int reverseOneBit(int x, int n){
        return x ^ (( 1 << n ) - 1);
    }

    /** Find the most significant bit of a number
      *
      * @param n the number
      * @return the most significant bit of a number
      * @see 
      *
    */
    public static int findIndexOfMostSignificantBit(int n){
        int s = 0;
        while (n != 0) {
            s++;
            n >>= 1;
        }
        return s>0 ? s-1 : -1;
    }

    /** Setting and getting a bit at indext i
      *
      * @param n the number
      * @param i the index
      * @return the new number
      * @see 
      *
    */
    public static int setBit(int n, int i){
        n = n | (1<<i);
        return n;
    }
    public static int getBit(int n, int i){
        if ((n & (1<<i))!=0) return 1;
        return 0;
    }

    /** Clearing the bits between index i and j
      *
      * @param n the number
      * @param i the start index
      * @param j the end index
      * @return the new number
      * @see 
      *
    */
    public static int clearBits(int n, int i, int j){
        int left = (~0) << (i+1);
        int right = (1<<j) - 1;
        return n&(left | right);
    }
}
