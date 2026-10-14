class Solution {
    public String maxSumOfSquares(int num, int sum) {
        
        StringBuilder result=new StringBuilder();
        
        while(sum!=0){
            if(sum>9){
                result.append(9);
                sum-=9;
            }
            else{
                result.append(sum);
                sum=0;
            }
        }
        int len=result.length();
        if(len>num){
            return "";
        }
        else{
            while(len!=num){
                result.append(0);
                len++;
            }
        }
        return result.toString();
    }
}