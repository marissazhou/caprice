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

public class Sort{

    public static void main(String[] args) {
        try {
            if (args.length>0){
                int[] A = new int[]{1,2,0,1,2,0,1,2,0,2,2,1,2,0,2,1,1,1,0};
                sort3Colors(A);
                for (int i=0; i<A.length; i++) { 
                    System.out.print(A[i]);
                    System.out.print(" ");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    /** Sort three colors, IOException
      * 
      * @param s the string to decode like '1235478' 
      * @return how many ways to decode the string
      * @see 
      *
    */
    public static void sort3Colors(int[] A) {
        if (A == null || A.length <= 1) return;
        int l = 0, r = A.length-1, i = l+1;
        while (i<=r) {
            if (A[i] == 0){
                swap(A, i++, l++);
            } else if (A[i] == 2) {
                swap(A, i, r--);
            } else i++;
        }
    }
    public static void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}