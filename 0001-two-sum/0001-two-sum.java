class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer,Integer> map=new HashMap<>();
        int n=nums.length,com;
        for(int i=0;i<nums.length;i++){
            com=target-nums[i];
            if(map.containsKey(com)){
                return new int[] {map.get(com),i};
            }
            map.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }
}