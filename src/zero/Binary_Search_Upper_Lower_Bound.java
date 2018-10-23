package zero;

import java.util.Scanner;

public class Binary_Search_Upper_Lower_Bound {

        static int[] a;

        public static void main ( String [] args ){

            ///////////// 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16
            a = new int[]{1, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 7, 7, 7, 7, 7, 8};

            System.out.println("lower bound 2=="+lowerBound(2));
            System.out.println("higer bound 2=="+higherBound(2));

            System.out.println("lower bound 2=="+lowerBound(7));
            System.out.println("higer bound 2=="+higherBound(7));

            System.out.println("lower bound 2=="+lowerBound(1));
            System.out.println("higer bound 2=="+higherBound(1));

            System.out.println("lower bound 2=="+lowerBound(8));
            //System.out.println("higer bound 2=="+higherBound(8));

        } // end main method


        //sdasdadad
    // this is for range of single number
    static int lowerBound(int x){
            int low = 0;
            int high = a.length-1;
            int lowerNoundIdx = -1;
            while(low<=high){
                int mid = low + (high-low)/2;
                if(a[mid] == x){
                    lowerNoundIdx = mid;
                }
                if(x<=a[mid]){
                 high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            return lowerNoundIdx;
    }

    // this is for range of single number
    static int higherBound(int x){
        int low = 0;
        int high = a.length-1;
        int higherBoundIdx = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(a[mid] == x){
                higherBoundIdx = mid;
            }
            if(x>=a[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return higherBoundIdx;
    }


	}
