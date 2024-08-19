class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> require = new HashMap<>();
        HashMap<String, Integer> check = new HashMap<>();
        int window = 0;
        for (String str : words) {
            window += str.length();
            require.put(str, require.getOrDefault(str, 0) + 1 );
            check.put(str,check.getOrDefault(str, 0));
        }
        for (int i=0;i<=s.length()-window;i++) {
            String str = s.substring(i,i+window);
            for (String key : check.keySet()) check.put(key, 0);
            int j=0;
            boolean h = true;
            while (j<str.length()) {
                if (!check.containsKey( str.substring(j,j+words[0].length()) )) {
                    h = false;
                    break;
                }
                check.put( str.substring(j,j+words[0].length()), check.get( str.substring(j,j+words[0].length())) + 1);
                j=j+words[0].length();
            }
            if (h) {
                for (String key : check.keySet()) {
                    if ( !require.get(key).equals(check.get(key) )) {
                        h = false;
                        break;
                    }
                }
            }
            if (h) answer.add(i);
        }
        return answer;
    }
}
