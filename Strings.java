/* Created by   :   Lijuan Marissa Zhou
   Email        :   marissa.lala.joo@gmail.com 
   Time         :   1/10/2014
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Stack;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.EmptyStackException;

public class Strings{

    public static void main(String[] args) {
        try {
            if (args.length>0){
                String[] SET_VALUES = new String[]{"hot","dot","dog","lot","log"};
                int d = editDistanceRecursive(args[0],0,args[1],0);
                /*
                for (int j : s) {
                    System.out.print(j);
                    System.out.print("");
                }
                */
                System.out.println(d);
                d = LevenshteinDistance(args[0],args[0].length(),args[1],args[1].length());
                System.out.println(d);

            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void removeDuplicates(String s){
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

    public static boolean isAnagram(String sa, String sb){
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

    public static String sortString(String s) {
        char[] data = s.toCharArray();
        mergeSort(data, 0, data.length-1);
        return String.valueOf(data);
    }
    public static void mergeSort(char[] s, int low, int high){
        if (s == null || s.length < 2) return;
        if (low >= high) return;
        int middle = low + (high - low) / 2;
        mergeSort(s, low, middle);
        mergeSort(s, middle+1, high);
        merge(s, low, middle, high);
    }
    public static void merge(char[] s, int low, int middle, int high){
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
    
    /** Retrieve words from a dictionary that are made up of a subsequence of characters in an input string, given an input "ABAT", matching words may include "BAT", "TAB", non-matching words may be "BART" or "BAR".
      * 
      * @param s the string  
      * @return List of all anagrams
      * @see 
      *
    */
    public static List<String> retrieveDictWords(HashMap<String, Integer> dict, 
            String input) {
        return null;
    }

    /** KMP 
      * 
      * @param s the string  
      * @return List of all anagrams
      * @see 
      *
    */
    public static String strStr(String haystack, String needle) { 
        int lenh = haystack.length();
        int lenn = needle.length();
        if(lenn>lenh) return null;
        if(lenn==0) return haystack;

        int[] overlay = getOverlay(needle);
        int i=0;
        while (i <= lenh-lenn) {
            int success = 1;
            for (int j=0; j<lenn; j++) {
                if (needle.charAt(0) != haystack.charAt(i)) {
                    success = 0;
                    i++;
                    break;
                } else if(needle.charAt(j) != haystack.charAt(i+j)) {
                    success = 0;
                    i = i+j-overlay[j-1];
                    break;
                }
            }
            if (success == 1)
                return haystack.substring(i);
        }
        return null;
    }

    public static int[] getOverlay(String needle) {
        int[] overlay = new int[needle.length()];
        overlay[0] = 0;
        for (int i=1; i<needle.length(); i++) {
            int index = overlay[i-1];
            while(index>0 && needle.charAt(index) != needle.charAt(i)) {
                index = overlay[index-1];
            }
            if (needle.charAt(index) == needle.charAt(i)) {
                overlay[i] = overlay[i-1] + 1;
            } else {
                overlay[i] = 0;
            }
        }
        return overlay;
    }

    /** Word Ladder, Given two words (start and end), 
        and a dictionary, find the length of shortest 
        transformation sequence from start to end 
        Use Breath First Search approach
      * 
      * @param start String of Start 
      * @param end String of End 
      * @param dict the dictionary HashSet<String>
      * @return List of all anagrams
      * @see 
      *
    */
    public static int wordLadder(String start, 
            String end, 
            HashSet<String> dict) { 
        System.out.println(dict.size());
        System.out.println(start);
        System.out.println(end);
        if (start == null || end == null || dict.size() == 0) return 0;

        LinkedList<String> wq = new LinkedList<String>(); 
        LinkedList<Integer> wc = new LinkedList<Integer>(); 
        wq.add(start);
        wc.add(1);

        while(!wq.isEmpty()) {
            String cw = wq.pop();
            int cc = wc.pop();

            if (cw.equals(end)) return cc;
            System.out.println(wq);

            for (int i=0; i<cw.length(); i++) {
                char[] cs = cw.toCharArray();
                for (char a = 'a'; a<='z'; a++){
                    cs[i] = a;
                    String nstart = new String(cs);
                    if (dict.contains(nstart)) {
                        wq.add(nstart);
                        wc.add(cc+1);
                        dict.remove(nstart);
                    }
                }
            }
        }
        return 0;
    }

    /** Word Ladder
        Use Adjacency List
      * 
      * @param start String of Start 
      * @param end String of End 
      * @param dict the dictionary HashSet<String>
      * @return List of all anagrams
      * @see 
      *
    */
    public static int wordLadderGraph(String start, 
            String end, 
            HashSet<String> dict) { 
        return 0;
    }


    /** LadderNode class for WordLadder II
      * 
    */
    public static class LadderNode {
        public int dist;
        public String str;
        public LinkedList<LadderNode> prev; 

        public LadderNode(int dist, String str) { 
            this.dist = dist;
            this.str = str;
            this.prev = new LinkedList<LadderNode>();
        }

        public void addPrev(LadderNode pNode) {
            prev.add(pNode);
        }
    }

    /** Word Ladder II, Given two words (start and end), 
        Given two words (start and end), and a dictionary,
        find all shortest transformation sequence(s) from 
        start to end, such that:
        Use Breath First Search approach
      * 
      * @param start String of Start 
      * @param end String of End 
      * @param dict the dictionary HashSet<String>
      * @return List of all anagrams
      * @see 
      *
    */
    public static ArrayList<ArrayList<String>> findLadders(String start, 
            String end,
            HashSet<String> dict) { 
        dict.add(end);
        Map<String, LadderNode> map = new HashMap<String, LadderNode>(); 
        Queue<String> queue = new LinkedList<String>(); 
        LadderNode startNode = new LadderNode(1, start);
        queue.offer(start);
        map.put(start, startNode);

        ArrayList<ArrayList<String>> ret = 
            new ArrayList<ArrayList<String>>();

        while (!queue.isEmpty()) {
            String str = queue.poll();
            // find a path
            if (str.equals(end)) {
                getPaths(map.get(end), map, new ArrayList<String>(), ret);
                return ret;
            }
            // keep searching 
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < 26; j++) { 
                    String newStr = replace(str, i, (char) ('a' + j));

                    // if new word is in the dict
                    if (dict.contains(newStr)) {
                        if (!map.containsKey(newStr)) {
                            LadderNode node = map.get(str); 
                            LadderNode newNode = 
                                new LadderNode(node.dist + 1, newStr);
                            newNode.prev = new LinkedList<LadderNode>();
                            newNode.prev.add(node);
                            map.put(newStr, newNode);
                            queue.offer(newStr);
                        } else {
                            LadderNode node = map.get(newStr);
                            LadderNode prevNode = map.get(str);
                            if (node.dist == prevNode.dist + 1) {
                                node.addPrev(prevNode); 
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }

    /** replace the index of the given string with the given char
      * 
      * @param end end node
      * @param map map of nodes 
      * @param curPath current path  
      * @param path all paths 
      * @return List of all anagrams
      * @see 
      *
    */
    public static String replace(String str, int i, char c){
        StringBuffer sb = new StringBuffer(str);
        sb.setCharAt(i, c);
        return sb.toString();
    }

    /** get all the paths by using DFS
      * 
      * @param end end node
      * @param map map of nodes 
      * @param curPath current path  
      * @param path all paths 
      * @return List of all anagrams
      * @see 
      *
    */
    public static void getPaths(LadderNode end, Map<String, LadderNode> map,
            ArrayList<String> curPath, ArrayList<ArrayList<String>> paths){
        if (end == null) {
            paths.add(curPath);
            return;
        }
        curPath.add(0, end.str);
        if (!end.prev.isEmpty()) {
            for (LadderNode prevNode : end.prev) {
                getPaths(prevNode, map,
                        new ArrayList<String>(curPath), paths);
            }
        } else {
            getPaths(null, map, curPath, paths);
        }
    }

    /** Edit Distance or called Levenshtein Distance 
      * Can be recursive or iterative or dp
      * 
      * @param s1 String 1
      * @param s2 String 2
      * @return all sum combination
      * @see 
      *
      */
    public static int editDistanceRecursive(
            String s1, int start1, String s2, int start2) {
        if (s1 == null && s2 == null) return 0;
        if (s1 == null || s1.length() == start1) return s2.length();
        if (s2 == null || s2.length() == start2) return s1.length();

        int cost = 0;
        if (s1.charAt(start1) != s2.charAt(start2))
            cost = 1;
        return Math.min(editDistanceRecursive(s1, start1+1, s2, start2+1)+cost,
                Math.min(editDistanceRecursive(s1, start1+1, s2, start2),
                    editDistanceRecursive(s1, start1, s2, start2+1))+1);
    }

    /** if two strings differ by one character
      * 
      * @param s1 String 1
      * @param s2 String 2
      * @return all sum combination
      * @see 
      *
      */
    public static int ifDifferByOneChar(String s1, String s2) {
        return 0;
    }

    /** Palindromes possible from a string without extra space
      * 
      * @param s1 String 1
      * @param s2 String 2
      * @return all sum combination
      * @see 
      *
      */
    public static int palindrome(String s1) {
        return 0;
    }
// len_s and len_t are the number of characters in string s and t respectively
static int LevenshteinDistance(String s, int len_s, String t, int len_t)
{
  /* base case: empty strings */
  if (len_s == 0) return len_t;
  if (len_t == 0) return len_s;
 
  /* test if last characters of the strings match */
  int cost;
  if (s.charAt(len_s-1) == t.charAt(len_t-1))
      cost = 0;
  else
      cost = 1;
 
  /* return minimum of delete char from s, delete char from t, and delete char from both */
  return Math.min(Math.min(LevenshteinDistance(s, len_s - 1, t, len_t    ) + 1,
                 LevenshteinDistance(s, len_s    , t, len_t - 1) + 1),
                 LevenshteinDistance(s, len_s - 1, t, len_t - 1) + cost);
}
}
