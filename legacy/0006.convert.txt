/**
     * @Description: 6. Zigzag Conversion
     * @Param: https://leetcode.com/problems/zigzag-conversion/description/
     * @author urey.lou
     * @create 2024/2/11
     **/

    private static void No_0006(String s, int numRows) {
        if (numRows == 1 ) {
            System.out.println(s);
            return;
        }

        String[] result = new String[numRows];
        int i = 0;
        int j = 0;

        for ( i=0;i<numRows;i++) {
            result[i] = "";
        }

        i = 0;
        boolean add = true;
        do {
            result[j] = result[j] + s.substring(i,i+1);
            if (add) {
                j++;
            } else {
                j--;
            }
            if (j == 0 || j == numRows-1) {
                add = !add;
            }
            i++;
        } while ( i < s.length());

        i = 0;

        String output = "";
        for ( i=0;i<numRows;i++) {
            output = output + result[i];
        }

        System.out.println(output);

    }
