class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        Character before, after;
        for (int i = 0; i< s.length(); i++) {
            before = s.charAt(i);
            after = t.charAt(i);
            if (map.containsKey(before)) {
                if (map.get(before) != after) return false;
            } else {
                if (map.containsValue(after)) return false;
                map.put(before,after);
            }
        }
        return true;
    }
}
