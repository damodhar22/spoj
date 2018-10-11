package zero;

import java.util.*;

public class ACMAKER_ACM {

    static char[] a;
    static List<String> str;
    static int n;

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        while(true) {
            int n = Integer.parseInt(sc.nextLine().trim());
            if (n == 0) break;
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(sc.nextLine().trim());
            }

            while (true) {
                String s = sc.nextLine().trim().toLowerCase();

                if ("last case".equals(s)) break;

                String[] str2 = s.split(" ");
                n = str2.length;
                a = str2[0].toCharArray();
                str = new ArrayList<>();
                for(int i=1;i<str2.length;i++){
                    if(!set.contains(str2[i])){
                        str.add(str2[i]);
                    }
                }
                System.out.println(doFun(0, 0));
            }
        }
    }


    static int doFun(int i,int j){

        if(i >=a.length || j>= str.size())
            return 0;
        int count = 0;
        int res = 0;
        for(int k=0;k<str.get(j).length();k++){
            if(a[i] == str.get(j).charAt(k)){
                count++;
                res += doFun(i+1,j+1);
                i++;
            }

            if(i >= a.length){
                if(j == str.size() - 1)
                    res += 1;
                break;
            }
        }

        if(count == 0){
            return 0;
        }
          return res;
    }


}
