class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size();
        int prod=0;
        for(int i=0;i<n;i++){
            boolean[] flag=new boolean[101];
            int len=0;
            for(int j=i;j<n;j++){
                int num=nums.get(j);
                if(!flag[num]){
                    flag[num]=true;
                    len++;
                }
                prod+=len*len;
            }
        }
        return prod;
    }
}