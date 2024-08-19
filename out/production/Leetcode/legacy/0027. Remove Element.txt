class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i : nums) {
            if (i != val) {
                nums[j] = i;
                j++;
            }
        }
        return j;
    }
}
