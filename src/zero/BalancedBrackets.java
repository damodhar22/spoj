package zero;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();
        }

        scanner.close();
    }

    public static void matchBrackets(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '{' || charArray[i] == '[' || charArray[i] == '(') {
                stack.push(charArray[i]);
            } else if(!stack.isEmpty()){
                Character c = stack.peek();
                if (c == '{' && charArray[i] == '}' || c == '(' && charArray[i] == ')' || c == '[' && charArray[i] == ']') {
                    stack.pop();
                }else {
                    break;
                }
            }else{
                stack.push(charArray[i]);
                break;
            }
        }

        if(stack.isEmpty()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
