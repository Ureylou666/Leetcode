class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck.length == 1) return deck;
        Arrays.sort(deck);
        int[] result = new int[deck.length];
        List<Integer> temp = new ArrayList<>();
        for (int i = deck.length-1; i>=0; i--) {
            temp.clear();
            result[i] = deck[i];
            temp.add(result[result.length-1]);
            for (int j = i+1; j < result.length-1;j++ ) temp.add(result[j]);
            for (int j = i+1; j< result.length;j++) result[j] = temp.get(j-i-1);
        }
        return result;
    }
}
