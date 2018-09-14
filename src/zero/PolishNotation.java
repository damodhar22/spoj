package zero;

import java.util.Scanner;
import java.util.Stack;

public class PolishNotation {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int T = Integer.parseInt(str);
        while(T>0){
            T--;
            str = s.nextLine();
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<str.length();i++){
                char chr = str.charAt(i);
                if(chr == '+' || chr== '-' || chr== '*' || chr=='/' || chr=='^'|| chr=='(' || chr==')'){
                    if(stack.isEmpty() || chr == '('){
                        stack.push(chr);
                    }else if( chr == ')'){
                        while(!stack.isEmpty()) {
                            char c = stack.pop();
                            if (c == '(') {
                               break;
                            }
                            System.out.print(c);
                        }
                    }else{
                        char c = stack.peek();
                        if(c=='('){
                            stack.push(chr);
                        }else{
                            if(chr>c){
                           System.out.print(chr);
                            }else{
                                System.out.print(stack.pop());
                                stack.push(chr);
                            }
                        }
                    }
                }else{
                    System.out.print(chr);
                }
            }
            while(!stack.isEmpty()){
                System.out.print(stack.pop());
            }
            System.out.println("");
        }
    }
}
