
class Solution {
    public int squareFreeSubsets(int[] nums) {
        Integer[][] mem=new Integer[nums.length][1<<(kPrimesCount+1)];
        int[] masks=new int[nums.length];
        for(int i=0;i<nums.length;++i)
        masks[i]=getMask(nums[i]);
        return (squareFreeSubsets(masks,0,/*used=*/1,mem)-1+kMod)%kMod;        
    }
    private static final int kMod=1_000_000_007;
    private static final int kPrimesCount=10;
    private static final int[] primes={2,3,5,7,11,13,17,19,23,29};
    private int squareFreeSubsets(int[] masks,int i,int used,Integer[][] mem){
        if(i==masks.length)
        return 1;
        if(mem[i][used]!=null)
        return mem[i][used];
        final int pick=(masks[i]& used)==0 ? squareFreeSubsets(masks,i+1,used|masks[i],mem):0;
        final int skip=squareFreeSubsets(masks,i+1,used,mem);
        return mem[i][used]=(pick+skip)%kMod;
    }
    private int getMask(int num){
        int mask=0;
        for(int i=0;i<primes.length;++i)
        {
            int rootCount=0;
            while(num%primes[i]==0)
            {
                num/=primes[i];
                ++rootCount;
            }
            if(rootCount>=2)
            return -1;
            if(rootCount==1)
            mask|=1<<i;
        }
        return mask<<1;
    }
}