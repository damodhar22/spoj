package zero;

import java.util.Scanner;
import java.util.Stack;

public class Longest_Regular_Bracket_Sequence {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int count = 0;
        int no = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(stack.isEmpty() || c == '('){
             stack.push(c);
            }else{
                if(stack.peek() != '('){
                    if(ans == count){
                        no++;
                    }else if(ans>count){

                    }else{
                        ans = count;
                        no = 1;
                    }
                    count = 0;
                }else{
                    stack.pop();
                    count +=2;
                }
            }
        }

        if(count > 0){
            if(ans == count){
                no++;
            }else if(ans>count){

            }else{
                ans = count;
                no = 1;
            }
        }
        if(ans == 0){
            System.out.println(ans+" "+1);
        }else{
            System.out.println(ans+" "+no);
        }

    }

}
