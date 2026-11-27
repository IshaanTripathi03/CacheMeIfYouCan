class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int f = items[i][0];
            int p = items[i][1];

            int free = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % f == 0) {
                    free++;
                }
            }

            // First copy: purchased + free copies (0/1 knapsack)
            for (int b = budget; b >= p; b--) {
                dp[b] = Math.max(dp[b], dp[b - p] + 1 + free);
            }

            // Additional copies: unbounded knapsack
            for (int b = p; b <= budget; b++) {
                dp[b] = Math.max(dp[b], dp[b - p] + 1);
            }
        }

        return dp[budget];
    }
}