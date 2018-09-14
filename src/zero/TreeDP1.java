package zero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TreeDP1 {
	static Map<Integer, ArrayList<Integer>> g = new HashMap<Integer, ArrayList<Integer>>();

	public static int dfs(Integer u) {
		int i, j;
		int ans = 0;
		ArrayList<Integer> al = g.get(u);
		if (al != null)
			for (i = 0; i < al.size(); i++) {
				int v = al.get(i);
				ans = Math.max(ans, 1 + dfs(v));
			}
		return ans;
	}

	public static void main(String[] args) {
		int i, n, m;
		Scanner s = new Scanner(System.in);
		String k = s.nextLine();
		n = Integer.parseInt(k);
		Map<String, Integer> A = new HashMap<String, Integer>();
		for (i = 0; i < n; i++) {
			String a, b, c;
			String str = s.nextLine();
			String[] st = str.split(" ");
			a = st[0].toUpperCase();
			c = st[1];
			b = st[2].toUpperCase();
			if (!A.containsKey(a)) {
				A.put(a, A.size() + 1);
			}
			if (!A.containsKey(b)) {
				A.put(b, A.size() + 1);
			}

			if (g.containsKey(A.get(b))) {
				g.get(A.get(b)).add(A.get(a));
			} else {
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(A.get(a));
				g.put(A.get(b), al);
			}

		}
		System.out.println(1 + dfs(A.get("POLYCARP")));
	}
}