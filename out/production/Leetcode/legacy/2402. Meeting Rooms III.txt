class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        boolean[] availeable = new boolean[n];
        Arrays.fill(availeable, true);
        PriorityQueue<int[]> meetingList = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> roomList = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1]; // 先按照第二个值排序
            } else {
                return a[0] - b[0]; // 如果第二个值相同，再按照第一个值排序
            }
        });
        meetingList.addAll(Arrays.asList(meetings));
        int i = 0 ;
        int k = 0;
        int currentTime = 0;
        int[] room = new int[2];
        // 从PriorityQueue中按照排序后的顺序取出元素
        while (!meetingList.isEmpty()) {
            int[] pair = meetingList.poll();
            currentTime = pair[0];
            if (k==0) {
                count[0]++;
                roomList.offer(new int[]{0,pair[1]});
                availeable[0] = false;
                k++;
            } else {
                boolean h = true;
                do {
                    room = roomList.poll();
                    if (room[1] > pair[0]) {
                        h = false;
                        roomList.offer(room);
                    }
                    if (h) {
                        k--;
                        availeable[ room[0] ] = true;
                    }
                } while ((!roomList.isEmpty()) && h);

                if (k==n) {
                    room = roomList.poll();
                    availeable[room[0]] = false;
                    currentTime = room[1];
                    count[room[0]]++;
                    roomList.offer(new int[]{room[0],currentTime+pair[1]-pair[0]});
                } else {
                    i = 0;
                    while (!availeable[i]) {
                        i++;
                    }
                    count[i]++;
                    roomList.offer(new int[]{i,currentTime+pair[1]-pair[0]});
                    availeable[i] = false;
                    k++;
                }
            }
        }
        int max = 0;
        int result = -1;
        for (i = 0; i < n; i++) {
            if (count[i] > max) {
                result = i;
                max = count[i];
            }
        }
        return result;
    }
}
