class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        if (target > nums[nums.length-1]) return nums.length;
        int left = 0, right = nums.length-1, mid;
        while (left < right) {
            mid = (right + left) / 2 ;
            if (nums[mid] > target) right = mid-1; else if (nums[mid] == target) return mid; else left = mid+1;
        }
        if (nums[left] < target) left++;
        return left;
    }
}
