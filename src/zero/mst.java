package zero;

	import java.util.Arrays;
	import java.util.PriorityQueue;
	import java.util.Scanner;
	
	class Edge implements Comparable<Edge>{
	
		int data;
		int u;
		int v;
	
		public Edge(int u, int v,int data) {
			this.data = data;
			this.u = u;
			this.v = v;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if (this.data > o.data) {
				return 1;
			} else if (this.data < o.data) {
				return -1;
			} else {
				return 0;
			}
		}
	
	}
	
	public class mst {
	
		public static void main(String[] args) {
			// Scanner
			Scanner s = new Scanner(System.in);
			int noV = s.nextInt();
			int noE = s.nextInt();
			int tSum = s.nextInt();
			int[] a = new int[noE];
			int sum = 0;
			Arrays.fill(a, -1);
			PriorityQueue<Edge> q = new PriorityQueue<Edge>();
			//for (int i = 0; i < size; i++) {
				for (int j = 0; j < noE; j++) {
					int src = s.nextInt();
					int dest = s.nextInt();
					int w = s.nextInt();
						Edge e = new Edge(src, dest, w);
						q.add(e);
				}
			//}
			int l = 0;
			while(!q.isEmpty()){
				Edge e = q.remove();
				if(a[e.v] !=-1 && a[e.u] != -1 ){
					continue;
				}
				
				int t = sum + e.data;
				if(t>tSum){
					break;
				}
				sum+=e.data;
				l+=1;
				if(a[e.v] == -1){
					a[e.v]=1;
				}
				if(a[e.u] == -1){
					a[e.u]=1;
				}
			}
			
			if(l==0){
				System.out.println(-1);	
			}else{
				System.out.println(l);
			}
		}
		
		int maxValueByCuttingRod(int[] price, int n)
		{
		int[] a = new int[n+1];

				Arrays.fill(a, -1);

				return recM(price, n, a);
			}

			int recM(int[] price, int n, int[] a) {
				if (n <= 0) {
					return 0;
				} else {
					
					if(a[n]==-1){
						int max = -1;
					for (int j = 1; j < price.length; j++) {
						int m = 0;
						if (n - j >= 0) {
							m = price[j] + recM(price, n - j,a);
						}
						max = max < m ? m : max;
					}
					a[n] = max;
					}
					return a[n];
				}
			}
	}
















