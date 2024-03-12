/**
     * @Description: 11. Container With Most Water
     * @Param: https://leetcode.com/problems/container-with-most-water/
     * @return @return null
     * @author urey.lou
     * @create 2024/2/12
     **/

    private static int No_0011(int[] height) {
        int i = 0;
        int j = height.length -1;
        if (j == 1) {
            return Math.min(height[i], height[j]);
        }
        int max = 0;

        do {
            if ( Math.min(height[i], height[j]) * (j-i) > max ) {
                max = Math.min(height[i], height[j]) * (j-i);
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        } while (i < j);
        return max;
    }
