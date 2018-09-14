package zero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AplusB {

	static int[] parseArray(String line) {
		StringTokenizer st = new StringTokenizer(line);
		int[] rv = new int[st.countTokens()];
		for (int i = 0; i < rv.length; ++i) {
			rv[i] = Integer.parseInt(st.nextToken());
		}
		return rv;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		try (BufferedReader in = new BufferedReader(new FileReader("input.txt"));
				PrintWriter out = new PrintWriter("output.txt")) {
			int n = Integer.parseInt(in.readLine());
			int[] p = parseArray(in.readLine());
			int[] t = parseArray(in.readLine());

			int[][] dp = new int[n + 1][4];
			// Fill the dynamic programming array with minus infinity
			for (int[] a : dp) {
				Arrays.fill(a, -1000000000);
			}

			dp[0][0] = 0;
			for (int i = 0; i < n; ++i) {
				dp[i + 1][1] = p[i] + Math.max(dp[i][0], dp[i][1]);
				dp[i + 1][2] = t[i] + Math.max(dp[i][0], dp[i][2]);
				dp[i + 1][3] = Math.max(Math.max(p[i] + dp[i][2], t[i] + dp[i][1]), Math.max(p[i], t[i]) + dp[i][3]);
			}

			out.println(dp[n][3]);
		}

	}
}
