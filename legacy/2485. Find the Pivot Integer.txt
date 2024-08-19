public static int pivotInteger(int n) {
        List<Integer> square = new ArrayList<>();
        //Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map = Map.of(1, 1, 8, 6, 49, 35, 288, 204);
        for (int i = 0; i<1001;i++) square.add(i*i);
        for (int i = 0; i<1001;i++) {
            if (square.contains( 8*i*i+1 )) {
                int root = (int) (Math.sqrt(8*i*i+1)-2*i+1)/2;
                System.out.println(i+root-1);
                map.put(i+root-1, i);
            }
        }
        if (map.containsKey(n)) return map.get(n);
        return -1;
    }
