//package zero;
//
//import javafx.util.Pair;
//
//import java.util.Scanner;
//
//public class NICEDAY {
//
//    static Pair<Integer, Pair<Integer, Integer>> inp[];
//    static int tree[];
//    static int n;
//
//    int read(int idx){
//        int res = 1 << 30;
//        while(idx > 0){
//            res = Math.min(res, tree[idx]);
//            idx -= (idx & -idx);
//        }
//        return res;
//    }
//
//    void update(int idx, int val){
//        while(idx <= n){
//            tree[idx] = Math.min(tree[idx], val);
//            idx += (idx & -idx);
//        }
//    }
//
//    int main()
//    {
//
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        //inp = new Pair<Integer, Pair<Integer, Integer>>[100000 + 5];
//        while(t-->0){
//
//            n = sc.nextInt();
//
//            for(int i = 0 ; i < n ; i++){
//                inp[i] = new Pair<>(sc.nextInt(),new Pair<>(sc.nextInt(),sc.nextInt()));
//            }
//
//            sort(inp, inp + n);
//
//            int maxx = 1 << 30;
//            fill(tree, tree + n + 3, maxx);
//            int res = 0;
//
//            for(int i = 0 ; i < n ; i++){
//                int cur = read(inp[i].second.first);
//                if(cur > inp[i].second.second){
//                    res++;
//                }
//                update(inp[i].second.first, inp[i].second.second);
//            }
//
//            printf("%d\n", res);
//
//
//        }
//        return 0;
//    }
