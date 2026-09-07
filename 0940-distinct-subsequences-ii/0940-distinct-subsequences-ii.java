class Solution {
    
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();

        long[] dp = new long[n + 1];
        int[] last = new int[26];

        // -1 means character has not appeared before
        java.util.Arrays.fill(last, -1);

        dp[0] = 1; // Empty subsequence

        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            int index = c - 'a';

            // Double all previous subsequences
            dp[i] = (2 * dp[i - 1]) % MOD;

            // Remove duplicates caused by previous occurrence
            if (last[index] != -1) {
                dp[i] = (dp[i] - dp[last[index] - 1] + MOD) % MOD;
            }

            // Store current position
            last[index] = i;
        }

        // Remove empty subsequence
        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}