class Solution {
    private static boolean check(int mid,int[] nums,int k){
        int totalSplits=1,sum=0;
        for(int i:nums){
            if(sum+i<=mid){
                sum+=i;
            }
            else{
                sum=i;
                totalSplits++;
            }
            if(totalSplits>k){
                return false;
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int low=0,high=0;
        for(int i:nums){
            high+=i;
            low=Math.max(low,i);
        }
        while(low<=high){
            int mid=(low+high)>>1;
            if(check(mid,nums,k)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}