class Solution {
    public int majorityElement(int[] nums) {
        int counter=0,major=0;
        for(int i:nums){
            if(counter==0){
                major=i;
                counter++;
            }
            else if(i==major){
                counter++;
            }
            else{
                counter--;
            }
        }
        return major;
    }
}