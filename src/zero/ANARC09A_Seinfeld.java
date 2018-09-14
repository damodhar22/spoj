package zero;

import java.util.Scanner;
import java.util.Stack;

public class ANARC09A_Seinfeld {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int T = 0;
        while (true) {
            T++;
            String str = s.nextLine().trim();
            if (str.charAt(0)=='-') {
                break;
            }else{
                Stack<Character> stack = new Stack<>();
                str.replace(" ","");
                for(int i=0;i<str.length();i++){
                    if(!stack.isEmpty() && stack.peek() == '{' && str.charAt(i) == '}'){
                        stack.pop();
                    }else{
                        stack.push(str.charAt(i));
                    }
                }
                int count = 0;
                while(!stack.isEmpty()){
                    char c1 = stack.pop();
                    char c2 = stack.pop();
                    if(c1 == c2){
                        count++;
                    }else{
                        count +=2;
                    }
                }
                System.out.println(T+". "+count);
            }
        }
    }

}
