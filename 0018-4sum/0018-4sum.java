class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List <List<Integer>> list=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        int a,b,c,d;
        long sum;
        for(a=0;a<n;a++){
            //Pruning
            if(a+3<n    &&  (long)nums[a]+nums[n-1]+nums[n-2]+nums[n-3]<target){       continue;}
            if(a+3<n    &&  (long)nums[a]+nums[a+1]+nums[a+2]+nums[a+3]>target){       break;}

            if(a>0 && nums[a]==nums[a-1]){      continue;}
            for(b=a+1;b<n;b++){
                //Pruning
                if(b+2<n    &&  (long)nums[a]+nums[b]+nums[n-1]+nums[n-2]<target){       continue;}
                if(b+2<n    &&  (long)nums[a]+nums[b]+nums[b+1]+nums[b+2]>target){       break;}

                if(b>a+1 && nums[b]==nums[b-1]){      continue;}
                c=b+1;
                d=n-1;
                while(c<d){
                    sum=(long)nums[a]+nums[b]+nums[c]+nums[d];
                    if(sum>target){
                        d--;
                    }
                    else if(sum<target){
                        c++;
                    }
                    else{
                        list.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
                        c++;
                        d--;
                        while(c<d && nums[c]==nums[c-1]){      c++;}
                        while(c<d && nums[d]==nums[d+1]){      d--;}
                    }
                }
            }
        }
        return list;
    }
}