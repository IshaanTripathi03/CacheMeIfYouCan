class Solution {
    public int missingInteger(int[] nums) {
        int max=-1;
        for(int i:nums){
            max=Math.max(max,i);
        }
        int prev=nums[0];
        int count=1,sum=nums[0];
        int freq[]=new int[max+1];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-prev==1){
                sum+=nums[i];
            }
            else{
                break;
            }
            prev=nums[i];
        }
        for(int i:nums){
            freq[i]++;
        }
        int i;
        for(i=sum;i<=max;i++){
            if(freq[i]==0){
                return i;
            }
        }
        return i;
    }
}