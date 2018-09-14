package zero;

import java.util.Scanner;

public class EqualArray {
    public static void main(String args[]){
        Scanner s= new Scanner(System.in);
        int t = s.nextInt();
        while(t>0){
            t--;
            int size = s.nextInt();
            int a[] = new int[size];
            int sum=0;
            for(int i=0;i<size;i++){
                a[i]=s.nextInt();
                sum+=a[i];
            }

            sum-=a[0];
            int lsum = a[0];
            if(lsum>sum){
                System.out.println(-1);
            }else if(lsum==sum){
                System.out.println(0);
            }
            else{
                int min = sum - a[0];
                for (int i=1;i<size-1;i++){
                    lsum+=a[i];
                    sum-=a[i];
                    int tmin=sum-lsum;
                    if(tmin<0){
                        break;
                    }else if(tmin==0){
                        min = tmin;
                        break;
                    }else if(tmin<min){
                        min = tmin;
                    }
                }
                System.out.println(min);
            }
        }
    }

}
