class Solution {
    int findSum(String sub){
        int sum=0;
        for(char ch:sub.toCharArray()){
            sum+=ch-'0';
        }
        return sum;
    }
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder str=new StringBuilder();
            for(int i=0;i<s.length();i+=k){
                String sub;
                if(i+k<s.length()){
                    sub=s.substring(i,i+k);
                }
                else{
                    sub=s.substring(i);
                }
                 
                int sum=findSum(sub);
                str.append(Integer.toString(sum));
            }
            s=str.toString();
        }
        return s;
    }
}