class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        char[] sToCharArray = s.toCharArray();
        for (char c : sToCharArray) if (c == '1') count++;
        StringBuilder result = new StringBuilder();
        for (int i=0;i<count-1;i++) result.append('1');
        for (int i=0;i<s.length()-count;i++) result.append('0');
        return result.toString() +'1';
    }
}
