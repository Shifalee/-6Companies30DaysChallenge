class Solution {
    private int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {

        long lo=1,hi=(int) 10e10;
        long ans=hi;
        long lcm=((long) divisor1 *(long) divisor2)/gcd(divisor1,divisor2);
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            int x=(int)(mid-mid/divisor1);
            int y=(int)(mid-mid/divisor2);
            int z=(int)(mid-mid/lcm);
            if(x< uniqueCnt1 || y< uniqueCnt2|| z<uniqueCnt1+uniqueCnt2){
                lo=mid+1;
            }
            else{
                ans=Math.min(ans,mid);
                hi=mid-1;
            }
        }
        return (int)ans;
        
    }
}