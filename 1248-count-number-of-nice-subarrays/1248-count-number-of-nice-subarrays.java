class Solution {
    int f(int[] nums,int k,int n){
        if(k<0){
            return 0;
        }
        int left=0,count=0,t=0;
        for(int right=0;right<n;right++){
            if((nums[right]&1)==1){
                t++;
            }
            while(t>k){
                if((nums[left]&1)==1){
                    t--;
                }
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        return f(nums,k,n)-f(nums,k-1,n);
    }
}