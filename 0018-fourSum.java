/**
     * @Description: 18. 4Sum
     * @Param: https://leetcode.com/problems/4sum/
     * @return @return null
     * @author urey.lou
     * @create 2024/2/15
     **/
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        BigInteger sum;
        Arrays.sort(nums);
        for (int i=0; i < nums.length - 3; i++) {
            for (int j = i+1; j < nums.length - 2; j++ ) {
                int x = j + 1;
                int y = nums.length - 1 ;
                while (x < y) {
                    sum = BigInteger.valueOf(nums[i]).add(BigInteger.valueOf(nums[j])).add(BigInteger.valueOf(nums[x])).add(BigInteger.valueOf(nums[y]));
                    int gap = sum.compareTo(BigInteger.valueOf(target));
                    if (gap < 0) {
                        x++;
                    }
                    if (gap > 0) {
                        y--;
                    }
                    if (gap == 0) {
                        if (!result.contains(List.of(nums[i], nums[j], nums[x], nums[y]))) {
                            result.add(List.of(nums[i], nums[j], nums[x], nums[y]));
                        }
                        x++;
                        y--;
                    }
                }
            }
        }
        return result;
    }
