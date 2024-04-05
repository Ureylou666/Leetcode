class Solution {
    public String makeGood(String s) {
        char[] chars = s.toCharArray();
        int x = 0,y = 0;
        boolean h = true;
        StringBuilder sb = new StringBuilder();
        while (h) {
            h = false;
            for (int i = 1; i < s.length(); i++) {
                if (Character.isUpperCase(chars[i])) x = (int) 'A' - (int) chars[i]; else x = (int) chars[i] - (int) 'a';
                if (Character.isUpperCase(chars[i-1])) y = (int) 'A' - (int) chars[i-1]; else y = (int) chars[i-1] - (int) 'a';
                if (x + y == 0 && !(chars[i] == 'a' && chars[i-1]=='a') && !(chars[i] == 'A' && chars[i-1]=='A')) {
                    chars[i] = '0';
                    chars[i-1] = '0';
                    h = true;
                }
            }
            sb.delete(0,sb.length());
            for (char c : chars) {
                if (c != '0') sb.append(c);
            }
            s = sb.toString();
            chars = s.toCharArray();
        }
        return s;
    }
}
