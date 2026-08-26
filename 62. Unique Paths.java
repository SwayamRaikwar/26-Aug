class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        // Fill the first row with 1s (only 1 way to reach any cell in the top row by moving right)
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }

        // Update DP table row by row
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
