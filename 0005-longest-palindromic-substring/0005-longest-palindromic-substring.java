class Solution {
    int start=0;
    int maxLen=0;
    void expand(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(right)==s.charAt(left)){
            if(right-left+1>maxLen){
                maxLen=right-left+1;
                start=left;
            }
            left--;
            right++;
        }
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        for(int center=0;center<n;center++){
            expand(s,center,center);        //for odd
            expand(s,center,center+1);      //for even
        }
        return s.substring(start,start+maxLen);
    }
}