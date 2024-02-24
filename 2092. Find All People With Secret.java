class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
    List<Integer> result = new ArrayList<>();
        boolean[] check = new boolean[n];
        Arrays.fill(check,false);
        check[0]=true;
        check[firstPerson]=true;
        PriorityQueue<int[]> queue = new PriorityQueue<>(((a,b) -> {
            if (a[2] != b[2]) {
                return Integer.compare(a[2], b[2]); // Compare start times
            } else {
                if (a[0]!=b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            }
        }));
        for (int[] meeting:meetings) {
            queue.offer(meeting);
        }
        int[] meeting = new int[3];
        while (!queue.isEmpty()) {
            meeting = queue.poll();
            if (check[meeting[0]] || check[meeting[1]]) {
                check[meeting[0]] = true;
                check[meeting[1]] = true;
            }
        }
        for (int i=0; i < n; i++) {
            if (check[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
