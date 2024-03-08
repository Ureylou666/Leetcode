class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        Arrays.fill(count,0);
        for (int i=0;i<nums.length;i++) count[nums[i]]++;
        count = Arrays.stream(count).sorted().toArray();
        int max = count[100];
        int i = 100;
        int result = 0;
        while (count[i] == max) {
            result = result+count[i];
            i--;
        }
        return result;
    }
}
//--------------------------------------------------------------------------
class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num,0)+1);
        int count = 0;
        int max = 0;
        for (int freq : map.values()) max = Math.max(max, freq);
        for (int freq : map.values()) if (freq == max) count += freq;
        return count;
    }
}
