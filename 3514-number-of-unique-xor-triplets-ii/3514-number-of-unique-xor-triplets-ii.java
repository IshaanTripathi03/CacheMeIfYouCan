class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                set.add(nums[i]^nums[j]);
            }
        }
        HashSet<Integer> result=new HashSet<>();
        for(int i:set){
            for(int k=0;k<n;k++){
                result.add(i^nums[k]);
            }
        }
        return result.size();
    }
}