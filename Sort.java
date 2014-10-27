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

public class Sort{

    public static void main(String[] args) {
        try {
            if (args.length>0){
                int[] A = new int[]{1,2,0,1,2,0,1,2,0,2,2,1,2,0,2,1,1,1,0};
                A = bucketSort(A);
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

    /** Sort three colors, IOException
      * 
      * @param s the string to decode like '1235478' 
      * @return how many ways to decode the string
      * @see 
      *
    */
    public static void sort3Colors(int[] A) {
        if (A == null || A.length <= 1) return;
        int l = 0, r = A.length-1, i = l+1;
        while (i<=r) {
            if (A[i] == 0){
                swap(A, i++, l++);
            } else if (A[i] == 2) {
                swap(A, i, r--);
            } else i++;
        }
    }
    public static void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    /** HeapSort, the parent of i is (i-1)/2, two childrn are 2i+1 and 2i+2 
      * 
      * @param s the string to decode like '1235478' 
      * @return how many ways to decode the string
      * @see 
      *
    */
    public static void minHeapAddNumber(int[] a, int n, int nNum) {
        a[n] = nNum;
        minHeapFixup(a, n);
    }
    public static void minHeapFixup(int[] a, int i) {
        for (int j=(i-1)/2; (j>=0&&i!=0) && a[i]>a[j]; i=j, j=(i-1)/2)
            swap(a, i, j);
    }
    public static void minHeapDeleteNumber(int[] a, int n) {
        swap(a, 0, n-1);
        minHeapFixdown(a, 0, n-1);
    }
    public static void minHeapFixdown(int[] a, int i, int j) {
    }

    /** QuickSort
      * 
      * @param a the array to be sorted 
      * @param start start index
      * @param end end index
      * @return the sorted array
      * @see 
      *
    */
    public static void quickSort(int[] a, int start, int end) {
        if (a == null || a.length == 0 || end <= start) return;

        int mid = start + (end-start)/2;
        int pivot = a[mid];
        int i=start, j=end;
        while (i<=j){
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;
            if (i<=j) { // has to be equal, otherwise endless loop
                swap(a, i, j);
                i++;
                j--;
            }
        }
        if (start < j)
            quickSort(a, start, j);
        if (end > i)
            quickSort(a, i, end);
    }

    /** Bucket Sort / Bin Sort / Counting Sort
      * 
      * @param a the array to be sorted 
      * @param start start index
      * @param end end index
      * @return the sorted array
      * @see 
      *
    */
    public static int[] bucketSort(int[] a) {
        int max = a[0];
        for (int n : a) {
            if (n>max)
                max = n;
        }
        int[] count = new int[max];
        int[] output = new int[a.length];
        System.out.println("max");
        System.out.println(max);
        for (int n : a) {
            System.out.println("n");
            System.out.println(n);
            count[n-1] += 1;
        }
        // calculate the starting index for each key
        int total = 0;
        for (int i=0; i<a.length; i++){
            int tmp = count[i];
            count[i] = total;
            total += tmp;
        }
        // copy back to output array, presering order of inputs with equal keys
        for (int i=0; i<a.length; i++){
            output[count[a[i]]] = a[i];
            count[a[i]] += 1;
        }
        return output;
    }
}
