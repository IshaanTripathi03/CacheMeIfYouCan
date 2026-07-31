class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int sum=0;
        int freq[]=new int[26];
        for(int i=0;i<n;i++){
            freq[word.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        int idx=0;
        for(int i=25;i>=0;i--){
            if(freq[i]>0){
                int push=(idx/8)+1;
                sum+=freq[i]*push;
                idx++;
            }
        }
        return sum;
    }
}