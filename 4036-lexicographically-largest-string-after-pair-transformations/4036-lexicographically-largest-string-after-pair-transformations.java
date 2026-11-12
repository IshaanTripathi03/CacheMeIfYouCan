class Solution {
    public String[] largestString(int[] nums) {
        int n=nums.length;
        String[] result=new String[n];
        for(int i=0;i<n;i++){
            int j=nums[i];
            StringBuilder sub=new StringBuilder();
            for(int bit=26;bit>=0;bit--){
                if ((j & (1 << bit)) != 0) {
                    if (bit == 26) {
                        sub.append("zz");
                    } else {
                        sub.append((char)('a' + bit));
                    }
                }
            }
            result[i]=sub.toString();
        }
        return result;
    }
}