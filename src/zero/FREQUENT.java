package zero;

import java.io.BufferedInputStream;
import java.io.IOException;

public class FREQUENT {

    static int[] s;
    static int[] a;
    public static void main(String args[]){

        FastIO fs = new FastIO();

        while(true) {
            int n = fs.readInt();
            if(n ==0)
                break;
            int q = fs.readInt();
            a = new int[n+1];
            s = new int[4*n+1];
            for(int i=1;i<=n;i++){
                a[i] = fs.readInt();
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
