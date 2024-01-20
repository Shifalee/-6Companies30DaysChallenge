class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int mod=1000000007;
        int[][]dp=new int[3002][k+1];
        dp[startPos+1000][k]=1;
        for(int j=k-1;j>=0;j--)
        {
            for(int idx=1;idx<=3000;idx++){
                dp[idx][j]=(dp[idx][j]+dp[idx-1][j+1]%mod+dp[idx+1][j+1])%mod;

            }
        }
        return dp[endPos+1000][0];
    }
}