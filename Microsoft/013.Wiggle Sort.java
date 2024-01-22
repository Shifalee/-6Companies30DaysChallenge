import java.util.*;
class Solution {
    public void wiggleSort(int[] nums) {
        if(nums==null || nums.length<=1){
            return;
        }
        Arrays.sort(nums);
        int n=nums.length;
        int[] temp=new int[n];
        int low=(n+1)/2,high=n;

        for(int i=0;i<n;i++){
            temp[i]=i%2==0 ? nums[--low]:nums[--high];

        }
        for(int i=0;i<n;i++)
        {
            nums[i]=temp[i];
        }
    }
}