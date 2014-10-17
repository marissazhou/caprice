/* Created by   :   Lijuan Marissa Zhou
   Email        :   marissa.lala.joo@gmail.com 
   Time         :   1/10/2014
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Stack;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;

public class Array{
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public enum State {
        Unvisited, Visited, Visiting;
    }


    public static void main(String[] args) {
        try {
            if (args.length>0){
                System.out.println();
                if (isSubset(new int[]{10,9,1,2,3,4}, new int[]{2,11}))
                    System.out.println("yes");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    /*
       search in a sorted array with duplicates
       return the first occurance index
       Test:
                int[] nums = new int[]{1,2,3,4,5,6,7,7,7,8,8,8,9,9,12,13};
                int target = 16;
                int idx = searchInSortedArrayDup(nums, target); 
                for (int i : nums) System.out.print(i);
                System.out.println();
                System.out.println(idx);
       */
    public static int searchInSortedArrayDup(int[] nums, int target) throws IOException{
        if (nums == null || nums.length == 0) return -1;
        return bstSearch(nums, target, 0, nums.length-1);
    }
    public static int bstSearch(int[] nums, int target, int s, int e) {
        if (s>e) return -1;
        int m = s + (e-s)/2;
        if (nums[m] == target) {
            while (m>0 && nums[m-1] == target) m--;
            return m;
        } else if (nums[m] >= target) {
            return bstSearch(nums, target, s, m-1);
        } else {
            return bstSearch(nums, target, m+1, e);
        }
    }
    /**  
      * 
      * @param arrs ArrayList of arrays to merge
      * @return sorted array 
      * @see 
      *
    */
    public static void merge2SortedArray(
            int A[], int m, int B[], int n) {
        int index = m+n;
        while (m>0 && n>0) {
            if (A[m-1] > B[n-1]) 
                A[--index] = A[--m];
            else
                A[--index] = B[--n];
        }
        while (n>0) 
            A[--index] = B[--n];
    }
    /**  
      * 
      * @param arrs ArrayList of arrays to merge
      * @return sorted array 
      * @see 
      *
    */
    public static ListNode mergeKLists(
            ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;

        //Comparator for PriorityQueue
        Comparator<ListNode> comparator = new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b) {
                if (a.val > b.val) return 1;
                else if (a.val < b.val) return -1;
                else return 0;
            }
        };
        //PriorityQueue is a sorted queue
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(
                lists.size(),
                comparator);
        for (ListNode l : lists) {
            if (l != null) q.add(l);
        }

        ListNode head = new ListNode(0);
        ListNode prev = head;
        
        while(q.size() > 0) {
            ListNode tmp = q.poll();
            prev.next = tmp;
            prev = prev.next;

            if (tmp.next != null) q.add(tmp.next);
        }
        return head.next;
    }

    /** merge 3 sorted arrays, without any duplicates 
      * 
      * @param arrs ArrayList of arrays to merge
      * @return sorted array 
      * @see 
      *
    */
    public char[] merge3Arrays(char[] a1, char[] a2, char[] a3){
        char[] cs = new char[a1.length];
        int SIZE = a1.length + a2.length + a3.length;
        if (a1 == null || a2 == null || a3 == null) return cs;
        boolean[] f = new boolean[256]; //ascii table character， char is 16 bits 2^16
        for (char c : a1){f[c] = true;}
        for (char c : a2){f[c] = true;}
        for (char c : a3){f[c] = true;}
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<SIZE;i++) {if(f[i]) sb.append((char)i);}
        return sb.toString().toCharArray();
    }

    /**  if one array is a subset of another
         There is possibly duplicates
         Complexity: O(mLogm + nLogn)
      * 
      * @param a1 the first array
      * @param a2 the second array
      * @return true if a2 is subset of a1
      * @see 
      *
    */
    public static boolean isSubset(int[] a1, int[] a2){
        if (a1 == null && a2 == null) return true;
        if (a1 == null) return false;
        if (a2 == null || a2.length == 0) return true;
        int m = a1.length;
        int n = a2.length;
        if (m<n) return false;
        int i=0, j=0;
        // sort
        Sort sort = new Sort();
        sort.quickSort(a1, 0, m-1);
        sort.quickSort(a2, 0, n-1);
        // merge
        while (i<m && j<n) {
            if (a1[i] < a2[j]) i++;
            else if (a1[i] == a2[j]){
                i++;
                j++;
            } else {
                return false;
            }
        }
        if (i<m)
            return true;
        else
            return false;
    }

    /**  print array
      * 
      * @param a the array to print
      * @return 
      * @see 
      *
    */
    public static void printArray(int[] a){
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
