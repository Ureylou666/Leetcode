/**
     * @Description: 16. 3Sum Closest
     * @Param: https://leetcode.com/problems/3sum-closest/
     * @return @return null
     * @author urey.lou
     * @create 2024/2/14
     **/

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int k = 0;
        int i = 1;
        int j = 2;
        int gap;
        int min = Math.abs(nums[k] + nums[i] + nums[j] - target);
        int result = nums[k] + nums[i] + nums[j];
        for (k = 0;k <= nums.length-3; k++ ) {
            if ((k == 0) || (nums[k] != nums[k-1])) {
                i = k + 1;
                j = nums.length - 1;
                do {
                    gap = nums[k] + nums[i] + nums[j] - target;
                    if (Math.abs(gap) < min) {
                        min = Math.abs(gap) ;
                        result = nums[k] + nums[i] + nums[j];
                    }
                    if (gap > 0) {
                        j--;
                    }
                    if (gap < 0) {
                        i++;
                    }
                    if (gap == 0) {
                        return result;
                    }
                } while (i < j);
            }
        }
        return result;
    }
