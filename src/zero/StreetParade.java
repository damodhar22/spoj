package zero;

import java.util.Scanner;
import java.util.Stack;

public class StreetParade {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);

        while(true){
            int t = s.nextInt();
            if(t==0){
                break;
            }
            int order[] = new int[t];
            for(int i=0;i<t;i++){
                order[i] = s.nextInt();
            }
            Stack<Integer> lane = new Stack<Integer>();
            boolean f = true;
            int need = 1;
            for (int i = 0; i < order.length; i++) {
                while (!lane.empty() && lane.peek() == need) {
                    need++;
                    lane.pop();
                }
                if (order[i] == need) {
                    need++;
                } else if (!lane.empty() && lane.peek() < order[i]) {
                    f = false;
                    break;
                } else {
                    lane.push(order[i]);
                }
            }

            if(f){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }

    }
}
