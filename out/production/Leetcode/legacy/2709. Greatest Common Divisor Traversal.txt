public static List<Integer> zhishu = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997);

    public static boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int[] temp = new int[nums.length];
        for (int i=0;i<nums.length;i++) temp[i]=i;
        // boolean[][] connect = new boolean[nums.length][nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (gcd(nums[i], nums[j])) {
                    temp = union(temp, i, j);
                }
            }
        }
        for (int i=1;i<nums.length;i++) {
            if ( find(temp, i ) != temp[0]) return false;
        }
        return true;
    }

    public static int find(int[] origin, int i) {
        while (origin[i] != i) {
            i = origin[i];
        }
        return i;
    }

    public static int[] union(int[] origin, int i, int j) {
        int x = find(origin, i);
        int y = find(origin, j);
        origin[x] = y;
        return origin;
    }

    private static boolean gcd(int x, int y){
        boolean result = false;
        for (int i: zhishu) {
            if ( (x % i ==0 ) && (y % i == 0) ) {
                return true;
            }
        }
        return result;
    }
