class Solution {
    public int myAtoi(String s) {
        int n=s.length();
        int i=0,sign=1;
        long result=0;
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        if(i==n){
            return 0;
        }
        if(s.charAt(i)=='-' || s.charAt(i)=='+'){
            if(s.charAt(i)=='-'){
                sign=-1;
            }
            i++;
        }
        while(i<n && s.charAt(i)=='0'){
            i++;
        }
        while(i<n && Character.isDigit(s.charAt(i))){
            int k=s.charAt(i)-'0';
            result=result*10+k;
            if(sign==1 && result>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(sign==-1 && sign*result<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)(sign*result);
    }
}