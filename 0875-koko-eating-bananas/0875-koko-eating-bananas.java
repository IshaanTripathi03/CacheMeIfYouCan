class Solution {
    private static boolean check(int mid,int[] piles,int h){
        int totalHrs=0;
        for(int i:piles){
            totalHrs+=(i+mid-1)/mid;
            if(totalHrs>h){
                return false;
            }
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int high=0;
        for(int i:piles){
            high=Math.max(high,i);
        }
        int low=1;
        while(low<=high){
            int mid=(low+high)>>1;
            if(check(mid,piles,h)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}