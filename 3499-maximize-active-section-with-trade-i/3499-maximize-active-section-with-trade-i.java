class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n=s.length();
        List <Integer> zeroBlock=new ArrayList<>();
        int countOnes=0;
        for(char ch:s.toCharArray()){
            if(ch=='1'){
                countOnes++;
            }
        }
        int i=0;
        while(i<n){
            if(s.charAt(i)=='0'){
                int zeroCount=0;
                while(i<n && s.charAt(i)=='0'){
                    zeroCount++;
                    i++;
                }
                zeroBlock.add(zeroCount);
            }
            else{
                i++;
            }
        }
        int ans=countOnes;
        for(int j=1;j<zeroBlock.size();j++){
            ans=Math.max(ans,zeroBlock.get(j)+zeroBlock.get(j-1)+countOnes);
        }
        return ans;
    }
}