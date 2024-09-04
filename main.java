import java.util.*;

class main {

    public static void main (String[] args) {
        // String grid1 = "[[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]]";
        // String grid2 = "[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]";
        //System.out.println( countGoodIntegers(1,1));
        System.out.println( robotSim( new int[]{4,-1,4,-2,4}, new int[][]{{2,4}} )) ;
    }

    public static class xy {
        int x;
        int y;

        public xy(int i, int j) {
            x = i;
            y = j;
        }
    }
    public static int robotSim(int[] commands, int[][] obstacles) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0;i<obstacles.length;i++) map.put((obstacles[i][0]+"-"+obstacles[i][1]),1);
        xy[] direction = new xy[4];
        direction[0] = new xy(0,1);
        direction[1] = new xy(1,0);
        direction[2] = new xy(0,-1);
        direction[3] = new xy(-1,0);
        int k = 0, max = 0, a = 0 , b = 0;
        for (int n : commands) {
            if ( n == -1) k = (k+5) % 4;
                else if ( n == -2) k = (k+3) % 4;
                    else {
                        for (int p = 1; p<=n; p++) {
                            if ( map.containsKey( (a + direction[k].x) +"-"+ (b + direction[k].y) ) ) break;
                            a = a + direction[k].x;
                            b = b + direction[k].y;
                            if ( (a*a + b*b) > max ) max =a*a+b*b;
                        }
                    }
        }
        return max;
    }

}