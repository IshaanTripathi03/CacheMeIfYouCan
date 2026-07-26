class Solution {
    public String largestOddNumber(String num) {
        int n=num.length();
        int idx=-1;
        for(int i=n-1;i>=0;i--){
            char ch=num.charAt(i);
            if((ch-'0')%2==1){
                idx=i;
                break;
            }
        }
        return idx==-1?"":num.substring(0,idx+1);
    }
}