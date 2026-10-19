class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int countLess=0,countEqual=0;
        for(int i:nums){
            if(i<target){
                countLess++;
            }
            if(i==target){
                countEqual++;
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=countEqual;i++){
            list.add(countLess++);
        }
        return list;
    }
}