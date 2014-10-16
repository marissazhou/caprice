/* Created by   :   Lijuan Marissa Zhou
   Email        :   marissa.lala.joo@gmail.com 
   Time         :   1/10/2014
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack; import java.util.HashMap;
import java.util.EmptyStackException;
import java.util.LinkedList;

import java.math.BigInteger; 

public class Number{

    public static void main(String[] args) {
        try {
            if (args.length>0) {
                System.out.println(fibonacciA(Integer.valueOf(args[0])));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void removeDuplicates(int[] nums) throws IOException{

    }

    public static int findMedian(int[] nums) {
        // similar to quick sort
        return 0;
    }
    public static void printPrime(int n) throws IOException {
        HashMap<Integer,Boolean> primes = new HashMap<Integer,Boolean>();
        primes.put(2, true);
        boolean mark = true;
        for (int i = 3; i <= n; i+=2){
            mark = true;
            //for (int j = 2; j <= Math.sqrt(i); j++){
            for (int j : primes.keySet() ){
                if (i%j == 0) {
                    mark = false;
                    break;
                }
            }
            if (mark) {
                primes.put(i, true);
                System.out.println(i+" ");
            }
        }
    }
    public static void getMaxResult(long n) {
        /*
        long[] dp = new long[n+1];
        for (long i=1; i<=n; i++) {
            long max = i;
            for ( long j=1; j<=(i>>1); j++){
                long prd = j*dp[long(i-j)]; 
                if (prd > max) max = prd;
            }
        }
        System.out.println("" + dp[long(n)]);
        //return dp[n];
        */
    }
    // http://www.meetqun.com/thread-920-1-1.html
    // moving average
    public static double movingAverage(int curNum) {
        return 0;
    }
    public static double dynamicMean(int curNum) {
        return 0;
    }
    public static BigInteger factorial(int n) throws IOException{
        BigInteger result = new BigInteger("1");
        if (n<0) return new BigInteger("-1");
        else if (n==0) return new BigInteger("1");
        else {
            for (int i=1; i<=n; i++) {
                result = result.multiply(new BigInteger(String.valueOf(i)));
            }
            return result;
        }
    }
    /** get int value of sqrt x
      * 
      * @param x int value
      * @return sqrt of x 
      * @see 
      *
      */
    public static int sqrt(int x) {
        if (x<=0) return 0;
        long h = 0, l = 0;
        while(h>=l) {
            long mid = l+(h-l)/2;
            if(x < mid*mid) h = mid - 1;
            else l = mid + 1;
        }
        return (int)h;
    }
    /**  get the n-th Fibonacci number, recursively
      * 
      * @param x int value
      * @return sqrt of x 
      * @see 
      *
      */
    public static long fibonacci(int n) {
        if (n <= 0) return 0;
        return n <= 2 ? 1 : fibonacci(n-1) + fibonacci(n-2);
    }
    /**  get the n-th Fibonacci number, analytically 
      * 
      * @param n int value
      * @return the nth fib
      * @see 
      *
      */
    public static long fibonacciA(int n) {
        double p = (1 + Math.sqrt(5)) /2;
        double q = 1 / p;
        return (long) (( Math.pow(p, n) + Math.pow(q, n)) / Math.sqrt(5));
    }
}
