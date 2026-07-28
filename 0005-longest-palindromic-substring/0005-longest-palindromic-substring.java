class Solution {
    boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        String result="";
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j) && j-i+1>result.length()){
                    result=s.substring(i,j+1);
                }
            }
        }
        return result;
    }
}