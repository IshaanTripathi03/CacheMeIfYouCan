class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }
        int maxFreq=0,maxCount=0;
        for(int i:freq){
            maxFreq=Math.max(maxFreq,i);
        }
        for(int i:freq){
            if(i==maxFreq){
                maxCount++;
            }
        }
        return Math.max(tasks.length,((maxFreq-1)*(n+1))+maxCount);
    }
} 