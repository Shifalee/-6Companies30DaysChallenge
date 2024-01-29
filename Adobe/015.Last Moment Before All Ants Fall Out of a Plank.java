class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int lastMoment=0;
        for(int position:left){
            lastMoment=Math.max(lastMoment,position);
        }
        for(int position:right){
            lastMoment=Math.max(lastMoment,n-position);
        }
        return lastMoment;
        
        
    }
}
