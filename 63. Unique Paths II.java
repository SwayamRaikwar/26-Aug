class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        
        // Base case: starting point
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0; // Obstacle blocks all incoming paths
                } else if (j > 0) {
                    dp[j] += dp[j - 1]; // Current paths = paths from top (dp[j]) + left (dp[j-1])
                }
            }
        }

        return dp[n - 1];
    }
}
