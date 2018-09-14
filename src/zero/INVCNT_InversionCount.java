package zero;

import java.util.*;
import java.io.*;

public class INVCNT_InversionCount {
        static void update(int bit[],int n,int index,int val)
        {
            while(index<=n)
            {
                bit[index]=bit[index]+val;
                index=index+(index & (-index));
            }
        }
        static long getsum(int bit[],int index)
        {
            long sum=0;
            while(index>0)
            {
                sum=sum+bit[index];
                index=index-(index & (-index));
            }
            return sum;
        }
        static void constructBit(int a[])
        {
            long count=0;
            int n=a.length;
            int bit[]=new int[n+1];
            for(int i=n-1;i>=0;i--)
            {
                count=count+getsum(bit,a[i]-1);
                update(bit,n,a[i],1);
            }
            System.out.println(count);
        }
        static void convert(int a[])
        {
            int temp[]=new int[a.length];
            for(int i=0;i<a.length;i++)
                temp[i]=a[i];
            Arrays.sort(temp);
            HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
            for(int i=0;i<a.length;i++)
            {
                hm.put(temp[i],i);
            }
            for(int i=0;i<a.length;i++)
            {
                a[i]=hm.get(a[i])+1;
            }
        }
        public static void main(String args[])
        {
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while(t-->0)
            {
                int n=sc.nextInt();
                int a[]=new int[n];
                for(int i=0;i<n;i++)
                    a[i]=sc.nextInt();
                convert(a);
                constructBit(a);

            }
        }
    }
