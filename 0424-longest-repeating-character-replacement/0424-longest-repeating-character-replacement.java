class Solution {
    public int characterReplacement(String s, int k) {
        int freq[]=new int[26];
        int left=0,maxfreq=0,max=0,n=s.length();
        for(int right=0;right<n;right++){
            freq[s.charAt(right)-'A']++;
            maxfreq=Math.max(maxfreq,freq[s.charAt(right)-'A']);
            if((right-left+1)-maxfreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            if((right-left+1)-maxfreq<=k)
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}