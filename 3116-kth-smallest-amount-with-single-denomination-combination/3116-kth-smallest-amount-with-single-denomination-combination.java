class Solution {
    long count(long mid,int[] coins,int k){
        int n=coins.length;
        long total=0;
        for(int mask=1;mask<(1<<n);mask++){
            long lcm=1;
            int bits=0;
            boolean overflow=false;
            for(int i=0;i<n;i++){
                if((mask&(1<<i))!=0){
                    bits++;
                    long g=gcd(lcm,coins[i]);
                    //LCM(a,b)=a/GCD(a,b)*b
                    long div=lcm/g;

                    //prevent overflow
                    if(div>mid/coins[i]){
                        overflow=true;
                        break;
                    }
                    lcm=div*coins[i];
                }
            }
            if(overflow || lcm>mid){
                continue;
            }
            long multiples=mid/lcm;
            if(bits%2==1){
                total+=multiples;
            }
            else{
                total-=multiples;
            }
        }
        return total;
    }
    long gcd(long a,long b){
        while(b!=0){
            long temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
    public long findKthSmallest(int[] coins, int k) {
        long low=1,high=(long)coins[0]*k;
        for(int i:coins){
            high=Math.min(high,(long)i*k);
        }
        while(low<=high){
            long mid=low+(high-low)/2;
            if(count(mid,coins,k)>=k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}