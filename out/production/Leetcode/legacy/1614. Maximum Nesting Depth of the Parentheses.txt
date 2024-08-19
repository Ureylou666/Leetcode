class Solution {
    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int k = 0, max = 0;
        for (char c : chars) {
            if (c == '(' ) k++;
            if (c == ')') {
                if (k > max) max = k;
                k--;
            }
        }
        return max;
    }
}
