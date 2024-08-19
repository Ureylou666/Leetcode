class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean[] check = new boolean[n];
        Arrays.fill(check,true);
        int[] count = new int[n];
        Arrays.fill(count, 0);
        for (int i =0 ;i < trust.length; i++){
            check[trust[i][0]-1] = false;
            count[trust[i][1]-1]++;
        }
        for (int i=0; i<n ;i++) {
            if ((count[i] == n-1) && (check[i])) {
                return i+1;
            }
        }
        return -1;
    }
}
