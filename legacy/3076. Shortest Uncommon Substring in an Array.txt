class Solution {
    public String[] shortestSubstrings(String[] arr) {
      String[] result = new String[arr.length];
      Arrays.fill(result, "");
        for (int n = 0;n < arr.length;n++) {
            String str = arr[n];
            for (int i=1;i<=str.length();i++) {
                boolean h = false;
                for (int j=0;j<=str.length()-i;j++) {
                    String checking = str.substring(j,j+i);
                    int k = 0;
                    int count = 0;
                    while (k<arr.length) {
                        if (k==n) k++;
                        if (k == arr.length) break;
                        if (arr[k].contains(checking)) {
                            break;
                        }
                        count++;
                        k++;
                    }
                    if (count==arr.length-1) {
                        h = true;
                        if (result[n] != "") {
                            result[n] = compare(result[n], checking);
                        } else result[n] = checking;
                    }
                }
                if (h) break;
            }
        }
        return result;
    }

    public static String compare(String str1, String str2) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        for (int i = 0; i< str1.length(); i++) {
            if (char1[i] < char2[i]) return str1;
            if (char1[i] > char2[i]) return str2;
        }
        return str1;
    }
}
