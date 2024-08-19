class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0 ;
        int temp;
        int j;
        for (int i=0;i<nums.length;i++) {
            temp = nums[i];
            j = i;
            do {
                if (temp < k) {
                    result++;
                    j++;
                }
                if (j< nums.length) temp = temp * nums[j];
            } while (temp < k && j < nums.length);
        }
        return result;
    }
}
