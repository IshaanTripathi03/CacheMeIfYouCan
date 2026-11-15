class Solution {
    public int longestIdealString(String s, int k) {
        int n=s.length();
        int[] dp=new int[26];
        int max=1;
        for(int i=0;i<n;i++){
            int ch = s.charAt(i)-'a';
            int best = 0;
            for(int j=0;j<26;j++){
                if(Math.abs(ch-j)<=k){
                    best = Math.max(best,dp[j]);
                }
            }
            dp[ch] = best+1;
            max = Math.max(max,dp[ch]);
        }
        return max;
    }
}