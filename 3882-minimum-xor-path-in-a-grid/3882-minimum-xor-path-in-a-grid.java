class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        List<Set<Integer>> dp = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            dp.add(new HashSet<>());
        }

        dp.get(0).add(grid[0][0]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int value = grid[i][j];

                Set<Integer> reachable = new HashSet<>(dp.get(j));

                if (j > 0) {
                    reachable.addAll(dp.get(j - 1));
                }

                Set<Integer> next = new HashSet<>();

                for (int k : reachable) {
                    next.add(k ^ value);
                }

                dp.set(j, next);
            }
        }

        return Collections.min(dp.get(n - 1));
    }
}