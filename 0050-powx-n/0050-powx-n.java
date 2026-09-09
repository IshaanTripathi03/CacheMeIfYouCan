class Solution {
    double f(double x,int n){
        if(n==0){
            return 1.0;
        }
        double half=f(x,n/2);
        if(n%2==0){
            return half*half;
        }
        else{
            if(n<0){
                return half*half/x;
            }
            else{
                return half *half*x;
            }
        }
    }
    public double myPow(double x, int n) {
        double ans=1.0;
        while(n!=0){
            if(n%2!=0){
                if(n<0){
                    ans/=x;
                }
                else{
                    ans*=x;
                }
            }
            n/=2;
            x*=x;
        }
        return ans;
    }
}
//  MY OWN LOGIC :

// double f(double x,int n){
//     if(n==0){
//         return 1.0;
//     }
//     double half=f(x,n/2);
//     if(n%2==0){
//         return half*half;
//     }
//     if(n>0){
//         return half*half*x;
//     }
//     return  half*half/x;
// }