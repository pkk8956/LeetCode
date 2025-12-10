package Graph;

public class LC_547 {

    // Number of Provinces

    /* There are n cities. Some of them are connected, while some are not.
    If city a is connected directly with city b, and city b is connected directly with city c,
    then city a is connected indirectly with city c.
    A province is a group of directly or indirectly connected cities and no other cities outside of the group.
    You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
    and isConnected[i][j] = 0 otherwise.
    Return the total number of provinces.*/

    public static void main(String[] args) {
        LC_547 obj = new LC_547();
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        int result = obj.findCircleNum(isConnected);
        System.out.println("Number of provinces: " + result);
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinceCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinceCount++;
            }
        }
        return provinceCount;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
    
}
