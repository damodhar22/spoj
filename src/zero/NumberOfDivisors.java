package zero;

import java.util.Scanner;

public class NumberOfDivisors {

    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    while(T-->0){
        long n = sc.nextLong();
        System.out.println(divisors(n));
    }
}

    static int divisors(long n){
        int res = 1, i, c;
        for(i=2; i*i<=n; i++) {
            if(n % i == 0) {
                c = 0;
                while(n % i == 0) {
                    n /= i;
                    c++;
                }
                res *= (c+1);
            }
        }
        if(n>1) res *= 2;
        return res;
    }

}
