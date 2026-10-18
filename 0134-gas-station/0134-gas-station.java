class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int totalSum=0,tank=0,start=0;;
        for(int i=0;i<n;i++){
            int diff=gas[i]-cost[i];
            tank+=diff;
            totalSum+=diff;
            if(tank<0){
                tank=0;
                start=i+1;
            }
        }
        return totalSum<0?-1:start;
    }
}