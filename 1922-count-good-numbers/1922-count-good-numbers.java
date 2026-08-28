class Solution {
    static final long MOD=1_000_000_007;
    long pow(long x,long n){
        long ans=1;
        while(n!=0){
            if(n%2!=0){
                if(n>0){
                    ans=(ans*x)%MOD;
                }
                else{
                    ans=(ans/x)%MOD;
                }
            }
            x=(x*x)%MOD;
            n/=2;
        }
        return ans;
    }
    public int countGoodNumbers(long n) {
        long countOdd=n/2;
        long countEven=countOdd+n%2;
        long ans= (pow(5,countEven)*pow(4,countOdd))%MOD;
        return (int)ans;
    }
}