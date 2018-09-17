package zero;

    // A C++ program to find strongly connected components in a given
// directed graph using Tarjan's algorithm (single DFS)


import java.util.*;

// A class that represents an directed graph
    public class TarjansAlgo_StronglyConnectedComponents {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List
    static int time = 0;

    //Constructor
    TarjansAlgo_StronglyConnectedComponents(int v) {
        V = v;
        adj = new LinkedList[v];
        time = 0;
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }
    // A recursive function that finds and prints strongly connected
// components using DFS traversal
// u --> The vertex to be visited next
// disc[] --> Stores discovery times of visited vertices
// low[] -- >> earliest visited vertex (the vertex with minimum
//             discovery time) that can be reached from subtree
//             rooted with current vertex
// st -- >> To store all the connected ancestors (could be part
//           of SCC)
// stackMember[] --> bit/index array for faster check whether
//                  a node is in stack

    void SCCUtil(int u, int disc[], int low[], Stack<Integer> st, boolean stackMember[]) {
        // A static variable is used for simplicity, we can avoid use
        // of static variable by passing a pointer.


        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;
        st.push(u);
        stackMember[u] = true;

        // Go through all vertices adjacent to this
        Iterator<Integer> i = adj[u].listIterator();
        while (i.hasNext()) {
            int v = i.next();  // v is current adjacent of 'u'

            // If v is not visited yet, then recur for it
            if (disc[v] == 0) {
                SCCUtil(v, disc, low, st, stackMember);

                // Check if the subtree rooted with 'v' has a
                // connection to one of the ancestors of 'u'
                // Case 1 (per above discussion on Disc and Low value)
                low[u] = Math.min(low[u], low[v]);
            }

            // Update low value of 'u' only of 'v' is still in stack
            // (i.e. it's a back edge, not cross edge).
            // Case 2 (per above discussion on Disc and Low value)
            else if (stackMember[v] == true)
                low[u] = Math.min(low[u], disc[v]);
        }

        // head node found, pop the stack and print an SCC
        int w = 0;  // To store stack extracted vertices
        if (low[u] == disc[u]) {
            while (st.peek() != u) {
                w = (int) st.peek();
                System.out.print(w + " ");
                stackMember[w] = false;
                st.pop();
            }
            w = (int) st.peek();
            System.out.println(w);
            stackMember[w] = false;
            st.pop();
        }
    }

    // The function to do DFS traversal. It uses SCCUtil()
    void SCC() {
        int[] disc = new int[V];
        int[] low = new int[V];
        Arrays.fill(low, Integer.MAX_VALUE);
        boolean[] stackMember = new boolean[V];
        Stack<Integer> st = new Stack<Integer>();

        // Call the recursive helper function to find strongly
        // connected components in DFS tree with vertex 'i'
        for (int i = 0; i < V; i++)
            if (disc[i] == 0)
                SCCUtil(i, disc, low, st, stackMember);
    }

    // Driver program to test above function
    public static void main(String args[]) {
        System.out.println("\nSCCs in first graph");

        TarjansAlgo_StronglyConnectedComponents g1 = new TarjansAlgo_StronglyConnectedComponents(5);

        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.SCC();

        System.out.println("\nSCCs in second graph n");

        TarjansAlgo_StronglyConnectedComponents g2 = new TarjansAlgo_StronglyConnectedComponents(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.SCC();

        System.out.println("\nSCCs in third graph n");

        TarjansAlgo_StronglyConnectedComponents g3 = new TarjansAlgo_StronglyConnectedComponents(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        g3.SCC();

        System.out.println("\nSCCs in fourth graph");
        TarjansAlgo_StronglyConnectedComponents g4 = new TarjansAlgo_StronglyConnectedComponents(11);
        g4.addEdge(0, 1);
        g4.addEdge(0, 3);
        g4.addEdge(1, 2);
        g4.addEdge(1, 4);
        g4.addEdge(2, 0);
        g4.addEdge(2, 6);
        g4.addEdge(3, 2);
        g4.addEdge(4, 5);
        g4.addEdge(4, 6);
        g4.addEdge(5, 6);
        g4.addEdge(5, 7);
        g4.addEdge(5, 8);
        g4.addEdge(5, 9);
        g4.addEdge(6, 4);
        g4.addEdge(7, 9);
        g4.addEdge(8, 9);
        g4.addEdge(9, 8);
        g4.SCC();

        System.out.println("nSCCs in fifth graph n");

        TarjansAlgo_StronglyConnectedComponents g5 = new TarjansAlgo_StronglyConnectedComponents(5);
        g5.addEdge(0, 1);
        g5.addEdge(1, 2);
        g5.addEdge(2, 3);
        g5.addEdge(2, 4);
        g5.addEdge(3, 0);
        g5.addEdge(4, 2);
        g5.SCC();
    }
}
