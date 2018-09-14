package zero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TreeDP2InOut {

	//
	// #include <bits/stdc++.h>
	//// #include "stdafx.h"
	//// #pragma warning(disable : 4996) //_CRT_SECURE_NO_WARNINGS
	// using namespace std;
	// #define gc getchar_unlocked
	// #define fo(i,n) for(i=0;i<n;i++)
	// #define Fo(i,k,n) for(i=k;k<n?i<n:i>n;k<n?i+=1:i-=1)
	// #define ll long long
	// #define si(x) scanf("%d",&x)
	// #define sl(x) scanf("%lld",&x)
	// #define ss(s) scanf("%s",s)
	// #define pi(x) printf("%d\n",x)
	// #define pl(x) printf("%lld\n",x)
	// #define ps(s) printf("%s\n",s)
	// #define deb(x) cout << #x << "=" << x << endl
	// #define deb2(x, y) cout << #x << "=" << x << "," << #y << "=" << y <<
	// endl
	// #define pb push_back
	// #define mp make_pair
	// #define F first
	// #define S second
	// #define all(x) x.begin(), x.end()
	// #define clr(x) memset(x, 0, sizeof(x))
	// #define sortall(x) sort(all(x))
	// #define tr(it, a) for(auto it = a.begin(); it != a.end(); it++)
	// #define PI 3.1415926535897932384626
	// typedef pair<int, int> pii;
	// typedef pair<ll, ll> pl;
	// typedef vector<int> vi;
	// typedef vector<ll> vl;
	// typedef vector<pii> vpii;
	// typedef vector<pl> vpl;
	// typedef vector<vi> vvi;
	// typedef vector<vl> vvl;
	// int mpow(int base, int exp);
	// void ipgraph(int m);
	// const int mod = 1000000007;
	static int N = (int) 3e5, M = N;
	// =======================

	static Map<Integer, List<Integer>> g = new HashMap<Integer, List<Integer>>();
	static int[] a = new int[N];
	static int[] in = new int[N];
	static int[] out = new int[N];
	static int[] dp = new int[N];

	static void dfs1(int u, int par) {
		in[u] = 0;
		List<Integer> li = g.get(u);
		for (int v : li) {
			if (v == par)
				continue;
			dfs1(v, u);
			in[u] = Math.max(in[u], 1 + in[v]);
		}
	}

	static void dfs2(int u, int par) {

		int mx1 = -1;
		int mx2 = -1;

		// find top 2 maximum values of in[v]
		List<Integer> li = g.get(u);
		for (int v : li) {
			if (v == par)
				continue;
			if (in[v] >= mx1) {
				mx2 = mx1;
				mx1 = in[v];
			} else if (in[v] > mx2)
				mx2 = in[v];
		}
		for (int v : li) {
			if (v == par)
				continue;
			int use = mx1;

			if (mx1 == in[v])
				use = mx2;

			out[v] = Math.max(1 + out[u], 2 + use);

			dfs2(v, u);
		}
	}

public static void main(String args[])
{
	//ios_base::sync_with_stdio(false);
	//cin.tie(NULL);
	int i,n,k,j,u,v;
	Scanner s = new Scanner(System.in);
	String kin = s.nextLine();
	n = Integer.parseInt(kin);
	
	for(i=0;i<n-1;i++){
		String str = s.nextLine();
		String[] str2 = str.split(" ");
		u = Integer.parseInt(str2[0]);
		v = Integer.parseInt(str2[1]);
		if(g.containsKey(u)){
			List<Integer> li= g.get(u);
			li.add(v);
		}else{
			List<Integer> li = new ArrayList<Integer>();
			li.add(v);
			g.put(u, li);
		}
		
		if(g.containsKey(v)){
			List<Integer> li= g.get(v);
			li.add(u);
		}else{
			List<Integer> li = new ArrayList<Integer>();
			li.add(u);
			g.put(v, li);
		}
	}
	
	dfs1(1, 0);
	dfs2(1, 0);
	//for(i=k;k<n?i<n:i>n;k<n?i+=1:i-=1)
	for(i=1;i<n+1; i++){
		dp[i] = Math.max(in[i], out[i]);
		System.out.println(dp[i]);
		//cout << dp[i] << " " ;
	}
}
}