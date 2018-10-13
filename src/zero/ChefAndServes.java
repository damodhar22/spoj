package zero;

import java.util.Scanner;

public class ChefAndServes {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T-->0){
            long p1 = sc.nextLong();
            long p2 = sc.nextLong();
            long k = sc.nextLong();

            long sum = p1+p2;
            long n1=sum%(2*k);
            if(n1 < k){
                System.out.println("CHEF");
            }else{
                System.out.println("COOK");
            }
        }

    }
}
