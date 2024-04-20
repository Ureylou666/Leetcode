class Solution {
    public static int r1,c1,r2,c2;
    public static int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i< land.length; i++)
            for (int j = 0; j< land[0].length; j++ ) if (land[i][j] == 1) {
                r1 = i; c1 = j;
                r2 = i; c2 = j;
                dfs(land, i , j);
                list.add(new int[]{r1,c1,r2,c2});
            }
        int[][] result = new int[list.size()][4];
        for (int i=0;i<list.size();i++) result[i] = list.get(i);
        return result;
    }

    private static void dfs(int[][] land, int x1, int y1) {
        if ( x1 < 0 || y1 < 0 || x1 == land.length || y1 == land[0].length || land[x1][y1] == 0) return;
        land[x1][y1] = 0;
        if (x1+1 == land.length && y1+1 == land[0].length) {
            addCorner(x1,y1);
            return;
        }
        if (x1+1 == land.length && y1+1 < land[0].length && land[x1][y1+1] == 0 ) {
            addCorner(x1,y1);
            return;
        }
        if (y1+1 == land[0].length && x1 +1  < land.length && land[x1+1][y1] == 0) {
            addCorner(x1,y1);
            return;
        }
        if (x1+1 < land.length && y1+1 < land[0].length && land[x1+1][y1] == 0 && land[x1][y1+1] == 0) {
            addCorner(x1,y1);
            return;
        }
        else {
            dfs(land,x1+1,y1);
            dfs(land, x1,y1+1);
        }
        return;
    }

    private static void addCorner( int x, int y) {
        r2 = Math.max(x,r2);
        c2 = Math.max(c2,y);
    }
}

-----------

public class Solution {
    private static int r1, c1, r2, c2; // 用于记录农田的边界

    public static int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) { // 找到未访问的农田
                    r1 = r2 = i;
                    c1 = c2 = j;
                    dfs(land, i, j);
                    list.add(new int[]{r1, c1, r2, c2});
                }
            }
        }
        int[][] result = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static void dfs(int[][] land, int x, int y) {
        if (x < 0 || y < 0 || x >= land.length || y >= land[0].length || land[x][y] == 0) {
            return; // 边界条件和已访问的农田
        }
        // 标记当前单元格为已访问
        land[x][y] = 0;
        // 更新农田的边界
        r2 = Math.max(r2, x);
        c2 = Math.max(c2, y);

        // 递归访问相邻的四个方向
        dfs(land, x + 1, y); // 向下
        dfs(land, x - 1, y); // 向上
        dfs(land, x, y + 1); // 向右
        dfs(land, x, y - 1); // 向左
    }
}
