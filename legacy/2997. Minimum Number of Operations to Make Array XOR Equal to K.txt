class Solution {
    public int minOperations(int[] nums, int k) {
        int result = 0,p ,q;
        int origin = nums[0];
        for (int i=1;i<nums.length;i++) origin = origin^nums[i];
        List<Integer> originToBinary, kToBinary;
        originToBinary = numsToBinary(origin);
        kToBinary = numsToBinary(k);
        int max = Math.max(originToBinary.size(), kToBinary.size());
        for (int i =0 ; i<max;i++) {
            if (i>=originToBinary.size()) p = 0; else p = originToBinary.get(i);
            if (i>=kToBinary.size()) q = 0; else q = kToBinary.get(i);
            if (p!=q) result++;
        }
        return result;
    }

    private List<Integer> numsToBinary(int n) {
        List<Integer> result = new ArrayList<>();
        while (n>0) {
            result.add(n % 2);
            n = n /2 ;
        }
        return result;
    }
}
