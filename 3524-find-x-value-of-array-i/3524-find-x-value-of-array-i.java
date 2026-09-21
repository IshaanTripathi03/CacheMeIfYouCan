class Solution {
    
    public long[] resultArray(int[] nums, int k) {
        int n=nums.length;
        long[] prev=new long[k];
        long[] result=new long[k];
        for(int i=0;i<n;i++){
            long current[]=new long[k];
            int rem=nums[i]%k;
            current[rem]++;
            for(int r=0;r<k;r++){
                int newRem=(r*rem)%k;
                current[newRem]+=prev[r];
            }
            for(int r=0;r<k;r++){
                result[r]+=current[r];
            }
            prev=current;
        }
        return result;
    }
}
// static void f(int i,int rem,int[] nums,int k,int n,long[] result){
//     if(i==n){
//         return ;
//     }
//     int newRem=((nums[i]%k)*rem)%k;
//     result[newRem]++;
//     f(i+1,newRem,nums,k,n,result);
// }