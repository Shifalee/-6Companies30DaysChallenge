import java.util.*;
class Solution {
    String[] keypad={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> combinations=new ArrayList<>();
        if(digits.length()==0)
        return combinations;
        StringBuilder helper=new StringBuilder();
        calculate(digits,0,helper,combinations);
        return combinations;

        
    }
    public void calculate(String digits,int index,StringBuilder helper,List<String> combinations)
    {
        if(index==digits.length())
        {
            combinations.add(helper.toString());
            return;
        }
        int digit=digits.charAt(index)-'0';
        for(int i=0;i<keypad[digit].length();i++){
            helper.append(keypad[digit].charAt(i));
            calculate(digits,index+1,helper,combinations);
            helper.deleteCharAt(helper.length()-1);
        }
    }
}