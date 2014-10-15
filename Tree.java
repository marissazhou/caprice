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

public class Tree{

    public enum State {
        Unvisited, Visited, Visiting;
    }

    public static void main(String[] args) {
        try {
            if (args.length>0){
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void isBalanced(int[] nums) throws IOException{
        return (maxDepth(root)-minDepth(root) <= 1);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
    }
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.min(minDepth(root.left), minDepth(root.right)) +1;
    }

    public static boolean isConnected(Graph g, Node start, Node end) {
        Stack stack = new Stack();
        for (Node n : g) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.pop();
            if (u != null) {
                for (Node v : u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) return true;
                        else {
                            v.state == State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }

    /*
       Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height
       */
    public static TreeNode createMinimalBST(int arr[]) {
        addToTree(arr, 0, arr.length-1);
    }
    public static TreeNode addToTree(int arr[], int start, int end) {
        if (start > end) return null;
        int mid = (start + end) /2;
        TreeNode cur = new TreeNode(arr[mid]);
        cur.left = addToTree(arr, start, mid-1);
        cur.right = addToTree(arr, mid+1, end);
        return cur;
    }
    public static ArrayList<LinkedList<TreeNode>> generateLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        if (root == null) return result;
        LinkedList<TreeNode> curList = new LinkedList<TreeNode>();
        int level = 0;
        curList.add(root);
        result.add(level, curList);

        while (true) {
            curList = new LinkedList<TreeNode>();
            for (int i = 0; i < result.get(level).size(); i++ {
                TreeNode n = (TreeNode)result.get(level).get(i);
                if (n != null) {
                    if (n.left  != null) curList.add(n.left);
                    if (n.right != null) curList.add(n.right);
                }
            }
            if (list.size() > 0) result.add(level+1, curList)
            else break;
            level++;
        }
        return result;
    }

    /*
       Write an algorithm to find the ‘next’ node (e.g., in-order successor) of a given node in a binary search tree where each node has a link to its parent.
       1. X.left -> X -> X.right
       1. if X.right != null; return leftMostChild(X.right);
       2. go to X.parent,
       2.a if X.parent.left == X, return X.parent;
       2.b if X.parent.right== X, return succssor(X.parent);
        */
    public static TreeNode inorderSuccessor(TreeNode root) {
       if (root == null) return null;
       TreeNode p;
       if (root.parent == null || root.right != null) {
           p = root.leftMostChild(root.right);
       } else {
           while (( p = root.parent) != null){
               if (p.left == root) break;
               root = p;
           }
       }
       return p;
    }

    public static TreeNode leftMostChild( TreeNode root) {
        if (root == null) return null;
        while (root.left != null) root = root.left;
        return root;
    }

    /*
       Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
       */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (covers(root.left, p) && covers(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (covers(root.right, p) && covers(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
    public static boolean covers(TreeNode root, TreeNode n) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, n) || covers(root.right, n);
    }

    public static TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val){
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        if (p.val <= root.val && root.val <= q.val) return root;
        else if (p.val <= root.val && root.val >= q.val) {
            return lowestCommonAncestorBST(root.left, p, q);
        }
        else if (p.val >= root.val && root.val <= q.val) {
            return lowestCommonAncestorBST(root.right, p, q);
        }
        return null;
    }
    public static TreeNode arrayToBBST(int[] arr){
        if (arr == null || arr.length == 0) return null;
        return sortedArrayToBBST(arr, 0, arr.length);
    }
    public static TreeNode sortedArrayToBBST(int[] arr, int s, int e){
        if (s > e) return null;
        int m = s + (s-e);
        TreeNode root = new TreeNode(arr[m]);
        root.left   = sortedArrayToBBST(arr, s, m-1);
        root.right  = sortedArrayToBBST(arr, m+1, e);
        return root;
    }

    /** Judge a tree is a binary search tree or not 
      * 
      * @param r the root of the tree
      * @return true/false
      * @see 
      *
    */
    public static boolean isBST(TreeNode r) {
        return isBSTHelper(r, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static boolean isBSTHelper(TreeNode r, int max, int min) {
        if (r == null) return true;
        if (max >= r.val && r.val >= min) 
            return isBSTHelper(r.left, low, p.val) 
                && isBSTHelper(r.right, p.val, max);
        else return false;
    }
}
