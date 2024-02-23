class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] result = new int[n+1][n];
        for (int i=0; i<result.length;i++) {
            Arrays.fill(result[i],100001);
        }
        result[0][src] = 0;
        for (int i=0; i<flights.length;i++) {
            if (flights[i][0] == src) {
                result[0][flights[i][1]]= flights[i][2];
            }
        }
        int m = 1;
        while (m<=k+1) {
            result[m] = result[m-1].clone();
            for (int i=0; i<flights.length;i++) {
                int x = flights[i][0];
                int y = flights[i][1];
                int price = flights[i][2];
                if (result[m][y] > result[m-1][x] + price) {
                    result[m][y] = result[m-1][x] + price;
                }
            }
            m++;
        }
        if (result[k][dst] > 100000) {
            return -1;
        }
        return result[k][dst];
    }
}
