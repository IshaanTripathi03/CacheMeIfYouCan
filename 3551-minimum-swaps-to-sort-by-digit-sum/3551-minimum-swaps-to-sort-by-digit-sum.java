class Solution {
    private static int digitSum(int num){
        int sum=0;
        while(num!=0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][3];
        for(int i=0;i<n;i++){
            dp[i][0]=nums[i];               //Number
            dp[i][1]=digitSum(nums[i]);     //Digit SUM
            dp[i][2]=i;                     //Original Index
        }
        Arrays.sort(dp,(a,b)->{
            if(a[1]!=b[1]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        boolean flag[]=new boolean [n];
        int shift=0;
        for(int i=0;i<n;i++){
            if(flag[i] || dp[i][2]==i){
                continue;
            }
            int cycleCount=0;
            int j=i;
            while(!flag[j]){
                flag[j]=true;
                j=dp[j][2];
                cycleCount++;
            }
            shift+=cycleCount-1;
        }
        return shift;
    }
}