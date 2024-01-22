class Solution {
    public int findTheWinner(int n, int k) {
        boolean[] friends=new boolean[n];
        int friendcount=n;
        int fp=n;
        while(friendcount>1){
            for(int i=0;i<k;++i,++fp)
            while(friends[fp%n])
            ++fp;
            friends[(fp-1)%n]=true;
            --friendcount;
        }
        for(fp=0;friends[fp];++fp)
        ;
        return fp+1;
        
    }
}
