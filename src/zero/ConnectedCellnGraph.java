package zero;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConnectedCellnGraph {

    static boolean[][] v;

    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid, int n, int m) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j] && grid[i][j] != 0) {
                 int k = dfs(grid,i,j);
                 max = Math.max(max,k);
                }
            }
        }
        return max;
    }

    static int dfs(int[][] grid,int i,int j){
        if(v[i][j] || i < 0 || i>=grid.length || j<0||j>=grid[0].length){
         return 0;
        }else{
            v[i][j] = true;
            return 1+dfs(grid,i-1,j-1)+dfs(grid,i-1,j)+dfs(grid,i-1,j+1)+dfs(grid,i,j-1)+
                    dfs(grid,i,j+1)+dfs(grid,i+1,j-1)+dfs(grid,i+1,j)+dfs(grid,i+1,j+1);
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];
        v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid,n,m);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
