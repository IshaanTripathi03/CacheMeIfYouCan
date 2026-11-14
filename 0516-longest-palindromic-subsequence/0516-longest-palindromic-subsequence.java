class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[] prev=new int[n+1];
        for(int i=1;i<=n;i++){
            int[] current=new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s.charAt(n-j)){
                    current[j]=1+prev[j-1];
                }
                else{
                    current[j]=Math.max(prev[j],current[j-1]);
                }
            }
            prev=current;
        }
        return prev[n];
    }
}