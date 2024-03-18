class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) sum = sum + encrypt(num);
        return sum;
    }
    
    public static int encrypt(int num) {
        int max = 0;
        int i = 0;
        do {
            if (num % 10 > max) max = num % 10;
            num = num / 10;
            i = i*10+1;
        } while (num > 0);
        return (max * i);
    }
}
