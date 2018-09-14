//package zero;
//
//public class JosephTreeHR {
//    //
////        #define pb push_back
////        #define f first
////        #define s second
////        #define mp make_pair
////        #define sz(a) int((a).size())
////        #ifdef _WIN32
////        #  define I64 "%I64d"
////        #else
////        #  define I64 "%lld"
////        #endif
////        #define fname "."
////        #define pi pair < int, int >
////        #define pp pop_back
////        typedef long long ll;
////        typedef long double ld;
////        typedef unsigned long long ull;
////        const int MAX_N = (int)1e5 + 123;
////        const double eps = 1e-6;
////        const int inf = (int)1e9 + 123;
////        using namespace std;
//    int n, q;
//    vector<pi> g[MAX_N];
//    struct tree
//    {
//        int sum, l, r;
//        tree() :sum(0), l(-1), r(-1) {
//    }
//    }
//
//    ;
//    vector<tree> t;
//
//    int update(int x, int v, int tl =0, int tr =n-1) {
//        int now = sz(t);
//        t.pb(tree());
//        if (v != -1)
//            t[now] = t[v];
//        if (tl == tr) {
//            t[now].sum++;
//            return now;
//        }
//        int tm = (tl + tr) / 2;
//        if (x <= tm) {
//            int son = update(x, (v == -1 ? -1 : t[v].l), tl, tm);
//            t[now].l = son;
//        } else {
//            int son = update(x, (v == -1 ? -1 : t[v].r), tm + 1, tr);
//            t[now].r = son;
//        }
//        t[now].sum = 0;
//        if (t[now].l != -1)
//            t[now].sum += t[t[now].l].sum;
//        if (t[now].r != -1)
//            t[now].sum += t[t[now].r].sum;
//        return now;
//    }
//
//    int find_kth(int L, int R, int k, int tl =0, int tr =n-1) {
//        if (tl == tr)
//            return tl;
//        int tm = (tl + tr) / 2;
//        int left = 0;
//        if (R != -1 && t[R].l != -1)
//            left += t[t[R].l].sum;
//        if (L != -1 && t[L].l != -1)
//            left -= t[t[L].l].sum;
//        if (k <= left)
//            return find_kth((L == -1 ? -1 : t[L].l), (R == -1 ? -1 : t[R].l), k, tl, tm);
//        k -= left;
//        return find_kth((L == -1 ? -1 : t[L].r), (R == -1 ? -1 : t[R].r), k, tm + 1, tr);
//    }
//
//    vector<int> st;
//    ll dist[MAX_N];
//    int l[MAX_N],r[MAX_N];
//
//    void dfs(int v, int pr =-1, ll all =0) {
//        dist[v] = all;
//        l[v] = sz(st);
//        st.pb(v);
//        for (auto to : g[v])
//            if (to.f != pr)
//                dfs(to.f, v, all + to.s);
//        r[v] = sz(st) - 1;
//    }
//
//    int root[MAX_N];
//    vector<ll> uniq;
//
//    ll get(int v, int k) {
//        int sz = r[v] - l[v];
//        if (k > sz)
//            return -1;
//        return uniq[find_kth(root[l[v]], root[r[v]], k)] - uniq[dist[v]];
//    }
//
//    public static void main() {
//        #ifdef Nick
//        freopen(fname"in", "r", stdin);
//        freopen(fname"out", "w", stdout);
//        #endif
//        scanf("%d", & n);
//        for (int i = 1, u, v, w; i < n; i++) {
//            scanf("%d%d%d", & u, &v, &w);
//            g[u].pb(mp(v, w)), g[v].pb(mp(u, w));
//        }
//
//        dfs(1);
//        for (int i = 1; i <= n; i++)
//            uniq.pb(dist[i]);
//        sort(uniq.begin(), uniq.end());
//        uniq.resize(unique(uniq.begin(), uniq.end()) - uniq.begin());
//        for (int i = 1; i <= n; i++)
//            dist[i] = lower_bound(uniq.begin(), uniq.end(), dist[i]) - uniq.begin();
//        for (int i = 0, last = -1; i < sz(st); i++) {
//            last = root[i] = update(dist[st[i]], last);
//        }
//        int query;
//        scanf("%d", & query);
//        for (int i = 1, v, k; i <= query; i++) {
//            scanf("%d%d", & v, &k);
//            printf(I64"\n", get(v, k));
//        }
//        return 0;
//    }
//
//}