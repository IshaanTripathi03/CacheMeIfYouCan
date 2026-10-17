class Solution {
     int maxLen=0;
     int startIdx=0;
    private  void expand(char[] ch,int left,int right,int n){
        while(left>=0 && right<n && ch[left]==ch[right]){
            if(maxLen<right-left+1){
                maxLen=right-left+1;
                startIdx=left;
            }
            left--;
            right++;
        }
    }
    public String longestPalindrome(String s) {
        char ch[]=s.toCharArray();
        int n=ch.length;
        for(int center=0;center<n;center++){
            expand(ch,center,center,n);
            expand(ch,center,center+1,n);
        }
        return s.substring(startIdx,startIdx+maxLen);
    }
}