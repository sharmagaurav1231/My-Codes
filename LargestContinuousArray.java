public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        int i;
        int sum = 0;
        int count = 0;
        int max = 0;
        HashMap<Integer , Integer> hm = new HashMap<Integer , Integer>();
        hm.put(0 , -1);
        int strt = 0;
        int end = 0;
        for(i = 0 ; i < A.size() ; i++)
        {
            sum = sum + A.get(i);
            if(hm.containsKey(sum))
            {
                count = i - hm.get(sum);
                if(count > max)
                 {
                    max = count;
                    strt = hm.get(sum) + 1;
                    end = i;
                 }
            }   
            else
            {
                hm.put(sum , i);
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>(max);
        if(max == 0)
          return res;
        else
        {
        for(i = strt ; i <= end ; i++)
        {
            res.add(A.get(i));
        }
        return res;
        }
