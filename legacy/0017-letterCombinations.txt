/**
     * @Description: 17. Letter Combinations of a Phone Number
     * @Param: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
     * @return @return null
     * @author urey.lou
     * @create 2024/2/15
     **/

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        int[] number = new int[digits.length()];
        char[] charArray = digits.toCharArray();
        int i = 0 ;
        while (i < digits.length()) {
            number[i] = Character.getNumericValue(charArray[i]);
            i++;
        }
        for (i = 0; i < button[number[0]].length; i++) {
            combine(button[number[0]][i], number, 1, result);
        }
        return result;
    }

    private static String combine(String str, int[] number, int n , List<String> result) {
        if (n > number.length -1)  {
            result.add(str);
            return str;
        }
        int i;
        for (i = 0; i< button[number[n]].length; i++) {
            combine(str + button[number[n]][i], number, n+1,result);
        }
        return str;
    }
