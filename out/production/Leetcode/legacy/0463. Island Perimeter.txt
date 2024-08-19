class Solution {
    public int islandPerimeter(int[][] grid) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i<grid.length ; i++)
            for (int j=0; j<grid[i].length; j++) if (grid[i][j] == 1) {
                // 生成四个可能的边界键
                String[] keys = new String[]{
                        i + "," + j + ":" + (i + 1) + "," + j,
                        i + "," + j + ":" + i + "," + (j + 1),
                        (i + 1) + "," + j + ":" + (i+1) + "," + (j+1),
                        i + "," + (j+1) + ":" + (i+1) + "," + (j+1),
                };
                for (String key : keys) map.put(key, map.getOrDefault(key, 0) + 1);
            }
        int result = 0;
        for (String key : map.keySet()) if (map.get(key) == 1) result++;
        return result;
    }
}
