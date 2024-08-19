class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        if (nums.length <= k) return nums.length;
        int left = 0,right = 0,max = 0,result = 0, maxKey = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        // step 1: find the first slide window
        while (max <= k && right<nums.length) {
            map.put( nums[right], map.getOrDefault(nums[right],0)+1);
            if (map.get(nums[right]) > max ) {
                max = map.get(nums[right]);
                maxKey = nums[right];
            }
            if (max > k) break;
            right++;
        }
        if (right-left > result) result = right - left;
        // step 2: start sliding
        for (left = 1; left < nums.length;left++) {
            map.put( nums[left-1], map.get(nums[left-1])-1);
            if (nums[left-1] == maxKey) max--;
            while (max <= k && right<nums.length) {
                right++;
                if (right == nums.length) break;
                map.put( nums[right], map.getOrDefault(nums[right],0)+1);
                if (map.get(nums[right]) > max ) {
                    max = map.get(nums[right]);
                    maxKey = nums[right];
                }
                if (max > k) break;
            }
            if (right-left > result) result = right - left;
        }
        return result;
    }
}2958. Length of Longest Subarray With at Most K Frequency
