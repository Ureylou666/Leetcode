/**
     * @Description: 15. 3Sum
     * @Param: https://leetcode.com/problems/3sum/description/
     * @return @return null
     * @author urey.lou
     * @create 2024/2/14
     **/

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int k ;
        int i ;
        int j ;
        int sum;
        for (k = 0;(nums[k] <= 0) && (k <= nums.length-3); k++ ) {
            if ((k == 0) || (nums[k] != nums[k-1])) {
                i = k + 1;
                j = nums.length - 1;
                do {
                    sum = nums[k] + nums[i] + nums[j];
                    if (sum > 0) {
                        do {
                            j--;
                        } while ( (nums[j] == nums[j+1]) && (j>=i) );
                    }
                    if (sum < 0) {
                        do {
                            i++;
                        } while ((nums[i] == nums[i-1]) && (i <= j) && (i < nums.length-1)) ;
                    }
                    if (sum == 0) {
                        result.add(List.of(nums[k],nums[i],nums[j]));
                        do {
                            j--;
                        } while ( (nums[j] == nums[j+1]) && (j>=i) );
                        do {
                            i++;
                        } while ((nums[i] == nums[i-1]) && (i <= j) && (i < nums.length-1)) ;
                    }
                } while (i < j);
            }
        }
        return result;
    }
