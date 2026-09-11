class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq=new int[10];
        for(int i:digits){
            freq[i]++;
        }
        int count=0;
        for(int i=100;i<=999;i+=2){
            int n=i;
            int ones=n%10;
            n/=10;
            int tens=n%10;
            n/=10;
            int need[]=new int[10];
            need[ones]++;
            need[tens]++;
            need[n]++;
            count++;
            for(int k=0;k<10;k++){
                if(need[k]>freq[k]){
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}