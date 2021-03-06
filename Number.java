/* Created by   :   Lijuan Marissa Zhou
   Email        :   marissa.lala.joo@gmail.com 
   Time         :   1/10/2014
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.math.BigInteger; 

public class Number{

    public static void main(String[] args) {
        try {
            if (args.length>0) {
                int[] a = new int[]{1,2,3,45,1,3,45,6,5};
                //System.out.println(sumTwoBinaries(args[0],args[1]));
                //Sort.quickSort(a, 0, a.length);
                int val = divideNoDivision(args[0], args[1]);
                /*
                for (int i : a) {
                    System.out.print(i);
                    System.out.print(" ");
                }
                */
                System.out.print(val);
                System.out.println();
            
                //System.out.println(getBit(Integer.valueOf(args[0])));
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

    /*
        * PRIME
    */
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

    /*
       find all the primes from 1 to n
    */
    public static boolean[] sieve(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        int m = Math.sqrt(n);
        for (int i=2; i<=m; i++) {
            if (prime[i])
                for (int k = i+i; k<=n; k += i)
                    prime[k] = false;
        }
        return prime;
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
        long h = x, l = 0;
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

    /**  division implementation without division
      * 
      * @param x dividend
      * @param y divisor
      * @return the division result
      * @see 
      *
      */
    public static int divideNoDivision(int dividend, int divisor) {
        int quotient = 1;
        int denom = divisor;
        int current = 1;
        int answer = 0;
        if (dividend == denom) return 1;
        if (dividend < denom) return 0;
        while(denom <= dividend){
            denom <<= 1;
            current <<= 1;
        }
        denom >>= 1;
        current >>= 1;

        while (current != 0) {
            if (dividend <= denom) {
                dividend -= denom;
                answer |= current;
            }
            denom >>= 1;
            current >>= 1;
        }
        return answer;
	}

    /**  division implementation without +, - or multiplication
      * 
      * @param x dividend
      * @param y divisor
      * @return the division result
      * @see 
      *
      */
    public static int divide(int x, int y) {
        int quotient = 1;
        if (x == y) return 1;
        if (x < y) return 0;
        do {
            y <<= 1;
            quotient <<= 1;
        } while (y <= x);
        if (x < y) {
            y >>= 1;
            quotient >>= 1;
        }
        quotient = add(quotient, divide(x - y, y));
        return quotient;
    }

    /** add implementation without +, - or multiplication
      * 
      * @param x 
      * @param y 
      * @return the division result
      * @see 
      *
      */
    public static int add(int x, int y) {
        do {
            x ^= y;
            y &= x ^ y;
            y <<= 1;
        } while (Math.abs(y) != 0);
        return x;
    }

    /** sustraction implementation without +, - or multiplication
      * 
      * @param x 
      * @param y 
      * @return the substract result
      * @see 
      *
      */
    public static int substract(int x, int y) {
        return 0;
    }

    /** multiplication implementation without +, - or multiplication
      * a*b = a*(x*2^0 + x*2^1....x*2^n),
      * 
      * @param a 
      * @param b 
      * @return the multiple result
      * @see 
      *
      */
    public static int multiply(int a, int b) {
        int i = 0;
        int sum = 0;
        while (b != 0) {
            if ((b & 1) != 0) { // b is an odd number, means bit there is 1
                sum += (a << i);
            }
            i++;
            b >>= 1;
        }
        return sum;
    }

    /** multiplication without casting
      * a*b = a*(x*2^0 + x*2^1....x*2^n),
      * 
      * @param a 
      * @param b 
      * @return the multiple result
      * @see 
      *
      */
    public static int multiply(String a, String b) {
        return string2Int(a) * string2Int(b);
    }
    public static int string2Int(String s) {
        if (s == null || s.length() == 0) return 0;
        int rst = 0;
        for (int i=0; i<s.length(); i++){
            rst = rst * 10 + (s.charAt(i)-'a');
        }
        return rst;
    }

    /** is two numbers with the same sign 
      * 
      * @param x 
      * @param y 
      * @return true/false
      * @see 
      *
      */
    public static boolean isSameSign(int x, int y) {
        return (x^y) >= 0;
    }

    /** switch if(x == a) x = b; if(x == b) x = a;
      * 
      * @param x 
      * @param y 
      * @return the switch result
      * @see 
      *
      */
    public static int switchValue(int x, int a, int b) {
        return a ^ b ^ x;
    }

    /** switch the value of ith and jth item in a 
      * 
      * @param a the array 
      * @param i index 
      * @param j index 
      * @return the switch result
      * @see 
      *
      */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[j]^arr[i];
        arr[i] = arr[i]^arr[j];
    }

    /** check if a number can be represented as a power of 2
      * 
      * @param n 
      * @return true/false
      * @see 
      *
      */
    public static boolean isPowerOf2(int n) {
        return (n & (n-1)) == 0;
    }

    /** is bit at index i 1, i starts from 1 not 0;
      * 
      * @param n 
      * @return true/false
      * @see 
      *
      */
    public static boolean getBit(int n, int i) {
        return (n & (1<<(i-1))) != 0;
    }

    /** Given a set of candidate numbers (C) and a target 
        number (T), find all unique combinations in C 
        where the candidate numbers sums to T.
      * 
      * @param n sorted array of numbers 
      * @return true/false
      * @see 
      *
      */
    public static List<List<Integer>> getCombinationSum(int[] n, int t) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>(); 
        if (n == null || n.length == 0) return rst;

        List<Integer> curList = new ArrayList<Integer>(); 
        getCombinationSumHelper(rst, curList, n, t, 0);
        return rst;
    }
    public static void getCombinationSumHelper(
            List<List<Integer>> rst, 
            List<Integer> curList, 
            int[] n, 
            int t, 
            int start) {
        if (t == 0) {
            rst.add(new ArrayList(curList));
            return;
        }
        int prev = -1; // if allow duplicates, delete this
        for (int i=start; i<=n.length; i++) {
            if (n[i] > t) break;
            // if allow duplicates, delete this
            if (prev != -1 && prev == n[i]) continue; 

            curList.add(n[i]);
            getCombinationSumHelper(rst, curList, n, t-n[i], i);
            curList.remove(curList.size());
            prev = n[i]; // if allow duplicates, delete this
        }
    }

    /**  Add two binary numbers (Input as a string)
      * 
      * @param n1 
      * @param n2
      * @return sum
      * @see 
      *
      */
    public static String sumTwoBinaries(String n1, String n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        int carry = 0;
        int sum = 0;
        int cur = 0;

        int i = n1.length()-1;
        int j = n2.length()-1;
        StringBuffer sb = new StringBuffer();
        while (i>=0 && j>=0) {
            if (n1.charAt(i) == '1' && n2.charAt(j) == '1') {
                sb.insert(0, carry);
                carry = 1;
            }
            else if (n1.charAt(i) == '0' && n2.charAt(j) == '1'
                    || n1.charAt(i) == '1' && n2.charAt(j) == '0') {
                cur = carry==1? 0 : 1;
                sb.insert(0, cur);
            }
            else {
                sb.insert(0, carry);
                carry = 0;
            }
            i--; j--;
        }
        while (i >= 0) {
            if (carry == 1) {
                cur = n1.charAt(i) == '1' ? 0 : 1;
                carry = n1.charAt(i) == '1' ? 1 : 0;
            }
            sb.insert(0, n1.charAt(i--));
        }
        while (j >= 0) {
            if (carry == 1) {
                cur = n2.charAt(j) == '1' ? 0 : 1;
                carry = n2.charAt(j) == '1' ? 1 : 0;
            }
            sb.insert(0, n2.charAt(j--));
        }
        if (carry == 1) 
            sb.insert(0, '1');
        return sb.toString(); 
    }

    /**  2 sum
      * 
      * @param numbers
      * @param target 
      * @return all sum combination
      * @see 
      *
      */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (int i=0; i<numbers.length; i++){
            map.put(numbers[i], i+1);
        }
        int[] rst = new int[2];
        for (int i=0; i<numbers.length; i++){
            int left = target - numbers[i];
            if (map.containsKey(left)) {
                int i1 = i + 1;
                int i2 = map.get(left);
                if (i1 == i2) continue;
                rst[0] = i1;
                rst[1] = i2;
                return rst;
            }
        }
        return null;
    }

    /**  3 sum
      * 
      * @param numbers
      * @param target 
      * @return all 3 sum 
      * @see 
      *
      */
    public static int[] threeSum(int[] numbers, int target) {
        return null;
    }

    /**  4 sum
      * 
      * @param numbers
      * @param target 
      * @return all four sum 
      * @see 
      *
      */
    public static int[] fourSum(int[] numbers, int target) {
        return null;
    }

    /**  reverse integer
      * 
      * @param n
      * @return n
      * @see 
      *
      */
    public static int[] reverseInteger(int n) {
        return null;
    }

    /** two time int array overtime
      * 
      * @param numbers
      * @param target 
      * @return all sum combination
      * @see 
      *
      */
    public static boolean isOverlap(int[] a1, int[] a2) {
        if (a1 == null || a1.length == 0
                || a2 == null || a2.length == 0) return false;
        Sort.quickSort(a1, 0, a1.length-1);
        Sort.quickSort(a2, 0, a2.length-1);
        return false;
    }

    /** Permutation, including next permutatin, Permutation Sequence, all permutation, all permutation with duplicates
      * Implement next permutation, which rearranges 
      * numbers into the lexicographically next greater 
      * permutation of numbers.
      * 
      * @param numbers
      * @param target 
      * @return all sum combination
      * @see 
      *
      */
    public static void nextPermutation(int[] num) {
        if (num == null || num.length == 0) return;

        int len = num.length;
        for (int i=len-2; i>=0; i--) { // i records turning point
            if (num[i+1] > num[i]) {
                // j records first larger num from the tail 
                // to the element before i+1
                int j = len-1;
                for (; j>i+1; j--) {
                    if (num[j] > num[i]) break;
                }
                swap(num, i, j);
                reverse(num, i+1, len-1);
                return;
            }
        }
        reverse(num, 0, len-1);
    }
    private void reverse(int[] num, int s, int e){
        for (int i=s, j=e; i<j; i++, j--)
            swap(num, i, j);
    }

    // Given n and k, return the kth permutation sequence.
    public static String permutationSequence(int n, int k) {
        if (n <= 0 || k <= 0) return "";
        boolean[] used = new boolean[n];
        k--;
        int factor = 1;
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        for (i=1; i<=n; i++){
            factor *= i;
            numberList.add(i);
        }
        for (int i=0; i<n; i++) {
            factor /= (n-i);
            int curIndex = k/factor;
            k %= factor;

            result += numberList.get(curIndex);
            numberList.remove(curIndex);
        }
        return result;
    }

    // Given a collection of numbers, return all possible permutations.
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) return result;

        Arrays.sort(num);
        List<Integer> cur = new ArrayList<Integer>();
        helper(num, result, cur);
        return result;
    }
    private void permuteHelper(int[] num, List<List<Integer>> rst, List<Integer> cur) {
        if (cur.size() == num.length) {
            rst.add(new ArrayList(cur));
            return;
        }
        for (int i=0; i<num.length(); i++) {
            if (cur.contians(num[i])) continue;
            cur.add(num[0]);
            permutateHelper(num, rst, cur);
            cur.remove(cur.size());
        }
    }

    // Given a collection of numbers that might contain duplicates, return all possible unique permutations.
    public static List<List<Integer>> permuteDuplicate(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) return result;

        Arrays.sort(num);
        List<Integer> cur = new ArrayList<Integer>();
        boolean[] checked = new boolean[num.length];
        Arrays.fill(checked, false);
        helper(num, checked, result, cur);
        return result;
    }
    private void permuteUniqueHelper(int[] num, boolean[] checked, List<List<Integer>> result, List<Integer> cur){
        if (cur.size() == num.length){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i=0; i<num.length; i++){
            //if (checked[i] || (i != 0 && num[i] == num[i - 1] && !checked[i - 1])) continue;
            if (checked[i] || (i != 0 && num[i] == num[i - 1]) && !checked[i - 1]) continue;
            cur.add(num[i]);
            checked[i] = true;
            helper(num, checked, result, cur);
            cur.remove(cur.size()-1);
            checked[i] = false;
        }
    }

    /*
     * GCD greatest common divisor 
     */

    /*
       Euclid's algorithm
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
    /*
     *Euclid's algorithm to find lowest common multiple
     */
    public static int lcm(int a, int b) {
        return b*a/GCD(a,b);
    }

    /*
     * Bases
     */
    public int toDecimal(int n, int b) {
        int result = 0;
        int multiplier = 1;

        while (n>0) {
            result      += n%10*multiplier;
            multiplier  *= b;
            n           /= 10;
        }
        return result;
    }
    public int fromDecimal(int n, int b) {
        int result = 0;
        int multiplier = 1;

        while (n>0) {
            result += n%b*multiplier;
            multiplier *= 10;
            n /= b;
        }
        return result;
    }
}
