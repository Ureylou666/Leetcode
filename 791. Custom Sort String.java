class Solution {
    public String customSortString(String order, String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char[] char1 = order.toCharArray();
        for (char chr : char1) map.put(chr, 0);
        char[] char2 = s.toCharArray();
        char[] temp = new char[s.length()];
        int notInOrder = 0;
        for (char chr : char2) {
            if (map.containsKey(chr)) {
               map.put(chr, map.get(chr)+1);
            } else {
                temp[notInOrder] = chr;
                notInOrder++;
            }
        }
        char[] result = new char[s.length()];
        int k = 0;
        for (Character c : map.keySet()) {
            for (int i=0;i<map.get(c);i++) {
                result[k] = c;
                k++;
            }
        }
        for (int i=k;i<s.length();i++) result[i] = temp[i-k];
        return new String(result);
    }
}
