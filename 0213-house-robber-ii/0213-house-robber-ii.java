class Solution {
    private static int houseRobber(int start,int end,int[] nums){
        int prev1=0;
        int prev2=0;
        for(int i=start;i<=end;i++){
            int take=prev2+nums[i];
            int notTake=prev1;
            int current=Math.max(take,notTake);
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
        int a=houseRobber(0,n-2,nums);
        int b=houseRobber(1,n-1,nums);
        return Math.max( a , b);
    }
}