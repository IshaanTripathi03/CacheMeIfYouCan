class Solution {
    public String smallestPalindrome(String s) {
        int freq[]=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        StringBuilder start=new StringBuilder();
        String middle="";
        for(int i=0;i<=25;i++){
            for(int j=0;j<freq[i]/2;j++){
                start.append((char)(i+'a'));
            }
            if(freq[i]%2==1){
                middle=String.valueOf((char)(i+'a'));
            }
        }
        StringBuilder end=new StringBuilder(start).reverse();
        return start.toString()+middle+end.toString();
    }
}