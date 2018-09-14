package zero;

import java.util.Arrays;
import java.util.Scanner;

public class Chopsticks {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        String[] str = s.split(" ");
        int N = Integer.parseInt(str[0]);
        int D = Integer.parseInt(str[1]);
        int a[] = new int[N];
        for(int i=0;i<N;i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int count = 0;
        for(int i=0;i<N-1;){
                if(a[i+1]-a[i] <=D ) {
                  count++;
                  i += 2;
                }else{
                    i++;
                }
            }
        System.out.println(count);
    }

}
