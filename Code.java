/* Created by   :   Lijuan Marissa Zhou
   Email        :   marissa.lala.joo@gmail.com 
   Time         :   1/10/2014
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class Code{
    /**
     * Definition for singly-linked list.
     */
    public static void main(String[] args) {
        try {
            if (args.length>0){
                String a = "012";
                System.out.println(numDecodings(a));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    /*
     *  Number of Decoding String "12345"
     */
    public static int numDecodings(String s) throws IOException{
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] rst = new int[len+1];
        rst[0] = 0;
        rst[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i=2; i<=len; i++) {
            if (s.charAt(i-1) != '0')
                rst[i] = rst[i-1];
            int n = (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0');
            if ( 10 <= n && n <= 26)
                rst[i] += rst[i-2];
        }
        return rst[len];
    }
}
