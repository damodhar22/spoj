package zero;

public class ZigZagIncreasingSubsequence {

	static int longestZigZag(int[] sequence) {
		if (sequence.length == 1)
			return 1;
		int[] v = new int[sequence.length - 1];
		for (int i = 1; i <= v.length; i++) {
			v[i - 1] = sequence[i] - sequence[i - 1];
		}
		// dir is first nonzero
		int ii = 0;
		while (ii < v.length && v[ii] == 0)
			ii++;
		if (ii == v.length)
			return 1;
		int dir = v[ii];
		int len = 2;
		for (int i = ii + 1; i < v.length; i++) {
			if (v[i] * dir < 0) {
				dir *= -1;
				len++;
			}
		}
		return len;
	}

	public static void main(String[] args) {
		int[] a = { 17, 1, 5, 10, 13, 15, 10, 5, 16, 8 };
		int[] b = {1, 7, 4, 9, 2, 5};
		//System.out.println(longestZigZag(b));
		System.out.println(longestZigZag(a));
	}

}

// {1, 7, 4, 9, 2, 5} 6
// {1, 17, 5, 10, 13, 15, 10, 5, 16, 8} 7