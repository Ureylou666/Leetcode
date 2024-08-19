class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i=0;i<nums.length;i++) nums[i]=nums[i] * nums[i];
        return Arrays.stream(nums).sorted().toArray();
    }
}
