/* Created by   :   Lijuan Marissa Zhou
   Email        :   marissa.lala.joo@gmail.com 
   Time         :   22/09/2014
   PS.          :   For char[] to store numbers instead of long to avoid size problem
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigInteger;


public class ReverseAndAdd{

    private static long MAX = Integer.MAX_VALUE; 

    public static void main(String[] args) {
        try {
            if (args.length>0){
                /*
                if (isPalindromeChars(new char[3])) System.out.println("yes");
                else System.out.println("no");
                char[] r = addTwoNumbers(new char[]{'9'}, new char[]{'1'});
                for (char c : r){
                    System.out.print(c);
                }
                System.out.println();
                char[] r = reverseChars(new char[]{'9','1','8'});
                for (char c : r){
                    System.out.print(c);
                }
                System.out.println();
                */
                processFile(args[0]);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    private static void printNums(ArrayList<Integer> nums){
        if (nums == null || nums.size() == 0) return;
        for (int i : nums){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void checkNumbers(ArrayList<Integer> nums){
        if (nums == null || nums.size() == 0) return;
        for (int i : nums){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    private static void processFile(String s) throws IOException{
        BufferedReader br = null;
        ArrayList<Integer> counts = new ArrayList<Integer>();

        try{
            br = new BufferedReader(new FileReader(s));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                int count = processLine(line);
                counts.add(count);
                line = br.readLine();
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }

        printNums(counts);
    }

    private static int processLine(String s) {
        if (s == null) return 0;
        s = s.trim();
        int count = 0;
        if (s.length()>0){
            char[] chars = s.toCharArray();
            if (isNumber(chars)){
                char[] rChars = reverseChars(chars); 
                while(count<1000 && !isPalindromeChars(chars)){
                    count++;
                    chars = addTwoNumbers(chars,reverseChars(chars));
                }
            }
        }
        return count;
    }

    private static boolean isPalindrome(long num) {
        long reverseNum = reverseNum(num);
        return num == reverseNum;
    }

    private static boolean isPalindromeChars(char[] chars) {
        boolean isP = true;
        for (int i=0; i<chars.length/2; i++){
            if (chars[i] != chars[chars.length-1-i]){
                isP = false;
                break;
            }
        }
        return isP;
    }

    private static boolean isNumber(char[] chars) {
        boolean isNum = true;
        for (char c : chars){
            if ('0' <= c && c <= '9') continue;
            else {
                isNum = false;
                break;
            }
        }
        return isNum;
    }

    private static char[] reverseChars(char[] chars){
        if (chars == null || chars.length <= 1) return chars;
        char[] newChars = new char[chars.length];
        for (int i=0; i<chars.length; i++){
            newChars[i] = chars[chars.length-1-i];
        }
        return newChars;
    }

    private static long reverseNum(long num){
        long r = 0;
        while (num != 0){
            long lDigit = num%10;
            r = r*10 + lDigit;
            num = num/10;
        }
        return r;
    }

    private static char[] addTwoNumbers(char[] chars1, char[] chars2) {
        if(chars1 == null && chars2 == null) {
            return null;
        }
            
        int carry = 0;
        int i = chars1.length-1;
        int j = chars2.length-1;
        int k = i>j ? i+2 : j+2;
        char[] result = new char[k];
        k = k-1;
        while(i>=0 && j>=0){
            int num1 = Character.getNumericValue(chars1[i]);
            int num2 = Character.getNumericValue(chars2[j]);
            int sum = carry + num1 + num2;
            result[k--] = Character.forDigit(sum % 10, 10);
            carry = sum / 10;
            i--;
            j--;
        }
        
        while(i >= 0) {
            int num = Character.getNumericValue(chars1[i]);
            int sum =  carry + num;
            result[k--] = Character.forDigit(sum % 10, 10);
            carry = sum / 10;
            i--;
        }

        while(j >= 0) {
            int num = Character.getNumericValue(chars2[j]);
            int sum =  carry + num;
            result[k--] = Character.forDigit(sum % 10, 10);
            j--;
        }
        
        if (carry != 0) {
            result[0] = Character.forDigit(carry, 10);
        } else {
            result = Arrays.copyOfRange(result, 1, result.length);
        }
        
        return result;
    }
}
