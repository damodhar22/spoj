package zero;

import java.util.*;

public class DivisorInc {

    static int countOperations(int N, int M) {
        // using BFS
        int[] distance = new int[M + 1];
        Arrays.fill(distance,-1);
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        distance[N] = 0;

        while (!q.isEmpty()) {
            int val = q.peek();
            q.remove();

            if (val == M) break;

            for (int d : getDivisors(val)) {
                int pathValue = val + d;
                if (pathValue <= M && distance[pathValue] == -1) {
                    q.add(pathValue);
                    distance[pathValue] = distance[val] + 1;
                }
            }
        }

        return distance[M];
    }

    private static List<Integer> getDivisors(int val) {
        List<Integer> divisors = new ArrayList<>();

        for (int d = 2; d <= Math.sqrt(val); d++) {
            if (val % d == 0) {
                divisors.add(val / d);
                divisors.add(d);
            }
        }
        return divisors;
    }

public static void main(String args[]) {
        System.out.println(countOperations(4, 24));
        }
}
