class Solution {
    public void nextPermutation(int[] nums) {
        //[2,1,3,5,0,0]
        int n=nums.length;
        int i=n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        //[2,1,3_,5,0,0]
        //Base Condition: [3,2,1]
        if(i==-1){
            reverse(nums,0,n-1);
            return;
        }
        //j is the smallest number from right to left side which is greater than nums[i]
        int j=n-1;
        while(nums[i]>=nums[j]){
            j--;
        }
        swap(nums,i,j);
        reverse(nums,i+1,n-1);
    }
    void reverse(int[] num,int s,int e){
        while(s<e){
            int t=num[s];
            num[s]=num[e];
            num[e]=t;
            s++;
            e--;
        }
    }
    void swap(int[] num,int a,int b){
        num[a]=num[a]+num[b];
        num[b]=num[a]-num[b];
        num[a]=num[a]-num[b];
    }
}