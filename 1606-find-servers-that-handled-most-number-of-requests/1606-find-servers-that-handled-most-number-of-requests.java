class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        List<Integer> list=new ArrayList<>();
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<k;i++){
            set.add(i);
        }
        int[] freq=new int[k];
        int n=arrival.length;
        int max=0;
        for(int i=0;i<n;i++){
            int finishTime=arrival[i]+load[i];
            while(!pq.isEmpty() && pq.peek()[0]<=arrival[i]){
                int a[]=pq.poll();
                set.add(a[1]);
            }

            if(set.isEmpty()){
                continue;
            }

            int start=i%k;
            Integer id=set.ceiling(start);
            if(id==null){
                id=set.first();
            }
            set.remove(id);
            pq.offer(new int[]{finishTime,id});
            freq[id]++;
            max=Math.max(max,freq[id]);
        }
        for(int i=0;i<k;i++){
            if(freq[i]==max){
                list.add(i);
            }
        }
        return list;
    }
}