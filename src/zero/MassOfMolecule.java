package zero;

import java.util.Scanner;
import java.util.Stack;

public class MassOfMolecule {

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine().trim();

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            char chr = str.charAt(i);
            if(chr==')'){
                int no =0 ;
               while(!stack.isEmpty() && stack.peek()!=-1){
                   no += stack.pop();
               }
               stack.pop();
               stack.push(no);
            }else if(chr == '('){
                stack.push(-1);
            }else if(Character.isDigit(chr)) {
                int no = stack.pop();
                stack.push(no*Character.getNumericValue(chr));
            }
            else{
                int k =0;
                if(chr == 'H'){
                    k=1;
                }else if(chr=='C'){
                    k=12;
                }else{
                    k=16;
                }
               stack.push(k);
            }
        }
int mass=0;
        while(!stack.isEmpty()){
           mass+=stack.pop();
        }
        System.out.println(mass);

    }

}
