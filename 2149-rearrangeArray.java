/**
     * @Description: 2149. Rearrange Array Elements by Sign
     * @Param: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
     * @return @return null
     * @author urey.lou
     * @create 2024/2/14
     **/

    public static int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0;
        int x = 0;
        int y = 1;
        for (i=0;i<nums.length;i++) {
            if (nums[i] > 0 ) {
                result[x] = nums[i];
                 x = x + 2 ;
            } else {
                result[y] = nums[i];
                y = y + 2 ;
            }
        }
        return result;
    }
