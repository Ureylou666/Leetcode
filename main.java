import java.util.*;

class main {

    public static void main (String[] args) {
        // String grid1 = "[[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]]";
        // String grid2 = "[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]";
        //System.out.println( countGoodIntegers(1,1));
        System.out.println( chalkReplacer(Usecase, 25)) ;
    }

    public static int generateKey(int num1, int num2, int num3) {
        int[][] result = new int[4][3];
        for (int i = 3; i>=0; i--) {
            result[i][0] = num1 % 10;
            num1 = num1 / 10;
        }
        for (int i = 3; i>=0; i--) {
            result[i][1] = num2 % 10;
            num2 = num2 / 10;
        }
        for (int i = 3; i>=0; i--) {
            result[i][2] = num3 % 10;
            num3 = num3 / 10;
        }
        Arrays.sort(result[0]);
        Arrays.sort(result[1]);
        Arrays.sort(result[2]);
        Arrays.sort(result[3]);
        return 1000*result[0][0] + 100*result[1][0] + 10*result[2][0] + result[3][0];

    }

    public static String stringHash(String s, int k) {
        char[] chars = s.toCharArray();
        int temp = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length()/k; i++){
            temp = 0;
            for (int j = 0; j < k; j++) {
                temp = temp + chars[i*k+j] - 'a';
            }
            temp = temp %26;
            sb.append( Character.toChars('a' +temp));
        }
        return sb.toString();
    }

    //public static long countGoodIntegers(int n, int k) {
    //    int[] palindromic = new int[]{1,11,101,1001,10001,100001,1000001,10000001,100000001};
    //    int[][] test = new int[][]{{1,10},{10,99},{100,999},{1000,9999},{10000,99999}};
    //    long result = 0, temp = 0;
    //    if (n==1) return 9/k;
    //    for (int i = test[n/2][0]; i<=test[n/2][1]; i++ ) {
    //        if ( i % k ==0 || palindromic[i] % k == 0 || (long)i*palindromic[i] % k == 0 ) {
    //            temp = (long) i*palindromic[i];
    //            result = result + count(temp , k);
    //        }
    //    }
    //    // total par
    //    for (int i=0; i<n/2+n%2; i++)
    //    return result;
    //}

    public static int count(long n, int k) {
        int[] jiechen = new int[]{1,2,6,24,120,720,5040,40320,362880};
        HashMap<Long, Integer> map = new HashMap<>();
        while (n>0) {
            map.put(n%10, map.getOrDefault(n%10,0)+1);
            n = n /10;
        }
        for (long key : map.keySet()) {
            jiechen[k-1] = jiechen[k-1] / jiechen[ map.get(key) -1];
        }
        return jiechen[k-1];
    }

    public static boolean checkTwoChessboards(String coordinate1, String coordinate2) {
       int x =  (coordinate1.charAt(0) - 'a') % 2 +  (coordinate1.charAt(1) - '1') % 2;
       int y =  (coordinate2.charAt(0) - 'a') % 2 +  (coordinate2.charAt(1) - '1') % 2;
       return (x % 2 == y % 2);
    }

    public static int[] resultsArray(int[][] queries, int k) {
        int[] result = new int[queries.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i = 0; i < queries.length; i++) {
            int length = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);

            if (minHeap.size() < k) {
                minHeap.offer(length);
            } else if (length < minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(length);
            }

            if (minHeap.size() == k) {
                result[i] = minHeap.peek();
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

   //public int maxScore(List<List<Integer>> grid) {

   //}

    ///**
    //* @Description: https://leetcode.com/problems/path-with-maximum-probability/
    //* @Author: Urey Lou
    //* @Date: 2024-08-26
    //* @Param: [n, edges, succProb, start_node, end_node]
    //* @return: double
    //*/
    //public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
    //
    //}

}