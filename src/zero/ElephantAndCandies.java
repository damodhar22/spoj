package zero;

import java.util.Scanner;

public class ElephantAndCandies {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int T = Integer.parseInt(str);
        while(T > 0){
            T--;
            str = s.nextLine();
            String[] str2 = str.split(" ");
            int N = Integer.parseInt(str2[0]);
            //int A[] = new int[N];
            int C = Integer.parseInt(str2[1]);
            str = s.nextLine();
            str2 = str.split(" ");
            int sum = 0;
            for(int i=0;i< N;i++){
               sum  += Integer.parseInt(str2[i]);
            }
            if(sum <= C){
              System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }

}
