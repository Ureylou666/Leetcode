import java.util.*;

class main {

    public static void main (String[] args) {
        // String grid1 = "[[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]]";
        // String grid2 = "[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]";
       // for (int n = 1; n <= 10; n++)
       //     for (int k= 1; k<=9; k++) System.out.println( "n="+n+" k="+k+"   "+countGoodIntegers(n,k) ) ;
        System.out.println(Arrays.toString(missingRolls(new int[]{4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3}, 2, 53)));
        // System.out.println( convertToString(51,3));
    }

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
}