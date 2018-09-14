package zero;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class HELPD2R2 {
        //private static Reader in;
        private static Scanner in;
        private static PrintWriter out;
        private static int [] arr;
        static int s;

        public static void main (String [] args) throws IOException {
            //in = new Reader ();
            in = new Scanner(System.in);
            out = new PrintWriter (System.out, true);

            int n = 100000;
            int test = in.nextInt();
            arr = new int [n + 1];
            while(test-- > 0) {
                s = Integer.MIN_VALUE;
                int w = 0,
                        k = in.nextInt(),
                        no = in.nextInt();

                Arrays.fill(arr, k);
                IntervalTree root = new IntervalTree (1, n);

                int i = 1;
                while (i <= no) {
                    if (in.hasNextInt()) {
                        int tmp = in.nextInt();
                        i++;
                        w += tmp;
                        root.update(tmp);
                    } else {
                        in.next();
                        int r = in.nextInt(),
                                v = in.nextInt();
                        i += r;
                        w += r*v;
                        while(r-- > 0)
                            root.update(v);
                    }
                }
                out.println(s + " " + (s * k - w));
            }

        }

        static class IntervalTree {
            public IntervalTree Lchild = null,
                    Rchild = null;
            public int start, end, max;

            public IntervalTree () {}

            public IntervalTree (int _start, int _end) {
                start = _start; end = _end;
                if (start != end) {
                    int mid = (start + end) >> 1;
                    Lchild = new IntervalTree (start, mid);
                    Rchild = new IntervalTree (mid + 1, end);
                    join (this, Lchild, Rchild);
                }
                else {
                    this.max = arr[start];
                }
            }

            public void update(int value) {
                if(start == end) {
                    this.max -= value;
                    s = Math.max(s, start);
                    return;
                }

                if (Lchild.max < value) Rchild.update(value);
                else                    Lchild.update(value);
                join (this, Lchild, Rchild);
            }

            public void join (IntervalTree parent, IntervalTree Lchild, IntervalTree Rchild) {
                parent.max = Math.max(Lchild.max, Rchild.max);
            }
        }
    }
