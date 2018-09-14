package zero;

import java.util.Scanner;
import java.util.Stack;

public class Maximum_Xor_Secondary {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int N = Integer.parseInt(str);
        str = s.nextLine().trim();
        String[] str2 = str.split(" ");
        int a[] = new int[N];
        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(str2[i]);
        }
        Stack<Integer> stack= new Stack<>();
        int ans = 0;
        for(int i=0;i<N;i++){
            while(!stack.isEmpty()){
                if(a[i] >= stack.peek()){
                    ans = Math.max(ans,(a[i]^stack.pop()));
                }else{
                    ans = Math.max(ans,(a[i]^stack.peek()));
                    break;
                }
            }
            stack.push(a[i]);
        }
        System.out.println(ans);
    }
}
