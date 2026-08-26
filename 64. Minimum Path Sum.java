class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];

        // Base case: starting point
        dp[0] = grid[0][0];

        // Initialize the first row
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        // Process remaining rows
        for (int i = 1; i < m; i++) {
            // First column of current row can only come from above
            dp[0] += grid[i][0];

            for (int j = 1; j < n; j++) {
                // dp[j] is top cell, dp[j-1] is left cell
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }

        return dp[n - 1];
    }
}
