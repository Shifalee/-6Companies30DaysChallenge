import java.util.*;
class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        int num=1;
        Stack<Integer> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<S.length();i++)
        {
            st.push(num++);
            if(S.charAt(i)=='I')
            {
                while(st.size()>0){
                    sb.append(st.pop());
                }
            }
        }
        st.push(num);
        while(st.size()>0)
        {
            sb.append(st.pop());
            
        }
        return sb.toString();
    }
}