class Solution {
    void reverse(int[] ch,int start,int end){
        while(start<end){
            int t=ch[start];
            ch[start]=ch[end];
            ch[end]=t;
            start++;
            end--;
        }
    }
    void swap(int[] ch,int a,int b){
        int t=ch[a];
        ch[a]=ch[b];
        ch[b]=t;
    }
    public String getPermutation(int n, int k) {
        int ch[]=new int[n];
        for(int i=0;i<n;i++){
            ch[i]=i+1;
        }
        for(int j=1;j<k;j++){
            //find dip
            int dip=n-2;
            while(dip>=0 && ch[dip]>=ch[dip+1]){
                dip--;
            }
            if(dip==-1){
                reverse(ch,0,n-1);
                continue;
            }
            int g=n-1;
            while(ch[dip]>=ch[g]){
                g--;
            }
            swap(ch,dip,g);
            reverse(ch,dip+1,n-1);
        }
        StringBuilder result=new StringBuilder();
        for(int i:ch){
            result.append((char)(i+'0'));
        }
        return result.toString();
    }
}