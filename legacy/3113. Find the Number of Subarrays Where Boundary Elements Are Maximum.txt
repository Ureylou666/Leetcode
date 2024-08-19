class Solution {
    public long numberOfSubarrays(int[] nums) {
        HashMap<Integer, List<Integer>> positions = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            positions.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        long count = 0;
        if (positions.size() == 1) {
            return ((long) nums.length * (nums.length + 1)) / 2;
        }
        for (List<Integer> posList : positions.values()) {
            if (posList.size() > 1) {
                int consecutive = 1;
                for (int i = 1; i < posList.size(); i++) {
                    int gap = posList.get(i) - posList.get(i - 1);
                    if (gap == 1) {
                        consecutive++;
                    } else {
                        count += calculatePairs(consecutive);
                        consecutive = 1;
                    }
                }
                count += calculatePairs(consecutive) + posList.size();
            } else {
                count++;
            }
        }
        return count;
    }
    private long calculatePairs(int n) {
        return ((long) n * (n - 1)) / 2;
    }
}
