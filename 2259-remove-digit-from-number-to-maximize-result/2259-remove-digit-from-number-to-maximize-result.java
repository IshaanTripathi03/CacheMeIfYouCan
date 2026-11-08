class Solution {
    public String removeDigit(String number, char digit) {
        int n=number.length();
        for(int i=0;i<n-1;i++){
            char ch=number.charAt(i);
            char nextnum=number.charAt(i+1);
            if(ch==digit && ch <nextnum ){
                return number.substring(0,i).concat(number.substring(i+1));
            }
        }
        int idx=number.lastIndexOf(digit);
        return number.substring(0,idx).concat(number.substring(idx+1,n));
    }
}