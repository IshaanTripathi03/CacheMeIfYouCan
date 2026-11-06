class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<2){
            return false;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int preSum=0,n=nums.length;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            preSum+=nums[i];
            int rem=preSum%k;
            if(map.containsKey(rem) ){
                if(i-map.get(rem)>=2)
                return true;
            }
            else{
                map.put(rem,i);
            }
            
        }
        return false;
    }
}