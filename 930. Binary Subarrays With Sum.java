class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0;
        for (int i =0 ; i< nums.length; i++) {
            for (int j = i ; j< nums.length; j++) {
                int sum = 0;
                for (int k=i; k<=j; k++) sum += nums[k];
                if (sum == goal) result++;
            }
        }
        return result;
    }
}
