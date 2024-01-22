import java.util.*;
class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        final int n=nums.length;
        final int startIndex=getStartIndexOfSuffix(nums);
        if(startIndex==0)
        return n*(n+1)/2;

        int ans=n-startIndex+1;
        for(int i=0;i<startIndex;++i)
        {
            if(i>0 && nums[i]<=nums[i-1])
            break;
            ans+=n-firstGreater(nums,startIndex,nums[i])+1;
        }
        return ans;

        
    }
    private int getStartIndexOfSuffix(int[] nums){
        for(int i=nums.length-2;i>=0;--i)
        if(nums[i]>=nums[i+1])
        return i+1;
        return 0;
    }
    private int firstGreater(int[] A,int startIndex,int target){
        final int i=Arrays.binarySearch(A,startIndex,A.length,target+1);
        return i<0?-i -1:i;
    }
}
