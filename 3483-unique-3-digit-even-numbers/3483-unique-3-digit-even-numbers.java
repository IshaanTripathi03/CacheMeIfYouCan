class Solution {
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        int count=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){      //Unit Digit
            if((digits[i]&1)==1){    continue;}
            for(int j=0;j<n;j++){   //Tens Digit
                if(i==j){       continue;}
                for(int k=0;k<n;k++){
                    if(k==j || i==k || digits[k]==0){       continue;}
                    int num=digits[k]*100+digits[j]*10+digits[i];
                    set.add(num);
                }
            }
        }
        return set.size();
    }
}