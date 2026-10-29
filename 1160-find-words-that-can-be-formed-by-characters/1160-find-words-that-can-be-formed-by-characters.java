class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq=new int[26];
        for(char ch:chars.toCharArray()){
            freq[ch-'a']++;
        }
        int length=0;
        for(String s:words){
            int[] chr=new int[26];
            for(char ch:s.toCharArray()){
                chr[ch-'a']++;
            }
            boolean possible=true;
            for(int i=0;i<26;i++){
                if(freq[i]<chr[i]){
                    possible=false;
                    break;
                }
            }
            if(possible){
                length+=s.length();
            }
        }
        return length;
    }
}