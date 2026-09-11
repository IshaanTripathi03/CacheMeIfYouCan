class Solution {
    public int characterReplacement(String s, int k) {
        int freq[]=new int[26];
        int left=0,maxfreq=0,max=0,n=s.length();
        int ch,len;
        for(int right=0;right<n;right++){
            ch=s.charAt(right)-'A';
            len=right-left+1;
            freq[ch]++;
            maxfreq=Math.max(maxfreq,freq[ch]);
            if(len-maxfreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            if(len-maxfreq<=k)
            max=Math.max(max,len);
        }
        return max;
    }
}