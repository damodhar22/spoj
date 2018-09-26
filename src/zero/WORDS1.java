package zero;

import java.io.*;
import java.math.*;
import java.util.*;

public class WORDS1 {


    public static boolean checkConnections(int index) {
        /*
        If broken connections equal total number of connections, we are done, the graph is connected.
        */
        if(broken == connections)return true;
        int row = index;

        for(int i=1;i<27;++i){
            /*
            either this vertex can reach some other vertex or some other vertex can reach this vertex. Means they are connected.
            */
            if(graph[row][i]||graph[i][row]){
                if(graph[row][i])broken++;
                graph[row][i] = false;
                if(graph[i][row])broken++;
                graph[i][row] = false;
                if(checkConnections(i))return true;
            }
        }
        //Else if it is not the case, return false.
        return false;
    }

    static boolean[][] graph;
    static int connections = 0;
    static int broken=0;

    public static void main(String[] args) throws Exception {
        int nCases = IO.nextInt();
        while (nCases-- > 0) {
            connections=0;
            broken=0;
            graph = new boolean[27][27];
            int[] reg = new int[27];
            int nWords = IO.nextInt();
            int f, s;
            String[] words = new String[nWords];

            for (int i = 0; i < nWords; ++i) {
                words[i] = IO.nextString();
                reg[f =(words[i].charAt(0) - 96)]++;
                reg[s =(words[i].charAt(words[i].length() - 1) - 96)]--;

                //Check the number of unique connections in the graph to be later
                //used when checking the graph for connectivity
                if(graph[f][s]==false)connections++;
                graph[f][s]=true;
            }

            boolean possible = true;

            //No of minus one values (-1) in the array reg. this array stores the difference (in-out) connections.
            int mO = 0;
            int pO = 0;
            //No of zeros in the array reg.
            int zeros=0;

            for (int i = 1; i < reg.length; ++i) {
                if (reg[i] != 0) {
                    if (reg[i] == 1) pO++;
                    else if (reg[i] == -1) mO++;
                    else {
                        possible = false;
                        break;
                    }
                }else zeros++;
            }

            /*
              If in reg array (reg array stores the difference (no of incomming connections - no out outgoing connections)
              number of minus ones (mO) found is 1 and number of plus one found is 1,
              the graph may have an euler path (necessary but not sufficient condition).
              Even if mO and pO equal one, the graph could be a disconnected one for example
              in case
                abc
                cba

                qcr
                rcx

              This graph would be disconnected, yet has mO = 1 and pO = 1.
              for this, we need to check if every vertice is
              connected (no matter the direction of connection) to every other vertice.
            */
            if (!(mO==1 && pO==1)){
                /*
                  If there is no +1 or -1, all the vertices should have out-in connection difference = 0
                  for the graph to have the possibility of having an euler path.
                */
                if(zeros!=26) possible=false;
            }

            if(possible){
                /*
                  The vertex (index in graph) to start the dfs procedure from
                  This must be the vertex having |in-out connections| value = 1.
                */
                int in=-1;

                /*
                In case there is no such vertex. (All reg[i] values are 0.
                This means that the graph is of the form

                abc
                cbd
                dca

                This still has an euler path. The end can be joined to the beginning. (This doesn't bother us for the question).
                In this case, we can select any vertex as the starting vertex to see if it is connected to every other vertex.
                */
                for(int i=1;i<27;++i){if(reg[i]==1||reg[i]==-1)in = i;}
                if(in==-1)for(int i=1;i<27;++i){for(int j=1;j<27;++j)if(graph[i][j])in=i;}

                //checkConnections() checks if every vertice is connected in a single graph.
                possible = checkConnections(in);
            }

            if (possible) System.out.println("Ordering is possible.");
            else System.out.println("The door cannot be opened.");
        }
    }

    static class IO {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public static int[][] next2dInt(int rows, int cols, String seperator) throws Exception {
            int[][] arr = new int[rows + 1][cols + 1];
            for (int i = 1; i <= rows; ++i) {
                arr[i] = nextIntArray(cols, seperator);
            }
            return arr;
        }

        public static int[] nextIntArray(int nInts, String seperator) throws IOException {
            String ints = br.readLine();
            String[] sArray = ints.split(seperator);
            int[] array = new int[nInts + 1];
            for (int i = 1; i <= nInts; ++i) {
                array[i] = Integer.parseInt(sArray[i - 1]);
            }
            return array;
        }

        public static long[] nextLongArray(int nLongs, String seperator) throws IOException {
            String longs = br.readLine();
            String[] sArray = longs.split(seperator);
            long[] array = new long[nLongs + 1];
            for (int i = 1; i <= nLongs; ++i) {
                array[i] = Long.parseLong(sArray[i - 1]);
            }
            return array;
        }

        public static double[] nextDoubleArray(int nDoubles, String seperator) throws IOException {
            String doubles = br.readLine();
            String[] sArray = doubles.split(seperator);
            double[] array = new double[nDoubles + 1];
            for (int i = 1; i <= nDoubles; ++i) {
                array[i] = Double.parseDouble(sArray[i - 1]);
            }
            return array;
        }

        public static char[] nextCharArray(int nChars, String seperator) throws IOException {
            String chars = br.readLine();
            String[] sArray = chars.split(seperator);
            char[] array = new char[nChars + 1];
            for (int i = 1; i <= nChars; ++i) {
                array[i] = sArray[i - 1].charAt(0);
            }
            return array;
        }

        public static int nextInt() throws IOException {
            String in = br.readLine();
            return Integer.parseInt(in);
        }

        public static double nextDouble() throws IOException {
            String in = br.readLine();
            return Double.parseDouble(in);
        }

        public static long nextLong() throws IOException {
            String in = br.readLine();
            return Long.parseLong(in);
        }

        public static int nextChar() throws IOException {
            String in = br.readLine();
            return in.charAt(0);
        }

        public static String nextString() throws IOException {
            return br.readLine();
        }

        public static void print(Object... o) {
            for (Object os : o) {
                System.out.print(os);
            }
        }

        public static void println(Object... o) {
            for (Object os : o) {
                System.out.print(os);
            }
            System.out.print("\n");
        }

        public static void printlnSeperate(String seperator, Object... o) {
            StringBuilder sb = new StringBuilder();
            sb.delete(sb.length() - seperator.length(), sb.length());
            System.out.println(sb);
        }
    }
}
