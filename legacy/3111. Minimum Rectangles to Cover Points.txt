class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i< points.length; i++) map.put(points[i][0], map.getOrDefault(points[i][0],0)+1);
        int[] arrayKey = new int[map.size()];
        int n = 0;
        for (int i : map.keySet()) arrayKey[n++] = i;
        Arrays.sort(arrayKey);
        int result =0;
        int i = 0;
        while (i<arrayKey.length){
            n = arrayKey[i];
            while (i< arrayKey.length && arrayKey[i] < n+w+1) i++;
            result++;
        }
        return result;
    }
}
