package zero;

import java.util.Scanner;

public class TRIPINV {

    static long[] T1, T2;

    static void update(long[] t, int x, long v) {
        while (x > 0) {
            t[x] += v;
            x -= x & -x;
        }
    }

    static long query(long[] t, int x,int N) {
        long ret = 0;
        while (x <= N) {
            ret += t[x];
            x += x & -x;
        }
        return ret;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long ans = 0;
        T1 = new long[N+1];
        T2 = new long[N+1];
        for (int i = 1;i<=N;i++)
        {
            int x = sc.nextInt();
            update(T1, x, 1);
            long q = query(T1, x + 1,N);
            update(T2, x, q);
            ans += query(T2, x + 1,N);
        }
        System.out.println(ans);
    }
}