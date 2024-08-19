class Solution {
    public int maximumPrimeDifference(int[] nums) {
        List<Integer> primeNum = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
        int max = nums.length-1, min = 0;
        while (!primeNum.contains(nums[min])) min++;
        while (!primeNum.contains(nums[max])) max--;
        return Math.abs(max-min);
    }
}
