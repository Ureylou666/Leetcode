class Solution {
    public int firstMissingPositive(int[] nums) {
        int temp;
        for(int j=0;j<2;j++){
            for (int i=0;i<nums.length;i++) {
                if (nums[i] > 0 && nums[i]<=nums.length) {
                    if (nums[i] != nums[nums[i]-1]) {
                        temp = nums[nums[i]-1];
                        nums[nums[i]-1] = nums[i];
                        nums[i] = temp;
                    } else nums[i] = i+1;
                } else nums[i] = -1;
            }
        }
        for (int i=0;i<nums.length;i++) if (nums[i] != i+1) return i+1;
        return nums.length+1;
    }
}
