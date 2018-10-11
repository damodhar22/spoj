package zero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TDKPRIME {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        boolean[] a = new boolean[90000001];
        int[] b = new int[5000001];

        a[0] = false;
        a[1] = false;

            int no = 90000000;
            int sqrt = (int)Math.sqrt(no);
            for (int i=3;i<=sqrt;i+=2){
                if(!a[i]){
                    for (int j=i*i;j<=no;j+=2*i){
                        a[j] = true;
                    }
                }
            }
            int count = 1;
            b[1] = 2;
            for (int i=3;i<=no;i+=2){
                if(!a[i]){
                    b[++count] = i;
                    if (count == 5000000)
                        break;
                }
            }

        int T = Integer.parseInt(br.readLine().trim());

            while (T-->0){
                int k = Integer.parseInt(br.readLine().trim());
                System.out.println(b[k]);
            }
    }
}
