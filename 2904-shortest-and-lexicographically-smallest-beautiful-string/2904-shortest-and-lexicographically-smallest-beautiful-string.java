class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int left=0,countOne=0;
        int minLen=Integer.MAX_VALUE;
        String result="";
        for(int right=0;right<n;right++){
            int ch=s.charAt(right)-'0';
            if(ch==1){
                countOne++;
            }
            while(countOne>k){
                countOne-=s.charAt(left)-'0';
                left++;
            }
            if(countOne==k){
                while(s.charAt(left)=='0'){
                    left++;
                }
                int len=right-left+1;
                if(len<minLen  || (len==minLen && s.substring(left,right+1).compareTo(result)<0)){
                    minLen=len;
                    result=s.substring(left,right+1);
                }
            }
        }
        return result;
    }
}