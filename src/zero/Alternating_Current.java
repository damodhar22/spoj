package zero;

import java.util.Scanner;
import java.util.Stack;

public class Alternating_Current {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            char chr = s.charAt(i);
            if(stack.isEmpty() || chr != stack.peek()){
                stack.push(chr);
            }else{
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
