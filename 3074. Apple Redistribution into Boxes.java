class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int count = 0;
        for (int i=0; i< apple.length;i++) count = count + apple[i];
        capacity = Arrays.stream(capacity).sorted().toArray();
        int result = 0;
        int i = capacity.length-1;
        while (count > 0 ) {
            count = count - capacity[i];
            i--;
            result++;
        }
        return result;
    }
}
