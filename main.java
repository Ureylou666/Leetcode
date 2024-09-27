import java.util.*;

class main {

    public static void main (String[] args) {
        // String grid1 = "[[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]]";
        // String grid2 = "[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]";
        System.out.println( isInterleave("a", "b","a"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int i = 0, j = 0, n = 0;
        boolean h1 = false, h2 = false;
        if (s3.isEmpty()) if (s1.isEmpty() || s2.isEmpty()) return false; else return true;
        if ((s1.isEmpty() && s2.equals(s3)) || (s2.isEmpty() && s1.equals(s3)) ) return true;
        if (s1.isEmpty() || s2.isEmpty()) return false;
        if (s3.charAt(0) == s1.charAt(0)) {
            h1 = true;
            h2 = false;
        } else {
            h1 = false;
            h2 = false;
        }
        while (n < s3.length() && (h1 ^ h2)) {
            if (i < s1.length() && s3.charAt(n) == s1.charAt(i))  h1 = !h1;
            while (i < s1.length() && s3.charAt(n) == s1.charAt(i)) {
                n++;
                i++;
            }
            if (n < s3.length() && j < s2.charAt(j) && s3.charAt(n) == s2.charAt(j))  h2 = !h2;
            while (j < s2.length() && s3.charAt(n) == s2.charAt(j)) {
                n++;
                j++;
            }
        }
        return (i == s1.length() && j== s2.length());
    }

    public static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) dp[i][0] = 1;
        for (int i = 1; i <= n; i++) dp[0][i] = 0;

        for (int i= 1; i <= m; i++)
            for (int j = 1; j<= n; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + dp[i-1][j] ; else dp[i][j] = dp[i-1][j];
            }
        return dp[m][n];
    }

}