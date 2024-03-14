class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0;
        for (int i =0 ; i< nums.length; i++) {
            for (int j = i ; j< nums.length; j++) {
                int sum = 0;
                for (int k=i; k<=j; k++) sum += nums[k];
                if (sum == goal) result++;
            }
        }
        return result;
    }
}

---------------------------------------------------------------------------------------------------
    
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0;
        int[] prefixSum = new int[nums.length+1];
        prefixSum[0]=0;
        for (int i=0; i < nums.length; i++) prefixSum[i+1] += prefixSum[i] +nums[i];
        for (int i = 1 ; i< nums.length+1; i++) {
            for (int j = 0; j<i;j++) if (prefixSum[i]- prefixSum[j] == goal) result++;
        }
        return result;
    }
}
