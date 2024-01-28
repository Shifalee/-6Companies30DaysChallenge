import java.util.*;
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans="";
        for(final String word:dictionary)
        if(isSubsequence(word,s))
        if(word.length()>ans.length()|| word.length()==ans.length() && word.compareTo(ans)<0)
        ans=word;
        return ans;
    }
    private boolean isSubsequence(final String a, final String b){
        int i=0;
        for(final char c: b.toCharArray())
        if(i<a.length()&& c==a.charAt(i))
        ++i;
        return i==a.length();
    }
}
