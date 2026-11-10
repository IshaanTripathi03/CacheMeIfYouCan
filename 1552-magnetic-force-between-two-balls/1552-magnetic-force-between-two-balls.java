class Solution {
    private static boolean check(int mid,int[] position,int m,int n){
        int dist=position[0],balls=1;
        for(int i=1;i<n;i++){
            if(position[i]-dist>=mid){
                dist=position[i];
                balls++;
            }
            if(balls>=m){
                return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length;
        int low=1 , high=position[n-1]-position[0];
        while(low<=high){
            int mid=(low+high)>>1;
            if(check(mid,position,m,n)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;
    }
}