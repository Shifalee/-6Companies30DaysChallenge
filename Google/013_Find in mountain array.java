
import java.util.*;


 // This is MountainArray's API interface.
  // You should not implement it, or speculate about its implementation
 // interface MountainArray {
  //    public int get(int index) {}
  //    public int length() {}
  //}
  
 
 

 class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if(mountainArr.length()<100){
            for(int i=0;i<mountainArr.length();i++)
            {
                if(mountainArr.get(i)==target)
                return i;
            }
            return -1;
        }
        int low=0,high=mountainArr.length();
        int r=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(mountainArr.get(mid)>mountainArr.get(mid-1)&&mountainArr.get(mid)>mountainArr.get(mid+1)){
            r=mid;
            break;
            }
            else  if(mountainArr.get(mid)>mountainArr.get(mid-1)&&mountainArr.get(mid)<mountainArr.get(mid+1))
            low=mid+1;
            else
            high=mid-1;
        }
     int e=binary(mountainArr,0,r,target);
     if(e!=-1) return e;
     int f=binary(mountainArr,r,mountainArr.length()-1,target);
     return f;
}
     public static int binary(MountainArray mountainArr,int low,int high,int target){
     while(low<=high){
         int mid=(low+high)/2;
         if(mountainArr.get(mid)==target){
             return mid;
         }
         else  if(mountainArr.get(mid)<target){
             low=mid+1;
         }
         else{
             high=mid-1;
         }
     }
         return -1;
     }
}