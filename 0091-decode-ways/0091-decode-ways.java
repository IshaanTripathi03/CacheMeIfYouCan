class Solution {
    private static int function(int i,int n,String s,int dp[]){
        if(i==n){
            return 1;
        }
        if(s.charAt(i)=='0'){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int one=function(i+1,n,s,dp);
        int two=0;
        if(i+1<n){
            int num=Integer.parseInt(s.substring(i,i+2));
            if(num>=10 && num<=26){
                two=function(i+2,n,s,dp);
            }
        }
        return dp[i]=one +two;
    }
    public int numDecodings(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                dp[i]= 0;
                continue;
            }
            int one= dp[i+1] ;
            int two=0;
            if(i+1<n){
                int num=Integer.parseInt(s.substring(i,i+2));
                if(num>=10 && num<=26){
                    two= dp[i+2] ;
                }
            }
            dp[i]=one +two;
        }
        return dp[0];
    }
}