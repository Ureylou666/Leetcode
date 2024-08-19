class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        for (int i:nums) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int result = 0;
        for (int i: map.keySet()) {
            nums[result] = i;
            result++;
        }
        return result;
    }
}
