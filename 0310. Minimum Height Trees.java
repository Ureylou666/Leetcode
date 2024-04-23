public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
        if (n == 2) return Arrays.asList(edges[0][0],edges[0][1]);
        HashMap<Integer, List<Integer>> resultMap = new HashMap<>();
        HashMap< Integer , List<Integer>> map = new HashMap<>();
        boolean[] checked = new boolean[n];
        for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        for (int i = 0; i < n; i++) resultMap.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        for (int k : map.keySet()) if (map.get(k).size() > 1) {
            Arrays.fill(checked,true);
            resultMap.get( bfs(map, k , 0, checked) ).add( k );
        }
        int max = 0, maxIndex = 0;
        for (int k : resultMap.keySet()) if (resultMap.get(k).size() > max) {
            max = resultMap.get(k).size();
            maxIndex = k;
        }
        return resultMap.get(maxIndex);

    }

    private static Integer bfs(HashMap<Integer, List<Integer>> map, int node, int level, boolean[] checked) {
        checked[node] = false;
        int max = 0;
        if (map.get(node).size() == 1) return level+1;
        for (int k : map.get(node)) if (checked[k]) {
            max = Math.max(max, bfs(map, k, level+1,checked));
        }
        return max;
    }
