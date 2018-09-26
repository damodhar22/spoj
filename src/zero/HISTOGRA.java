package zero;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class HISTOGRA {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        FastIO fs = new FastIO();
        while(true){
            String str = s.nextLine().trim();
            String[] str2 = str.split(" ");
            long a[]=new long[str2.length];
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
                                    area = Math.max(area,a[top]*(i-index-1));
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

    static class FastIO
    {
        static BufferedInputStream in = new BufferedInputStream(System.in);
        static int readInt() {
            int no = 0;
            boolean minus = false;
            try {
                int a = in.read();
                while (a == 32 || a == 10) //10 is newline & 32 is ASCII for space
                    a = in.read();
                if (a == '-') {
                    minus = true;
                    a = in.read();
                }
                while (a != 10 && a != 32 && a != -1) {
                    no = no * 10 + (a - '0');
                    a = in.read();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
            return minus ? -no: no;
        }
        static String read() {
            StringBuilder str = new StringBuilder();
            try {
                int a = in.read();
                while (a == 32)
                    a = in.read();
                while (a != 10 && a != 32 && a != -1) {
                    str.append((char)a);
                    a = in.read();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            return str.toString();
        }
    }
}
