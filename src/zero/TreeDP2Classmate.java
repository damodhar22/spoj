package zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TreeDP2Classmate {

	static Map<Integer, List<Integer>> L = new HashMap<Integer, List<Integer>>();
	static int[] Q = new int[100000];
	static boolean[] visited = new boolean[100000];
	static int[] dp = new int[100000];
	static int[] sons = new int[100000];

	public static void main(String args[]) {
		int N;
		Scanner s = new Scanner(System.in);

		String s1 = s.nextLine();
		N = Integer.parseInt(s1);

		for (int i = 0; i < N; ++i) {
			while (true) {
				int v = s.nextInt();
				if (v == 0)
					break;

				if (!L.containsKey(v)) {
					List<Integer> l1 = new ArrayList<Integer>();
					l1.add(i);
					L.put(v, l1);
				} else {
					L.get(v).add(i);
				}
				if (!L.containsKey(i)) {
					List<Integer> l2 = new ArrayList<Integer>();
					l2.add(v);
					L.put(i, l2);
				} else {
					L.get(i).add(v);
				}
			}

		}

		int root = s.nextInt();
		--root;

		int head = 0, tail = 0;
		Q[tail++] = root;
		visited[root] = true;

		for (int i = 0, v; i < N; ++i) {
			v = Q[head++];
			List<Integer> li = L.get(v);
			for (int j = li.size() - 1; j >= 0; --j) {
				Integer nxt = li.get(j);
				if (!visited[nxt]) {
					Q[tail++] = nxt;
					visited[nxt] = true;
				}
			}
		}

		Arrays.fill(dp, -1);

		for (int i = N - 1; i >= 0; --i) {
			int v = Q[i];
			int cont = 0;
			List<Integer> li = L.get(v);
			for (int j = li.size() - 1; j >= 0; --j)
				if (dp[li.get(j)] != -1)
					sons[cont++] = dp[li.get(j)];

			// sort(sons, sons + cont);
			Arrays.sort(sons, 0, cont);

			dp[v] = 0;
			for (int j = 0; j < cont; ++j)
				dp[v] = Math.max(dp[v], cont - j + sons[j]);
		}

		System.out.println(dp[root]);
	}
}