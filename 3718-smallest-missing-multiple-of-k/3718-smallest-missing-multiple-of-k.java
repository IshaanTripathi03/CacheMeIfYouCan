class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        int max=-1;
        for(int i:nums){
            max=Math.max(max,i);
            set.add(i);
        }
        int i;
        for(i=k;i<=max;i+=k){
            if(!set.contains(i) && i%k==0){
                return i;
            }
        }
        return i;
    }
}