package zero;

import java.util.ArrayList;
import java.util.Scanner;

public class Stacks {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T>0){
            T--;
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }

            ArrayList<Integer> l = new ArrayList<Integer>();

            for(int i=0;i<n;i++){
                int lo = 0;
                int hi = l.size()-1;
                while(lo<=hi){
                    int mid = lo + (hi - lo) / 2;
                    if(l.get(mid) <= a[i]){
                        lo = mid + 1;
                    }else if(l.get(mid) > a[i] && ((mid > 0 && a[i] >= l.get(mid-1)) || mid == 0 )){
                        l.remove(mid);
                        l.add(mid,a[i]);
                        break;
                    }else{
                        hi = mid - 1;
                    }
                }
                if(lo == 0 && l.isEmpty()){
                    l.add(0,a[i]);
                }else if(lo==l.size()){
                    l.add(a[i]);
                }
            }

            System.out.print(l.size()+" ");

            for (int i: l
                 ) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }

}
