class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length()-1;
        char[] stringToArray = s.toCharArray();
        char check;
        while  (stringToArray[left] == stringToArray[right])  {
            if ( left == right ) return 1;
            check = stringToArray[left];
            while ((stringToArray[left] == check) && (left < s.length()-1)) left++;
            while ((stringToArray[right] == check) && (right > 0) ) right--;
            if (left > right) return 0;
        }
        return right-left+1;
    }
}
