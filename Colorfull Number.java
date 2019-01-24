import java.util.*;
public class Solution {
    public int check(int x)
    {
        int r;
        int p=1;
        while(x>0)
        {
            r=x%10;
            p=p*r;
            x=x/10;
        }
        return p;
    }
    public int colorful(int A) {
        String str = Integer.toString(A);
        int len = str.length();
        int i,j;
        int x;
        int product;
        String res;
        HashSet<Integer> h=new HashSet<Integer>();
        for(i=0;i<len;i++)
        {
            for(j=i;j<len;j++)
            {
                res=str.substring(i,j+1);
                x=Integer.valueOf(res);
                product=check(x);
                if(h.contains(product))
                  return 0;
                else
                  h.add(product);
            }
        }
        return 1;
    }
}
