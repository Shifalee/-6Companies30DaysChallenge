class Solution {
    public boolean isValidSerialization(String preorder) {
        int degree=1;
        for(final String node:preorder.split(",")){
            if(--degree<0)
            return false;
            if(!node.equals("#"))
            degree+=2;
        }
        return degree==0;
        
    }
}
