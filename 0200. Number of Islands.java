class Solution {
    public static int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i<grid.length; i++)
            for (int j = 0; j<grid[i].length; j++) if (grid[i][j] == '1') {
                result++;
                grid = dfs(i,j, grid);
            }
        return result;
    }

    private static char[][] dfs(int i, int j, char[][] grid){
        if (grid[i][j] == '1') grid[i][j] = '0';
        if ( j+1 < grid[i].length && grid[i][j+1] == '1') dfs(i,j+1, grid);
        if ( i+1 < grid.length && grid[i+1][j] == '1') dfs(i+1,j, grid);
        if ( i-1 >= 0 && grid[i-1][j] == '1') dfs(i-1,j, grid);
        if ( j-1 >= 0 && grid[i][j-1] == '1') dfs(i,j-1, grid);
        return grid;
    }
}
