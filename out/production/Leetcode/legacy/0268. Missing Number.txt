class Solution {
    public int missingNumber(int[] nums) {
        int i =0 ;
        boolean[] check = new boolean[nums.length+1];
        Arrays.fill(check, false);
        for (i=0; i< nums.length; i++){
            check[nums[i]] = true;
        }
        i=0;
        while (check[i]) {
            i++;
        }
        return i;
    }
}
