class Solution {
    public String frequencySort(String s) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        int freq[]=new int[255];
        for(char ch:s.toCharArray()){
            freq[ch]++;
        }
        for(int i=0;i<255;i++){
            if(freq[i]>0){
                pq.offer(new int[]{i,freq[i]});
            }
        }
        StringBuilder result=new StringBuilder();
        while(!pq.isEmpty()){
            int arr[]=pq.poll();
            char ch=(char)arr[0];
            for(int i=1;i<=arr[1];i++){
                result.append(ch);
            }
        }
        return result.toString();
    }
}