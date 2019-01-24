import java.util.*;
class SearchEngine
{
    ArrayList<String> strarr;
    ArrayList<Integer> weight;
    SearchEngine()
    {
         strarr = new ArrayList<String>();    
         weight = new ArrayList<Integer>();
    }
    private void insert(String s , int n)
    {
         strarr.add(s);
         weight.add(n);
    }
    private int search(String s)
    {
         int max = -1;
         for(int i = 0 ; i < strarr.size() ; i++)
         {
              int j = 0;
              int k = 0;
              while(j < s.length() && k < strarr.get(i).length())
              {
                    if(strarr.get(i).charAt(k) != s.charAt(j))
                         k++;
                    else{
                        j++;
                        k++;
                    }                
              }
              if(j == s.length())
              {
              if(max < weight.get(i))
                  max = weight.get(i);
              }
         }
         return max;
    }
    public static void main(String arg[])
    {
       SearchEngine obj = new SearchEngine();
       Scanner kb = new Scanner(System.in);
       int d = kb.nextInt();
       int que = kb.nextInt();
       while(d != 0)
       {
           String s = kb.next();
           int w = kb.nextInt();
           obj.insert(s , w);     
           d--;
       }
       while(que != 0)
       {
           String query = kb.next();
           int x = obj.search(query);
           System.out.println(x);
           que--;
       }
    }
}