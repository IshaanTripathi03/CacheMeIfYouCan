class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        ArrayList<Integer> list=new ArrayList<>();
        int top=0;
        list.add(nums[0]);
        for(int i=1;i<n;i++){
            if(list.get(top)<nums[i]){
                list.add(nums[i]);
                top++;
            }
            else{
                int low=0,high=top;
                while(low<=high){
                    int mid=(low+high)>>1;
                    if(list.get(mid)<nums[i]){
                        low=mid+1;
                    }
                    else{
                        high=mid-1;
                    }
                }
                list.set(low,nums[i]);
            }
        }
        return top+1;
    }
}