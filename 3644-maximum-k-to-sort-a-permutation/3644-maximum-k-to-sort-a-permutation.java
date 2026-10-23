class Solution {
    public int sortPermutation(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]){
                list.add(nums[i]);
            }
        }
        if(list.size()==0){
            return 0;
        }
        int k=list.get(0);
        for(int i=0;i<list.size();i++){
            k=(k&list.get(i));
        }
        return k;
    }
}