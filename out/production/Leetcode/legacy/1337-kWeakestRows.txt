/**
     * @Description: 1337. The K Weakest Rows in a Matrix
     * @Param: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
     * @return @return null
     * @author urey.lou
     * @create 2024/2/15
     **/
    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        int[] sum = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                sum[i] = sum[i] + mat[i][j];
            }
            sum[i] = sum[i] * 100 + i;
        }
        Arrays.sort(sum);
        for (int i = 0; i < k; i++) {
            result[i] = sum[i] % 100;
        }
        return result;
    }
