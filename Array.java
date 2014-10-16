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

public class Array{

    public enum State {
        Unvisited, Visited, Visiting;
    }


    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static void main(String[] args) {
        try {
            if (args.length>0){
                int[] nums = new int[]{1,2,3,4,5,6,7,7,7,8,8,8,9,9,12,13};
                int target = 16;
                int idx = searchInSortedArrayDup(nums, target); 
                for (int i : nums) System.out.print(i);
                System.out.println();
                System.out.println(idx);
            }
        } catch (IOException e){
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
                list.size(),
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

            if (tmp.next() != null) q.add(tmp.next());
        }
        return head.next();
    }
}
