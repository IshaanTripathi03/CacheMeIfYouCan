class Solution {
    
    public int numDecodings(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        int front1=1;
        int front2=1;
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            int current=0;
            if(s.charAt(i)=='0'){
                current= 0;
                front2=front1;
                front1=current;
                continue;
            }
            int one= front1 ;
            int two=0;
            if(i+1<n){
                int num=Integer.parseInt(s.substring(i,i+2));
                if(num>=10 && num<=26){
                    two= front2 ;
                }
            }
            current=one +two;
            front2=front1;
            front1=current;
        }
        return front1;
    }
}
// private static int function(int i,int n,String s,int dp[]){
//     if(i==n){
//         return 1;
//     }
//     if(s.charAt(i)=='0'){
//         return 0;
//     }
//     if(dp[i]!=-1){
//         return dp[i];
//     }
//     int one=function(i+1,n,s,dp);
//     int two=0;
//     if(i+1<n){
//         int num=Integer.parseInt(s.substring(i,i+2));
//         if(num>=10 && num<=26){
//             two=function(i+2,n,s,dp);
//         }
//     }
//     return dp[i]=one +two;
// }