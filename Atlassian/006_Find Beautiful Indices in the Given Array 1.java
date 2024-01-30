import java.util.*;
class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
     List<Integer> ans=new ArrayList<>();
     List<Integer> indicesA=kmp(s,a);
     List<Integer> indicesB=kmp(s,b);
     int indicesBIndex=0;
     for(final int i:indicesA){
         while(indicesBIndex<indicesB.size() && indicesB.get(indicesBIndex)-i<-k)
         ++indicesBIndex;
         if(indicesBIndex<indicesB.size() && indicesB.get(indicesBIndex)-i<=k)
         ans.add(i);
     }   
     return ans;
    }
    private List<Integer> kmp(final String s,final String pattern){
        List<Integer> res=new ArrayList<>();
        int[] lps=getLPS(pattern);
        int i=0;int j=0;
        while(i<s.length()){
            if(s.charAt(i)==pattern.charAt(j)){
                ++i;
                ++j;
            }
            if(j==pattern.length()){
                res.add(i-j);
                j=lps[j-1];
            }
            else if(i<s.length() && s.charAt(i)!=pattern.charAt(j)){
                if(j!=0)
                {
                    j=lps[j-1];
                }
                else{
                    ++i;
                }
                
            }
        }
        return res;
    }
    private int[] getLPS(final String s){
        int[] lps=new int[s.length()];
        for(int i=1,j=0;i<s.length();++i)
        {
            while(j>0 && s.charAt(j)!=s.charAt(i))
            j=lps[j-1];
            if(s.charAt(i)==s.charAt(j))
            lps[i]=++j;
        }
        return lps;
    }
}
