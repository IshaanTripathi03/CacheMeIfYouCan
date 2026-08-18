class Solution {
    public int largestInteger(int[] nums, int k) {
        int max=-1;
        for(int i:nums){
            max=Math.max(max,i);
        }
        int[] freq=new int[max+1];
        int[] occurence=new int[max+1];
        int n=nums.length;
        int left=0;
        for(int right=0;right<n;right++){
            freq[nums[right]]++;
            if(k==right-left+1){
                for(int i=0;i<=max;i++){
                    if(freq[i]>0){
                        occurence[i]++;
                    }
                }
                freq[nums[left]]--;
                left++;
            }
        }
        for(int i=max;i>=0;i--){
            if(occurence[i]==1){
                return i;
            }
        }
        return-1;
    }
}