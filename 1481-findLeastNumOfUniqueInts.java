/**
     * @Description: 1481. Least Number of Unique Integers after K Removals
     * @Param: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
     * @return @return null
     * @author urey.lou
     * @create 2024/2/16
     **/
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        int i = 0 ;
        int result = 0;
        int[] collect = new int[arr.length+1];
        while (i < arr.length) {
            int sum = 0;
            do {
                sum++;
                i++;
            } while ((i<arr.length) && (arr[i] == arr[i-1]));
            collect[sum] = collect[sum] + 1;
            result ++;
        }
        if (collect[1] >= k) {
            return result - k;
        }
        k = k - collect[1];
        result = result - collect[1];
        for (i=2; i< arr.length; i++) {
            if (collect[i] > 0) {
                if ( k >= collect[i] * i) {
                    k = k - collect[i] * i;
                    result = result -collect[i];
                } else {
                    return result - k / i;
                }
            }
        }
        return result;
    }
