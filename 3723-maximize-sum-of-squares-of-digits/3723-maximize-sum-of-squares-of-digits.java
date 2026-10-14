class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int nums[]=new int[num];
        int i=0;
        while(i<num && sum!=0){
            if(sum>9){
                nums[i]=9;
                sum-=9;
            }
            else{
                nums[i]=sum;
                sum=0;
            }
            i++;
        }
        if(sum!=0){
            return "";
        }
        StringBuilder result=new StringBuilder();
        for(int a:nums){
            result.append(a);
        }
        return result.toString();
    }
}