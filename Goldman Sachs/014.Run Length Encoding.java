
class GfG
 {
	String encode(String str)
	{
          //Your code here
          StringBuffer bf=new StringBuffer();
          for(int i=0;i<str.length();i++)
          {
              int count=1;
              while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1))
              {
                  count++;
                  i++;
              }
              bf.append(str.charAt(i));
              bf.append(count);
          }
          return bf.toString();
	}
	
 }
