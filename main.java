import java.util.*;

class main {

    public static void main (String[] args) {
        // String grid1 = "[[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]]";
        // String grid2 = "[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]";
        String s1 = "leetscode", s2 = "code";
        System.out.println( maximalRectangle(new char[][]{ {'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'} }) );
    }



    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][][] dp = new int[n+1][m+1][4];
        int max = 0;

        for (int i = 1; i<=n; i++)
            for (int j = 1; j<=m; j++) if (matrix[i-1][j-1] == '1') {
                dp[i][j][0] = dp[i-1][j][0] + 1;
                dp[i][j][1] = dp[i][j-1][1] + 1;
                if (dp[i-1][j-1][2] != 0 && dp[i-1][j][2] != 0 && dp[i][j-1][2] != 0) {
                    dp[i][j][2] = dp[i-1][j-1][2];
                    dp[i][j][3] = dp[i-1][j-1][3];
                } else {
                    dp[i][j][2] = i;
                    dp[i][j][3] = j;
                }
                max = Math.max( getMax(dp[i][j][0], dp[i][j][1], (i-dp[i][j][2]+1)*(j-dp[i][j][3]+1)) , max);
            }
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                System.out.print(dp[i][j][0]+" "+dp[i][j][1]+" "+dp[i][j][2]+" "+dp[i][j][3]+" | ");
            }
            System.out.println();
            System.out.println("------------------------");
        }

        return max;
    }

    private static int getMax(int a1, int a2, int a3) {
        return Math.max( Math.max(a1,a2), a3);
    }

    public static int minExtraChar(String s, String[] dictionary) {
        Set<String> wordlist = new HashSet<>(Arrays.asList(dictionary));

        int[] dp = new int[s.length()+1];
        dp[s.length()] = 0;

        for (int i = s.length()-1; i>=0; i--) {
            dp[i] = dp[i+1]+1;
            for (int j = i+1; j<=s.length(); j++) {
                if (wordlist.contains(s.substring(i, j))) dp[i] = Math.min(dp[i], dp[j]);
            }
        }

        return dp[0];
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        // [0] hold | [1] not hold
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[1][0] = Math.max(dp[0][0], -prices[1]);

        for (int i=2; i<prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-2][0]+prices[i], dp[i-1][1]);
        }

        return dp[prices.length][0];
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        Arrays.sort(coins);
        int[] dp = new int[amount+1];

        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;

        for (int i = 0; i<coins.length; i++)
            for (int j = coins[i]; j <= amount; j++) dp[j] = Math.min(dp[j], dp[j - coins[i]] +1 );

        if (dp[amount] == Integer.MAX_VALUE-1) return -1;
        return dp[amount];
    }

    public static int change(int amount, int[] coins) {
        Arrays.sort(coins);
        if (amount < coins[0]) return 0;

        int[] dp =  new int[amount+1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j <= amount; j++) dp[j] += dp[j - coins[i]];
        return dp[amount];
    }

}