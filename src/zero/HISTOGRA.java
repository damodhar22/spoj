package zero;

import java.util.Scanner;
import java.util.Stack;

public class HISTOGRA {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        while(true){
            String str = s.nextLine().trim();
            String[] str2 = str.split(" ");
            int a[]=new int[str2.length];
            if(Integer.parseInt(str2[0])==0){
                break;
            }else{
                for(int i=0;i<str2.length;i++){
                    a[i] = Integer.parseInt(str2[i]);
                }
                Long area = 0l;
                Stack<Integer> stack = new Stack<>();
                for(int i=0;i<a.length;i++){
                    if(stack.isEmpty()){
                        stack.push(i);
                    }else{
                        int index = stack.peek();
                        if(a[i]>=a[index]){
                            stack.push(i);
                        }else{
                            while(a[i]<a[index]){
                                int top = stack.pop();
                                if(stack.isEmpty()){
                                    area = Math.max(area,a[top]*i);
                                    break;
                                }else{
                                    index = stack.peek();
                                    area = Math.max(area,a[top]*(i-top));
                                }
                            }
                            stack.push(i);
                        }
                    }
                }
                int i = 1 ;
                while(!stack.isEmpty()){
                    int index = stack.pop();
                    area = Math.max(area,a[index]*i);
                    i++;
                }
                System.out.println(area);
            }
        }
    }
}
