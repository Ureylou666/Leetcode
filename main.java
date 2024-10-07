import java.util.*;

class main {

    public static void main(String[] args) {
        // String grid2 = "[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]";
        System.out.println( minLength( "ABCDEFGH") );
    }

    public static int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            s = s.replaceAll("AB","");
            s = s.replaceAll("CD","");
        }
        return s.length();
    }


    static Set<Integer> bad = new HashSet<Integer>();
    public static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        bad.clear();
        Set<Integer> good = new HashSet<Integer>();
        List<Integer> result = new ArrayList<>();
        boolean[] check = new boolean[n];
        Arrays.fill(check, false);
        for (int i = 0; i<n; i++) map.put(i, new HashSet<>());
        for (int[] invocation : invocations) map.get(invocation[0]).add(invocation[1]);
        dfs(map, k, check);
        bad.add(k);
        for (int i =0; i<n; i++) if (!bad.contains(i)) good.add(i);
        for (int i : good)
            for (int x : map.get(i)) if (bad.contains(x)) bad.clear();
        for (int i =0; i<n; i++) if (!bad.contains(i)) result.add(i);
        return result;
    }

    private static void dfs(HashMap<Integer, Set<Integer>> map, int key, boolean[] check) {
        check[key] = true;
        for (Integer x : map.get(key)) {
            if (!check[x] && !bad.contains(x)) {
                dfs(map, x,check);
                bad.add(x);
            }
        }
    }

    public static boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        if (stones.length == 2) return true;
        List<Integer>[] dp = new ArrayList[stones.length];
        int[] farest = new int[stones.length];
        Arrays.fill(farest, 0);
        for (int i = 0; i<stones.length; i++) dp[i] = new ArrayList<>();
        dp[0].add(0); farest[0] = 1;
        dp[1].add(1); farest[1] = 3;
        for (int i=2; i<stones.length; i++)
            for (int j = 1; j < i; j++) if (farest[j] >= stones[i]){
                for (int k : dp[j])
                    if (stones[i] - stones[j] >= k-1 && stones[i] - stones[j] <= k+1 && !dp[i].contains(stones[i] - stones[j])) {
                        dp[i].add(stones[i] - stones[j]);
                        farest[i] = Math.max(stones[i] + stones[i] - stones[j] +1, farest[i]);
                    }
            }
        return !dp[stones.length - 1].isEmpty();
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