class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length < 1) return 0;
        tokens = Arrays.stream(tokens).sorted().toArray();
        if ((tokens.length == 1) && (power >= tokens[0]) ) return 1;
        if (power < tokens[0]) return 0;
        int result = 0;
        int max = 0;
        int i = 0;
        int j = tokens.length-1;
        while ( i < j ) {
            while (power >= tokens[i]) {
                power = power - tokens[i];
                i++;
                result++;
            }
            if (result > max) max =result;
            while (power < tokens[i]) {
                power = power + tokens[j];
                j--;
                result--;
            }
        }
        return max;
    }
}
