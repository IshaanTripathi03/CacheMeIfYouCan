class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        List<Integer> list=new ArrayList<>();
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i:nums){
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        boolean[] checkNum=new boolean[max+1];
        for(int i:nums){
            checkNum[i]=true;
        }
        for(int i=min;i<max;i++){
            if(!checkNum[i]){
                list.add(i);
            }
        }
        return list;
    }
}