class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet <Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        for(int i:nums1){
            set.add(i);
        }
        for(int j:nums2){
            if(set.contains(j)){
                list.add(j);
                set.remove(j);
            }
        }
        int n=list.size();
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=list.get(i);
        }
        return result;
    }
}