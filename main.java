import java.util.*;

class main {

    public static void main(String[] args) {
        // String grid2 = "[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]";
        System.out.println( maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1} ) );
    }

    public static int maxWidthRamp(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int res = 0, n = nums.length;
        for (int i = 0; i < n; ++i)
            if (s.empty() || nums[s.peek()] > nums[i])
                s.add(i);
        for (int i = n - 1; i > res; --i)
            while (!s.empty() && nums[s.peek()] <= nums[i])
                res = Math.max(res, i - s.pop());
        return res;
    }

    public static int findTargetSumWays(int[] nums, int target) {

    }

}