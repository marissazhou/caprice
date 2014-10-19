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

public class Grid{

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
                int i = getNoOfPathsUpRightDP(Integer.valueOf(args[0]),Integer.valueOf(args[0]));
                System.out.println(i);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    /** Given a m * n grids, and one is allowed to move up or right, find the number of paths between two grids.
      * Combination(m+n, m)
      * 
      * @param m rows
      * @param n colums
      * @return number of paths
      * @see 
      *
    */
    public static int getNoOfPathsUpRight(int m, int n){
        if (m == 1 || n == 1) return 1;
        int up = getNoOfPathsUpRight(m-1, n);
        int right = getNoOfPathsUpRight(m, n-1);
        return up + right; 
    }
    // dynamic programming
    public static int getNoOfPathsUpRightDP(int m, int n){
        int[][] count = new int[m][n];
        for (int i=0; i<m; i++) count[i][0] = 1;
        for (int i=0; i<n; i++) count[0][i] = 1;
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                count[i][j] = count[i-1][j] + count[i][j-1];
            }
        }
        return count[m-1][n-1];
    }
}
