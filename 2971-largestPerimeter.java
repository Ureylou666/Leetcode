/**
     * @Description: 2971. Find Polygon With the Largest Perimeter
     * @Param: https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/description/
     * @return @return null
     * @author urey.lou
     * @create 2024/2/15
     **/
    public static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int i ;
        for ( i = 0 ; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        i = nums.length-1;
        while (( sum - nums[i] <= nums[i] ) && (i > 1) ){
            sum = sum - nums[i];
            i--;
        }
        if ( i < 2 ) {
            return -1;
        } else {
            return sum;
        }
    }
