class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        if(n<=2){
            return nums;
        }
        List<Integer> ar1=new ArrayList<>();
        List<Integer> ar2=new ArrayList<>();
        ar1.add(nums[0]);
        ar2.add(nums[1]);
        int lastIdxAr1=0;
        int lastIdxAr2=0;
        for(int i=2;i<n;i++){
            if(ar1.get(lastIdxAr1)>ar2.get(lastIdxAr2)){
                ar1.add(nums[i]);
                lastIdxAr1++;
            }
            else{
                ar2.add(nums[i]);
                lastIdxAr2++;
            }
        }
        int i=0;
        int result[]=new int[n];
        while(i<=lastIdxAr1){
            result[i]=ar1.get(i);
            i++;
        }
        int j=0;
        while(j<=lastIdxAr2){
            result[i++]=ar2.get(j++);
        }
        return result;
    }
}