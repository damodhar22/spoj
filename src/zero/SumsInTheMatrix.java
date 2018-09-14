package zero;

import java.util.Arrays;
import java.util.Scanner;

public class SumsInTheMatrix {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int n = Integer.parseInt(str.trim());
        str = s.nextLine();
        int m = Integer.parseInt(str.trim());
        long sumRow[] = new long[n];
        long sumCol[] = new long[m];
        while(n>0) {
            n--;
            str = s.nextLine();
            String[] strs = str.trim().split("\\s+");
            long sumT = 0;
            for (int i = 0; i < strs.length; i++) {
                sumT += Integer.parseInt(strs[i]);
                sumCol[i] += Integer.parseInt(strs[i]);
            }
            sumRow[n] = sumT;
        }
        Arrays.sort(sumRow);
        Arrays.sort(sumCol);
        str = s.nextLine();
        int Q = Integer.parseInt(str.trim());
        str = s.nextLine();

        while(Q>0){
            Q--;
            str = s.nextLine();
            String[] strs = str.trim().split("\\s+");
            long l = Long.parseLong(strs[0]);
            long r = Long.parseLong(strs[1]);

            System.out.print(cR(sumRow, sumRow.length, l, r)+cR(sumCol, sumCol.length, l, r)+" ");
        }
    }

    static int lI(long a[], int i, long j)
    {
        int l = 0, h = i - 1;
        while (l <= h)
        {
            int mid = (l + h) / 2;
            if (a[mid] >= j)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    static int uI(long a[], int i, long j)
    {
        int l = 0, h = i - 1;
        while (l <= h)
        {
            int mid = (l + h) / 2;
            if (a[mid] <= j)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return h;
    }


    static int cR(long a[], int i, long l, long r)
    {
        int count = 0;
        count = uI(a, i, r) -
                lI(a, i, l) + 1;
        return count;
    }

}
