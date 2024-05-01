class Solution {
    public String reversePrefix(String word, char ch) {
        Stack<Character> str = new Stack<>();
        char[] chars = word.toCharArray();
        int i = 0;
        for (char c : chars) {
            str.push(c);
            if (c == ch) break;
        }
        i = str.size();
        if (i == word.length() && ch != str.peek()) return word;
        StringBuilder sb = new StringBuilder();
        while (!str.isEmpty()) sb.append(str.pop());
        while (i<chars.length) sb.append(chars[i++]);
        return sb.toString();
    }
}
