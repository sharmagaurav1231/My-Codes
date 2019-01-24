import java.util.*;
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) 
    {
        PriorityQueue<Integer> p=new PriorityQueue<Integer>();
        int i, j;
        
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());
        ArrayList<Integer> C = new  ArrayList<Integer>();
        for (i = 0; i < A.size(); i++)
        {
            
            for (j = 0; j < A.size(); j++)
            {
                if (p.size() < A.size())
                    p.add(A.get(i) + B.get(j));
                else
                {
                    if (A.get(i) + B.get(j) > p.peek())
                    {    p.remove();
                        p.add(A.get(i) + B.get(j));
                    }
                    else
                        break;
                }
                
            }
            
        }
        for (i = 0; i < A.size(); i++)
        {
            C.add(p.poll());
        }
        Collections.sort(C, Collections.reverseOrder());
        return C;
    }
}