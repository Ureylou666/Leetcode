import java.util.*;

class main {

    public static void main(String[] args) {
        // String grid2 = "[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]";
        String s = "leet code";
        System.out.println( rob( new int[]{1,7,9,2}) );
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        if (s1.isEmpty()) return s3.equals(s2);
        if (s2.isEmpty()) return s3.equals(s1);

        int n = s1.length() , m = s2.length();
        boolean[] dp = new boolean[m+1];

        dp[0] = true;
        for (int i = 1; i<=m; i++) dp[i] = dp[i-1] && ( s2.charAt(i-1) == s3.charAt(i-1));

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                dp[i] = ( dp[i] && (s1.charAt(i-1) == s3.charAt(i+j-1)) ) || ( dp[i-1] && (s2.charAt(j-1) == s3.charAt(i+j-1))  );
        }

        return dp[n];
    }



    /*
    public static boolean isInterleave(String s1, String s2, String s3) {
        int i = 0, j = 0, n = 0;
        boolean h1 = false, h2 = false;
        if (s3.isEmpty()) if (s1.isEmpty() || s2.isEmpty()) return false;
        else return true;
        if ((s1.isEmpty() && s2.equals(s3)) || (s2.isEmpty() && s1.equals(s3))) return true;
        if (s1.isEmpty() || s2.isEmpty()) return false;
        if (s3.charAt(0) == s1.charAt(0)) {
            h1 = true;
            h2 = false;
        } else {
            h1 = false;
            h2 = false;
        }
        while (n < s3.length() && (h1 ^ h2)) {
            if (i < s1.length() && s3.charAt(n) == s1.charAt(i)) h1 = !h1;
            while (i < s1.length() && s3.charAt(n) == s1.charAt(i)) {
                n++;
                i++;
            }
            if (n < s3.length() && j < s2.charAt(j) && s3.charAt(n) == s2.charAt(j)) h2 = !h2;
            while (j < s2.length() && s3.charAt(n) == s2.charAt(j)) {
                n++;
                j++;
            }
        }
        return (i == s1.length() && j == s2.length());
    }
    */

}