/* Created by   :   Lijuan Marissa Zhou
   Email        :   marissa.lala.joo@gmail.com 
   Time         :   22/09/2014
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Stack;
import java.util.EmptyStackException;

public class Parenthesis{

    public static void main(String[] args) {
        try {
            if (args.length>0){
                readFile(args[0]);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void readFile(String s) throws IOException{
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(s));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                boolean isRight = isValid(line.trim());
                if (isRight){
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
                line = br.readLine();
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public static boolean isValid(String s) {
        if (s==null) return true;
        Stack<Character> stack = new Stack<Character>();
        Character cur = null;
        for(char c:s.toCharArray()){
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else if(c == ')'){
                if (stack.isEmpty()) return false;
                cur = stack.pop();
                if (cur != '(') return false;
            }
            else if(c == ']'){
                if (stack.isEmpty()) return false;
                cur = stack.pop();
                if (cur != '[') return false;
            }
            else if(c == '}'){
                if (stack.isEmpty()) return false;
                cur = stack.pop();
                if (cur != '{') return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
