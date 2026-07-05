class Solution {
    //Code form House Robber [198].
    int robber(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int prev2=nums[0];
        int prev1=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int take=nums[i]+prev2;
            int notTake=prev1;
            int current= Math.max(take,notTake);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int[] temp1=new int[n];
        int[] temp2=new int[n-1];
        for(int i=0;i<n;i++){
            if(i!=0){
                temp1[i]=nums[i];
            }
            if(i!=n-1){
                temp2[i]=nums[i];
            }
        }
        return Math.max(robber(temp1),robber(temp2));
    }
}