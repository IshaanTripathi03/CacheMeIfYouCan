class Solution {
    public String removeDigit(String number, char digit) {
        int n=number.length();
        
        char maxch=Character.MIN_VALUE;
        for(int i=0;i<n;i++){
            char ch=number.charAt(i);
            char nextnum=i<n-1?number.charAt(i+1):'0';
            if(ch==digit && ch <nextnum ){
                return number.substring(0,i).concat(number.substring(i+1));
            }
        }
        int idx=number.lastIndexOf(digit);
        return number.substring(0,idx).concat(number.substring(idx+1,n));
    }
}