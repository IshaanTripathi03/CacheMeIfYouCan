class Solution {
    public String smallestPalindrome(String s) {
        int freq[]=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        StringBuilder start=new StringBuilder();
        char middle='a';
        for(int i=0;i<=25;i++){
            char ch=(char)(i+'a');
            for(int j=0;j<freq[i]/2;j++){
                start.append(ch);
            }
            if(freq[i]%2==1){
                middle=ch;
            }
        }
        StringBuilder end=new StringBuilder(start).reverse();
        if(s.length()%2==1){
            start.append(middle);
        }
        start.append(end);
        return start.toString();
    }
}