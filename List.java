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

public class List{
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
    /**
     * Definition for doubly-linked list.
     */
    public class DoubleListNode {
        int val;
        DoubleListNode next;
        DoubleListNode prev;
        DoubleListNode (int x) {
            val = x;
            next = null;
            prev = null;
        }
     }

    /**
     * Definition for singly-linked list with a random pointer.
     */
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    public static void main(String[] args) {
        try {
            if (args.length>0){
                int[] A = new int[]{1,2,0,1,2,0,1,2,0,2,2,1,2,0,2,1,1,1,0};
                sort3Colors(A);
                for (int i=0; i<A.length; i++) { 
                    System.out.print(A[i]);
                    System.out.print(" ");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    /** Copy List with Random Pointer
      * 
      * @param head RandomListNode head
      * @return the head of the deeply copied list
      * @see 
      *
    */
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode nh = new RandomListNode(head.label);
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        HashMap<RandomListNode,RandomListNode> mapR = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode p = nh;
        mapR.put(head, head.random);
        map.put(head, nh);
        while (head.next != null) {
            RandomListNode nxt = new RandomListNode(head.next.label);
            p.next = nxt; 
            mapR.put(head.next, head.next.random);
            map.put(head.next, nxt);
            head = head.next;
            p = p.next;
        }
        for (RandomListNode cur : mapR.keySet()) {
            map.get(cur).random = map.get(mapR.get(cur));
        }
        return nh;
    }
    /** Copy List with Random Pointer
      * 
      * @param head RandomListNode head
      * @return the head of the deeply copied list
      * @see 
      *
    */
    public static LinkedList reverseDoublyLinkedList(RandomListNode head) {

    }
}
