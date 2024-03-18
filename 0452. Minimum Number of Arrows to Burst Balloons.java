class Solution {
    public static int findMinArrowShots(int[][] points) {
        List<int[]> maps = new ArrayList<>();
        boolean h;
        for (int[] point : points) {
            h = false;
            for (int[] map : maps) {
                if ( (point[0] < map[0]) && (point[1] > map[0]) && (point[1]<=map[1]) ) {
                    h = true;
                    maps.remove(map);
                    maps.add( new int[]{map[0], point[1]});
                    break;
                }
                if ( (point[0] >= map[0]) && (point[1]<=map[1]) ) {
                    h = true;
                    maps.remove(map);
                    maps.add( new int[]{point[0], point[1]});
                    break;
                }
                if ( (point[0] >= map[0]) && (point[0] <= map[1]) && (point[1] > map[1]) ) {
                    h = true;
                    maps.remove(map);
                    maps.add( new int[]{point[0], map[1]});
                    break;
                }
                if ( (point[0] <= map[0]) && (point[1] >= map[1]) ) {
                    h = true;
                    break;
                }
            }
            if (!h) maps.add(point);
        }
        return maps.size();
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        // Sort the points array by the end of each balloon
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            // If the start of the current balloon is greater than the end of the last balloon
            // we need a new arrow
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }
}
