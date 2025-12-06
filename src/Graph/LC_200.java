package Graph;

public class LC_200 {

    //Number of Islands

    /*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), 
    return the number of islands. An island is surrounded by water and is formed by connecting adjacent 
    lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.*/

    public static void main(String[] args) {
        LC_200 obj = new LC_200();  
        char[][] grid = {{'1','1','1','1','0'}, 
                         {'1','1','0','1','0'}, 
                         {'1','1','0','0','0'}, 
                         {'0','0','0','0','0'}};
            
        System.out.println(obj.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
       if (grid == null || grid.length == 0) return 0;

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] == '0') return;

        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
