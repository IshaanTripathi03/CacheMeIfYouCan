class Solution {
    public int maxSelectedElements(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        int result=0;
        for(int i:nums){
            int incOne=map.getOrDefault(i,0)+1;
            int notInc=map.getOrDefault(i-1,0)+1;
            map.put(i+1,Math.max(map.getOrDefault(i+1,0),incOne));
            map.put(i,Math.max(map.getOrDefault(i,0),notInc));
            result=Math.max(result,Math.max(map.get(i),map.get(i+1)));
        }
        return result;
    }
}