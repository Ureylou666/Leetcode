import java.util.*;

class main {

    public static void main(String[] args) {
        // String grid2 = "[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]";
        System.out.println( countNumbersWithUniqueDigits( 4));
    }

    public static int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        if (n == 0) return 1;
        dp[1] = 10;
        for (int i = 2; i<=n ; i++) {
            dp[i] = dp[i-1] * (10 - i );
            for (int j = 0; j < i; j++) dp[i] = dp[i] + dp[j];
        }
        return dp[n];
    }

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; else return (a[1] - b[1]);
        });
        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp ,1);
        for (int i = 1; i<n; i++)
            for (int j = 0; j < i; j++) if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) dp[i] = Math.max(dp[i], dp[j] +1);
        int result = 0;
        for (int i:dp) result = Math.max(result, i);
        return result;
    }
}