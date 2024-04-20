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
