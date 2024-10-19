import com.sun.tools.javac.Main;

import java.util.*;
import static java.lang.System.out;

class main {

    public static void main(String[] args) {
        // String grid2 = "[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]";
        //out.println( Math.pow(2,20) );
        out.println( rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}));
    }

    public static int rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n - 1 ; i++)
            for (int j = i; j < n -1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        return 1;
    }
}