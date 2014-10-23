/* Created by   :   Lijuan Marissa Zhou
   Email        :   marissa.lala.joo@gmail.com 
   Time         :   1/10/2014
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Stack;
import java.util.EmptyStackException;

public class Matrix{

    private static class TrieNode {
        TrieNode parent;
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;

        public TrieNode(TrieNode parent, char[] children, boolean isWord) {
            if (parent != null){ 
                int idx = 'a'-'a';
                this.parent.children[idx] = this;
            }
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length>0){
                System.out.println("----------------");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void setZeros(int[][] matrix) throws IOException{
        int[] row = new int[matrix.length];
        System.out.println("result".toString());
    }

    /** Search word in Matrix like boggle game
      * not unit tested yet
      * 
      * @param numbers
      * @param target 
      * @return all sum combination
      * @see 
      *
      */
    public static boolean searchWord(char[][] matrix, String w) {
        if (matrix == null || w == null || w.length() == 0) return false;

        boolean[][] checked = new boolean[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                checked[i][j] = false;
            }
        }
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                if (matrix[i][j] == w.charAt(0)) {
                    checked[i][j] = true; // find seed
                    searchWordHelper(matrix, checked, w, 1, i, j);
                }
            }
        }
        return checked[matrix.length-1][matrix.length-1];
    }

    private static boolean searchWordHelper(
            char[][] matrix, 
            boolean[][] checked, 
            String word,
            int idx,
            int i,
            int j){
        if (idx == word.length() ) return true;
        boolean left = false, right = false, down = false, up = false;
        if (j>0 && !checked[i][j-1]) {
            if (word.charAt(idx) == matrix[i][j-1]) 
                checked[i][j-1] = true;
                left = searchWordHelper(
                        matrix, 
                        checked, 
                        word, 
                        idx+1,
                        i,
                        j-1);
        }
        if (i>0 && !checked[i-1][j]) {
            if (word.charAt(idx) == matrix[i][j-1]) 
                checked[i-1][j] = true;
                up = searchWordHelper(
                        matrix, 
                        checked, 
                        word, 
                        idx+1,
                        i-1,
                        j);
        }
        if (i<matrix.length-1 && !checked[i+1][j]) {
            if (word.charAt(idx) == matrix[i+1][j]) 
                checked[i+1][j] = true;
                down = searchWordHelper(
                        matrix, 
                        checked, 
                        word, 
                        idx+1,
                        i+1,
                        j);
        }
        if (i<matrix.length-1 && !checked[i][j+1]) {
            if (word.charAt(idx) == matrix[i][j+1]) 
                checked[i][j+1] = true;
                right = searchWordHelper(
                        matrix, 
                        checked, 
                        word, 
                        idx+1,
                        i,
                        j+1);
        }
        return left || right || up || down;
    }

    /** Find how many cluster of 1s in a matrix
      * 
      * @param matrix
      * @return number of clusters
      * @see 
      *
      */
    public static int twoPass(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int c = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length, j++) {
                if (!isNeibourPainted(matrix, i, j))
                    c++;
            }
        }
        return c;
    }
    public static boolean isNeibourPainted(int[][] matrix, itn i, int j) {
        return false;
    }
}
