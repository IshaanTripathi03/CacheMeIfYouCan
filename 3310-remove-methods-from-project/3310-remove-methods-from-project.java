class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] edge:invocations ){
            graph.get(edge[0]).add(edge[1]);
        }
        LinkedList<Integer> queue=new LinkedList<>();
        boolean sus[]=new boolean[n];
        sus[k]=true;
        queue.offer(k);
        while(!queue.isEmpty()){
            int node=queue.poll();
            for(int i:graph.get(node)){
                if(!sus[i]){
                    sus[i]=true;
                    queue.offer(i);
                }
            }
        }
        for(int[] edge:invocations){
            int a=edge[0];
            int b=edge[1];
            if(!sus[a] && sus[b]){
                List<Integer> result=new ArrayList<>();
                for(int i=0;i<n;i++){
                    result.add(i);
                }
                return result;
            } 
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!sus[i]){
                result.add(i);
            }
        }
        return result;
    }
}