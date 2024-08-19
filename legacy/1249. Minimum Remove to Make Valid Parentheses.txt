class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int left = 0,right = 0;
        for (char c : chars) {
            if (c == '(') left++;
            if (c == ')' && right<left) right++;
        }
        if (left < right) right=left; else left = right;
        for (char c : chars) {
            if (c != '(' && c!=')') sb.append(c);
            if (c == '(' && left > 0) {
                sb.append(c);
                left--;
            }
            if (c == ')' && right > 0 && left<right){
                sb.append(c);
                right--;
            }
        }
        return sb.toString();
    }
}
