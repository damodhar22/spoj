package zero;

import java.util.Scanner;
import java.util.Stack;

public class Minimal_string {

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int[] alph = new int[26];
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            alph[c-'a']++;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<str.length()){
            char c = str.charAt(i);
            if(stack.isEmpty() || checkForSmall(stack.peek()-'a',alph)){
                stack.push(c);
                alph[c-'a']--;
                i++;
            }else{
               sb.append(stack.pop());
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }

    static boolean checkForSmall(int c,int[] a){
        for(int i=0;i<c;i++){
            if(a[i]>0){
                return true;
            }
        }
        return false;
    }
}
