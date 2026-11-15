class Solution {
    public static int MOD=1_000_000_007;
    public int numOfSubarrays(int[] arr) {
        int prefixSum=0;
        int even=1,odd=0,ans=0;
        for(int i:arr){
            prefixSum+=i;
            if((prefixSum&1)==1){
                ans=(ans+even)%MOD;
                odd++;
            }
            else{
                ans=(ans+odd)%MOD;
                even++;
            }
        }
        return ans;
    }
}