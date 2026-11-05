class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int freq[]=new int[k];
        freq[0]=1;
        int count=0,preSum=0;
        for(int i:nums){
            preSum+=i;
            int rem=preSum%k;
            if(rem<0){
                rem+=k;
            }
            count+=freq[rem];
            freq[rem]++;
        }
        return count;
    }
}