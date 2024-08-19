class Solution {
    public int longestValidParentheses(String s) {
        int[] check = new int[s.length()];
        char[] chars = s.toCharArray();
        Stack<Integer> left = new Stack<>();
        for (int i=0; i<chars.length;i++) {
            if (chars[i] == '(' ) left.push(i);
            if (chars[i] == ')') {
                if (left.size()>0) {
                    check[left.pop()] = 1;
                    check[i] = 1;
                }
            }
        }
        int i = 0;
        int max = 0;
        int count = 0;
        while (i<check.length) {
            if (check[i] == 1) {
                count = 0 ;
                while ((i< check.length) && (check[i]==1)) {
                    i++;
                    count++;
                }
                if (count > max) {
                    max = count;
                }
            }
            i++;
        }
        return max;
    }
}
