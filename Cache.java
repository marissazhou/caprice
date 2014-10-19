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

public class Cache{

    public class Entry {
        Entry pre;
        Entry nxt;
        int key;
        int val;

        public Entry(int k, int v) {
            this.key = k;
            this.val = v;
            this.pre = null;
            this.nxt = null;
        }
    }
    private int capacity;
    private HashMap<Integer, Entry> hm = new HashMap<Integer, Entry>();
    private Entry head = new Entry(-1, -1);
    private Entry tail = new Entry(-1, -1);

    public Cache(int capacity) {
        this.capacity = capacity;
        head.nxt = tail;
        tail.pre = head;
    }

    /** Implement get
      * 
      * @param m rows
      * @param n colums
      * @return number of paths
      * @see 
      *
    */
   public int get(int key) {
        if (!hm.containsKey(key)){ return -1;}
        // mark and cut out current
        Entry cur = hm.get(key);
        cur.pre.nxt = cur.nxt;
        cur.nxt.pre = cur.pre;
        // move to tail
        moveToTail(cur);
        return cur.val;
    }

    /** Implement set
      * 
      * @param m rows
      * @param n colums
      * @return number of paths
      * @see 
      *
    */
    public void set(int key, int value) {
        // check whether it exists
        if (get(key) != -1) {hm.get(key).val = value; return;}
        // check whether exceed capacity
        if (hm.size() == capacity){
            // remove head and add new to tail
            hm.remove(head.nxt.key);
            this.head.nxt = this.head.nxt.nxt;
            this.head.nxt.pre = this.head;
        }
        Entry cur = new Entry(key, value);
        hm.put(key, cur);
        moveToTail(cur);
    }

    /** Implement move to tail 
      * 
      * @param m rows
      * @param n colums
      * @return number of paths
      * @see 
      *
    */
    public void moveToTail(Entry entry){
        entry.pre = this.tail.pre;
        this.tail.pre = entry;
        entry.pre.nxt = entry;
        entry.nxt = this.tail;
    }

    public static void main(String[] args) {
        try {
            if (args.length>0){
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }
}
