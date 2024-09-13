import java.util.*;

class main {

    public static void main (String[] args) {
        // String grid1 = "[[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]]";
        // String grid2 = "[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]";
       // for (int n = 1; n <= 10; n++)
       //     for (int k= 1; k<=9; k++) System.out.println( "n="+n+" k="+k+"   "+countGoodIntegers(n,k) ) ;
        System.out.println(Arrays.toString(xorQueries( new int[]{1,3,4,8}, new int[][]{{0,1}, {1,2},{0,3}, {3,3}})));
        // System.out.println( convertToString(51,3));
    }

    /** 
    * @Description: https://leetcode.com/problems/spiral-matrix-iv
    * @Author: Urey Lou
    * @Date: 2024-09-13
    * @Param: [m, n, head]
    * @return: int[][]
    */
    public static int[][] spiralMatrix(int m, int n, ListNode head) {

    }

    /**
     * @Description: https://leetcode.com/problems/split-linked-list-in-parts/?envType=daily-question&envId=2024-09-08
     * @Author: Urey Lou
     * @Date: 2024-09-07
     * @Param: [head, k]
     * @return: ListNode[]
     */
    public static ListNode[] splitListToParts(ListNode head, int k) {
        int total = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        while (head != null) {
            head = head.next;
            total++;
        }
        ListNode[] result = new ListNode[k];
        if (total <= k) {
            for (int i = 0; i<total; i++) {
                ListNode temp = new ListNode(dummy.next.val);
                dummy = dummy.next;
                result[i] = temp;
            }
            return result;
        }
        result[0] = dummy;
        for (int i = 0; i<k + total % k; i++) {
            dummy = dummy.next;
        }
        result[1] = dummy.next;
        dummy = null;
        for (int i = 1; i< total / k; i++){
            for (int j=0; j<k; j++) {
                result[i] = new ListNode(dummy.val);
                result[i] = result[i].next;
                dummy = dummy.next;
            }
            result[i].next = null;
        }

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
}