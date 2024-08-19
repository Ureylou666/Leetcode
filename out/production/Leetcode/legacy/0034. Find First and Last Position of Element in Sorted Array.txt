public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};
        if (nums.length == 1) {
            if (nums[0] == target) return new int[]{1,1}; else return new int[]{-1,-1};
        }
        if ( target < nums[0] || target > nums[nums.length-1] ) return new int[]{-1,-1};
        int left, right, mid, start, end;
        left = 0;
        right = nums.length-1;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) right = mid - 1; else left = mid + 1;
        }
        end = right;
        left = 0;
        right = nums.length-1;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1; else right = mid - 1;
        }
        start = left;
        if (start != nums.length-1 && nums[start] != target && nums[start+1] != target) return new int[]{-1,-1};
        if (end != 0 && nums[end] != target && nums[end-1] != target) return new int[]{-1,-1};
        if (nums[start] < target && nums[start+1] == target) start++;
        if (nums[end] > target && nums[end-1] == target) end--;
        return new int[]{start, end};
    }
