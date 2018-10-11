package zero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// no of divisors for a number
public class ODDDIV_OddNumbersOfDivisors {

    static List<Integer>[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList[10000];
        for(int i=0;i<10000;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=1;i<100000;i++){
            int res = 1;
            int n = i;
            for(int j=2;j*j<=n;j++){
                if(n%j==0){
                    int count = 0;
                    while(n%j==0){
                        count++;
                        n = n/j;
                    }
                    res *= (2*count+1);
                }
            }
            if(n>1) res *= 3;

            list[res].add(i);
        }
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int k = sc.nextInt();
            long low = sc.nextLong();
            long high = sc.nextLong();
            int l = lowBound(k,low,high);
            int h = highBound(k,low,high);

            if(h==-1 || l == -1){
                sb.append(0+"\n");
            }else{
                sb.append(h-l+1+"\n");
            }
        }
        System.out.println(sb.toString());
    }

    static int lowBound(int k,long x,long y){
        List<Integer> l = list[k];
        if(l.size() == 0) return -1;
        int low = 0;
        int high = l.size() - 1;
        int i = -1;
        while(low<=high){
            int mid = low + ((high-low)/2);
            long midL = 0;
            if(mid - 1 >= 0){
            midL = (long)l.get(mid-1)*l.get(mid-1);
           }
            long midV = (long)l.get(mid)*l.get(mid);
            if((mid-1 < 0 || midL < x) && (midV >= x && midV <= y)) {
                i = mid;
                break;
            }
            if(midV>=x){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }
        return i;
    }

    static int highBound(int k,long x,long y){
        List<Integer> l = list[k];
        if(l.size() == 0) return -1;
        int low = 0;
        int size = l.size()-1;
        int high = size;
        int i = -1;
        while(low<=high){
            int mid = low + ((high-low)/2);
            long midR = 0;
            if(mid+1<=size){
                midR = (long)l.get(mid+1)*l.get(mid+1);
            }
            long midV = (long)l.get(mid)*l.get(mid);
            if((mid+1 > size ||  midR > y) && (midV <= y && midV >= x)) {
                i = mid;
                break;
            }
            if(midV>y){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }
        return i;
    }

}
