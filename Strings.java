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

public class Strings{

    public static void main(String[] args) {
        try {
            if (args.length>0){
                ArrayList<String> s = getSingleQuoteString("233242'fwerihfwhiw'fwhiewhi'fshi'fs");
                for (int i=0; i<s.size(); i++) {
                    System.out.println(s.get(i));
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void removeDuplicates(String s) throws IOException{
        StringBuffer result = new StringBuffer();
        if (s == null) return;
        int len = s.length();
        if (len < 2) return;
        boolean hit[] = new boolean[256];
        for (int i=0; i<len; i++){
            hit[i] = false;
        }
        hit[(int)s.charAt(0)] = true;
        result.append(s.charAt(0));
        int tail = 1;
        for (int i=1; i<len; i++){
            if (!hit[(int)s.charAt(i)]) {
                result.append(s.charAt(i));
                tail++;
                hit[s.charAt(i)] = true;
            }
        }
        System.out.println(result.toString());
    }

    public static boolean isAnagram(String sa, String sb) throws IOException{
        if (sa == null || sb == null) return false;
        String s1 = sortString(sa);
        String s2 = sortString(sb);
        boolean rst = s1.equals(s2);
        if (rst) {
            System.out.println("Yes");
            System.out.println(s1);
            System.out.println(s2);
        } else {
            System.out.println("No");
            System.out.println(s1);
            System.out.println(s2);
        }
        return (sortString(sa).equals(sortString(sb)));
    }

    public static String sortString(String s) throws IOException{
        char[] data = s.toCharArray();
        mergeSort(data, 0, data.length-1);
        return String.valueOf(data);
    }
    public static void mergeSort(char[] s, int low, int high) throws IOException{
        if (s == null || s.length < 2) return;
        if (low >= high) return;
        int middle = low + (high - low) / 2;
        mergeSort(s, low, middle);
        mergeSort(s, middle+1, high);
        merge(s, low, middle, high);
    }
    public static void merge(char[] s, int low, int middle, int high) throws IOException{
        char[] temp = new char[s.length];   
        for (int i=low; i<=high; i++){
           temp[i] = s[i]; 
        }   

        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (s[i] <= s[j]) {
                s[k] = temp[i++];
            } else {
                s[k] = temp[j++];
            }
            k++;
        }
        while (i <= middle) {
            s[k++] = temp[i++];
        }
    }
    
    /*
       Given two strings, s1 and s2, write code to check if s2 is a rotation of s1
       */
    public static boolean isRotation(String s1, String s2) throws IOException{
        int len = s1.length();
        if (len == s1.length() && len > 0) {
            String temp = s1 + s1;
            if (temp.indexOf(s2) != -1) return true;
        }
        return false;
    }
    public static void isValidUTF8(String s) {
        byte[] bytes = null;
    }


    public static void printStringCar(int num){
        if (num < 1) return;
        ArrayList<Integer> idies = new ArrayList<Integer>();
        while (num>0) {
            int c=1;
            while((num>>c) > 0) c++;
            idies.add(c);
            num -= num>>(c-1);
        }
        System.out.print("");
        int sign = 1;
        for (int i=0; i<idies.size(); i++) {
            if (i%2 != 0)
                System.out.print('r');
            System.out.print('a');
        }
    }

    public static String reverseStr(String s) throws IOException{
        if (s == null || s.length() == 0) return "";
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        for (int i=len-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static LinkedList reverseStr(LinkedList l) throws IOException{
        LinkedList newl = new LinkedList();
        if (l == null || l.size() == 0) return newl;
        Iterator ir = l.listIterator(0);
        while (ir.hasNext()) {
            newl.add(0,ir.next());
        }
        return newl;
    }

    /** regular expression matching with support for '.' and '*'.
      * isMatch("ab", ".*") → true 
      * 
      * @param s the string  
      * @param p the pattern
      * @return the image at the specified URL
      * @see 
      *
    */
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        if (p.length() == 0) return s.length() == 0;
        if (p.length() == 1 || p.charAt(1) != '*') {
            if(s.length()<1 || 
                (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0)))
                return false;
            return isMatch(s.substring(1), p.substring(1));
        } else {
            int i = -1;
            while(i<s.length() && 
                    (i<0 || p.charAt(0)=='.' || p.charAt(0)==s.charAt(i))){
                if (isMatch(s.substring(i+1), p.substring(2))) return true;
                i++;
            }
            return false;
        }
    }
    /** reverse words in a String 
      * 
      * @param s the string  
      * @return the image at the specified URL
      * @see 
      *
    */
    public static String reverseWords(String s) throws IOException{
        if (s == null || s.length() == 0) return s;
        StringBuffer sb = new StringBuffer();
        String[] ss = s.split(" ");
        int len = ss.length;
        for(int i = len-1; i>=0; i--) {
            if (!ss[i].equals("")) {
                sb.append(ss[i]);
                sb.append(' ');
            }
        }
        return sb.toString().trim();
    }
 
    /** store strings in single quote
      * 
      * @param s the string  
      * @return ArrayList of quoted wraped String
      * @see 
      *
    */
    public static ArrayList<String> getSingleQuoteString(String s) throws IOException{
        System.out.println(s);
        ArrayList<String> rst = new ArrayList<String>();
        if (s == null || s.length() == 0) return rst;
        String[] ss = s.split("\'");
        for (int i=1; i<ss.length-1; i++) {
            if (i%2 != 0)
                rst.add(ss[i]);
        }
        return rst;
    }
    /** Anagrams; Given an array of strings, return all groups of strings that are anagrams.
      * 
      * @param s the string  
      * @return List of all anagrams
      * @see 
      *
    */
    public static List<String> anagrams(String[] strs) throws IOException{
        List<String> rst = new ArrayList<String>();
        if (strs == null || strs.length == 0) return null;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>(); 
        for (int i=0; i<strs.length; i++){
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String tmp = new String(charArr);
            if (map.containsKey(tmp)) 
                map.get(tmp).add(strs[i]);
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(tmp, list);
            }
        }
        Iterator ir = map.values().iterator();
        while(ir.hasNext()) {
            ArrayList<String> item = (ArrayList<String>)ir.next();
            if (item.size() > 1)
                rst.addAll(item);
        }
        return rst;
    }
}
