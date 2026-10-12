class Solution {
    static int MOD=1_000_000_007;
    public int maxSum(List<Integer> nums, int k) {
        int[] bit=new int[32];
        for(int i:nums){
            
            for(int b=0;b<32;b++){
                if((i&(1<<b))!=0){
                    bit[b]++;
                    
                }
                
            }
        }
        long result=0;
        for(int i=0;i<k;i++){
            long num=0;
            for(int b=31;b>=0;b--){
                if(bit[b]>0){
                    num|=(1L<<b);
                    bit[b]--;
                }
            }
            result=(result+num*num)%MOD;
        }
        return (int)result;
    }
}