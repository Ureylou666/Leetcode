class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> star = new Stack<>();
        int x, y;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') stack.push(i);
            if (chars[i]  == '*') star.push(i);
            if (chars[i]  == ')') {
                if (!stack.isEmpty()) stack.pop(); else if (!star.isEmpty()) star.pop(); else return false;
            }
        }
        while(!stack.isEmpty()) {
            x = stack.pop();
            if (!star.isEmpty()) y = star.pop(); else return false;
            if (x > y) return false;
        }
        return true;
    }
}
