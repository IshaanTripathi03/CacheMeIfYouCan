class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=1;
        right[n-1]=1;
        list1.add(nums[0]);
        int top1=0;
        for(int i=1;i<n;i++){
            int low=0,high=top1;
            while(low<=high){
                int mid=(low+high)>>1;
                if(list1.get(mid)<nums[i]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            if(low==top1+1){
                list1.add(nums[i]);
                top1++;
            }
            else{
                list1.set(low,nums[i]);
            }
            left[i]=low+1;
        }
        list2.add(nums[n-1]);
        int top2=0;
        for(int i=n-2;i>=0;i--){
            int low=0,high=top2;
            while(low<=high){
                int mid=(low+high)>>1;
                if(list2.get(mid)<nums[i]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            if(low==top2+1){
                list2.add(nums[i]);
                top2++;
            }
            else{
                list2.set(low,nums[i]);
            }
            right[i]=low+1;
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(left[i]>1 && right[i]>1)
            max=Math.max(max,right[i]+left[i]-1);
        }
        return n-max;
    }
}