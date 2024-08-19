class Solution {
    public long countSubarrays(int[] nums, int k) {
        if (nums.length < k ) return 0;
        int left = 0, right = 0, max = 0, maxKey = 0, boundary = nums.length, count = 0;
        long result = 0;
        for (int num : nums) if (num > maxKey) maxKey= num;
        // step 1 : find first slide window
        for (right = 0; right< boundary; right++) {
            if (nums[right] == maxKey) count++;
            if (count == k) break;
        }
        result += boundary - right;
        // step 2 : sliding
        while (right < boundary) {
            if (nums[left] == maxKey) {
                count--;
            }
            left++;
            while (count < k && right < boundary) {
                right++;
                if (right == boundary) break;
                if (nums[right] == maxKey) count++;
                if (count == k) break;
            }
            if (count == k) result += boundary - right;
        }
        return result;
    }
}
------------------------------------------------------------------------------------------------------------------------------
class Solution {
    public long countSubarrays(int[] nums, int k) {
         if (nums.length < k ) return 0;
        int left = 0, right = 0, max = 0, maxKey = 0, boundary = nums.length, count = 0;
        long result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) map.put( num, map.getOrDefault(num, 0)+1);
        for (int key : map.keySet()) {
            if (map.get(key) > max ) {
                max = map.get(key);
                maxKey = key;
            }
        }
        map.clear();
        // step 1 : find first slide window
        for (right = 0; right< boundary; right++) {
            if (nums[right] == maxKey) count++;
            if (count == k) break;
        }
        result += boundary - right;
        // step 2 : sliding
        while (right < boundary) {
            if (nums[left] == maxKey) {
                count--;
            }
            left++;
            while (count < k && right < boundary) {
                right++;
                if (right == boundary) break;
                if (nums[right] == maxKey) count++;
                if (count == k) break;
            }
            if (count == k) result += boundary - right;
        }
        return result;
    }
}
------------------------------------------------------------------------------------------------------------------------------
class Solution {
    public long countSubarrays(int[] nums, int k) {
        if (nums.length < k ) return 0;
        int left = 0, right = 0, max = 0, maxKey = 0, boundary = nums.length;
        long result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        // step 1 : find first slide window
        while (max < k && right < boundary) {
            map.put( nums[right], map.getOrDefault(nums[right], 0)+1);
            if (map.get( nums[right]) > max ) {
                max = map.get( nums[right]);
                maxKey = nums[right];
            }
            if (max == k ) break;
            right++;
        }
        result += boundary - right;
        // step 2 : sliding
        while (right < boundary) {
            if (nums[left] == maxKey) {
                max--;
            }
            map.put(nums[left], map.get(nums[left])-1);
            left++;
            while (max < k && right < boundary) {
                right++;
                if (right == boundary) break;
                map.put( nums[right], map.getOrDefault(nums[right], 0)+1);
                if (map.get( nums[right]) > max ) {
                    max = map.get( nums[right]);
                    maxKey = nums[right];
                }
                if (max == k) break;
            }
            result += boundary - right;
        }
        return result;
    }
}
