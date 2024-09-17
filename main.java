import java.util.*;

class main {

    public static void main (String[] args) {
        // String grid1 = "[[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]]";
        // String grid2 = "[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]";
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(0,1,0,0,0));
        grid.add(Arrays.asList(0,1,0,1,0));
        grid.add(Arrays.asList(0,0,0,1,0));
        System.out.println(Arrays.toString(uncommonFromSentences("this apple is sweet", "this apple is sour")));
    }


    public static int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i:nums) map.put(i, map.getOrDefault(i, 0)+1);
        int[] result = new int[2];
        int s = 0;
        for (int key : map.keySet()) if (map.get(key) == 2) {
            result[s] = key;
            s++;
            if (s==2) return result;
        }
        return result;
    }

    public static int minConcatToFormTarget(String[] words, String target) {
        int n = target.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (String word : words) {
                int len = word.length();
                if (i + len <= n && target.substring(i, i + len).equals(word)) {
                    dp[i + len] = Math.min(dp[i + len], dp[i] + 1);
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    public long maxScore(int[] a, int[] b) {
        int n = b.length;
        if (n < 4) {
            throw new IllegalArgumentException("Array b must have at least 4 elements.");
        }

        // Initialize dp arrays to store maximum scores
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int[] dp3 = new int[n];
        int[] dp4 = new int[n];

        // Calculate dp1: Maximum value of a[0] * b[i] for i in [0, n-1]
        dp1[0] = a[0] * b[0];
        for (int i = 1; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 1], a[0] * b[i]);
        }

        // Calculate dp2: Maximum value of a[0] * b[i0] + a[1] * b[i1] for i0 < i1
        dp2[1] = dp1[0] + a[1] * b[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp1[i - 1] + a[1] * b[i]);
        }

        // Calculate dp3: Maximum value of a[0] * b[i0] + a[1] * b[i1] + a[2] * b[i2] for i0 < i1 < i2
        dp3[2] = dp2[1] + a[2] * b[2];
        for (int i = 3; i < n; i++) {
            dp3[i] = Math.max(dp3[i - 1], dp2[i - 1] + a[2] * b[i]);
        }

        // Calculate dp4: Maximum value of a[0] * b[i0] + a[1] * b[i1] + a[2] * b[i2] + a[3] * b[i3] for i0 < i1 < i2 < i3
        dp4[3] = dp3[2] + a[3] * b[3];
        for (int i = 4; i < n; i++) {
            dp4[i] = Math.max(dp4[i - 1], dp3[i - 1] + a[3] * b[i]);
        }

        // The final answer is the maximum value of dp4
        return dp4[n - 1];
    }

    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> result = new ArrayList<>();
        for (int i=1;i<height.length;i++) if (height[i-1]>threshold) result.add(i);
        return result;
    }

    private static int[] dx = {1, -1, 0, 0}; // Four directions for x movement
    private static int[] dy = {0, 0, 1, -1}; // Four directions for y movement

    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] map = new int[m][n];
        int[][] minCost = new int[m][n];

        // Initialize map and minCost
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = grid.get(i).get(j);
                minCost[i][j] = Integer.MAX_VALUE; // Initialize min cost
            }
        }

        // BFS to find the minimum path cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // Min-heap [x, y, cost]
        pq.offer(new int[]{0, 0, map[0][0]});
        minCost[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], cost = curr[2];

            // If we reach the bottom-right corner, return the result
            if (x == m - 1 && y == n - 1) {
                return health > cost;
            }

            // Traverse four directions
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                    int newCost = cost + map[newX][newY];
                    if (newCost < minCost[newX][newY]) {
                        minCost[newX][newY] = newCost;
                        pq.offer(new int[]{newX, newY, newCost});
                    }
                }
            }
        }

        return false; // No valid path found
    }


    //------------------------------------------------------------------------------------------

    /** 
    * @Description: https://leetcode.com/problems/find-the-count-of-good-integers/
    * @Author: Urey Lou
    * @Date: 2024-09-04
    * @Param: [n, k]
    * @return: long
    */
    public static long countGoodIntegers(int n, int k) {
        HashMap<String, Integer> checkedNum = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        int[][] bruteforce = new int[][]{{1,9},{10,99},{100,999},{1000,9999},{10000,99999},{100000,999999}};
        int num = 0;
        String temp = "";
        long result = 0;
        for (int i=bruteforce[n/2 + n%2-1][0]; i<=bruteforce[n/2 + n%2 -1][1];i++) {
            list1.clear();
            list1 = converToList(i);
            for (int q : list1) {
                num = convertInt(q, n);
                if (num % k ==0) {
                    temp = convertToString(num);
                    if (!checkedNum.containsKey(temp)) {
                        result = result + counting(num);
                        checkedNum.put(temp, 1);
                    }
                }
            }
        }
        return result;
    }

    private static long counting(int n) {
        int[] jiechen = new int[]{1,2,6,24,120,720,5040,40320,362880,3628800,39916800};
        HashMap<Integer,Integer> map = new HashMap<>();
        int k = String.valueOf(n).length();
        long zeroCase = 0;
        while (n>0) {
            map.put(n%10, map.getOrDefault(n % 10, 0)+1);
            n = n / 10;
        }
        long result = jiechen[k-1];
        for (int i : map.keySet()) {
            result = result / jiechen[map.get(i) - 1];
        }
        if (map.containsKey(0)) {
            zeroCase = jiechen[k-2];
            map.put(0, map.get(0)-1);
            for (int i : map.keySet()) if (map.get(i) > 0) {
                zeroCase = zeroCase / jiechen[map.get(i) - 1];
            }
        }
        return result - zeroCase;
    }

    private static int convertInt(int n, int k) {
        int[] palindromeaMutilple = new int[]{1,10,100,1000,10000,100000};
        int result = n * palindromeaMutilple[k/2];
        int i = k/2 + k%2 -1;
        if (k % 2 == 1) {
            n = n/10;
            i--;
        }
        while (n>0) {
            result = result + palindromeaMutilple[i] * (n % 10);
            n = n /10;
            i--;
        }
        return result;
    }

    private static String convertToString(int n) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[10];
        Arrays.fill(count,0);
        while (n>0) {
            count[n % 10]++;
            n = n / 10;
        }
        for (int i: count) sb.append(i);
        return sb.toString();
    }

    private static List<Integer> converToList(int n) {
        List<Integer> result = new ArrayList<>();
        String numStr = String.valueOf(n);
        permute("",numStr, result);
        return result;
    }

    private static void permute(String prefix, String remaining, List<Integer> result) {
        int len = remaining.length();
        int temp = 0;
        if (!prefix.isEmpty()) temp = Integer.parseInt(prefix);
        if (len == 0) {
            if (prefix.charAt(0) != '0' && !result.contains(temp)) result.add(temp);
        }  else {
            for (int i = 0; i < len; i++) {
                permute(prefix + remaining.charAt(i),remaining.substring(0, i) + remaining.substring(i + 1) ,result);
            }
        }
    }

    /**
     * @Description: https://leetcode.com/problems/split-linked-list-in-parts/?envType=daily-question&envId=2024-09-08
     * @Author: Urey Lou
     * @Date: 2024-09-07
     * @Param: [head, k]
     * @return: ListNode[]
     */
    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode[] result = new ListNode[k];
        dummy.next = head;
        int total = 0;
        while (dummy != null) {
            dummy= dummy.next;
            total++;
        }
        // total <= k
        if (total <= k) {
            for (int i = 0; i<total-1; i++) {
                result[i] = new ListNode(head.val);
                head = head.next;
            }
            return result;
        }
        // total > k
        int x = total / k + total % k;
        ListNode temp = new ListNode(head.val);
        head = head.next;
        for (int i = 1; i < x; i++) {
            temp.next = new ListNode(head.val);
            head = head.next;
            temp=temp.next;
        }
        result[0] = new ListNode();
        result[0].next = temp;
        result[0] = result[0].next;
        return result;

    }

    public static String convertDateToBinary(String date) {
        int year, month , day;
        year = Integer.parseInt(date.substring(0, 4));
        month = Integer.parseInt( date.substring(5,7));
        day = Integer.parseInt( date.substring(8,10));
        return convert(year)+"-"+convert(month)+"-"+convert(day);
    }

    private static String convert(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n %2);
            n = n/2;
        }
        return sb.reverse().toString();
    }



}