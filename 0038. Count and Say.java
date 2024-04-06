class Solution {
    public String countAndSay(int n) {
       if (n == 1) return "1";
        int current, count = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> newList = new ArrayList<>();
        for (int k = 1; k < n; k++) {
            current = 0;
            newList.clear();
            for (int c : list) {
                if (c != current) {
                    if (current != 0 ){
                        newList.add(count);
                        newList.add(current);
                    }
                    current = c;
                    count = 1;
                } else {
                    count++;
                }
            }
            newList.add(count);
            newList.add(current);
            list.clear();
            for (int c:newList) list.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int c:list) sb.append(c);
        return sb.toString();
    }
}
