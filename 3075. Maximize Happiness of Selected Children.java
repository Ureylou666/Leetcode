class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        happiness = Arrays.stream(happiness).sorted().toArray();
        int i = happiness.length-1;
        long result = happiness[i];
        i--;
        int j = 1;
        while (j < k) {
            result = result + happiness[i];
            if (happiness[i] > j) result = result - j; else result = result - happiness[i];
            i--;
            j++;
        }
        return result;
    }
}
