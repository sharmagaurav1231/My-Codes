public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> twoSum(final List<Integer> A, int b) {
        HashMap<Integer , Integer> hm  = new HashMap<Integer , Integer>();
        int i,j;
        int num = 0;
        int f=0;
        ArrayList<Integer> res = new ArrayList<Integer>(2);
        for(i = 0 ; i < A.size() ; i++)
        {
            if(hm.containsKey(b - A.get(i)))
            {
                res.add(hm.get(b-A.get(i))+1);
                res.add(i+1);
                return res;
            }
            if(!(hm.containsKey(A.get(i))))
            {
                hm.put(A.get(i),i);
            }
        }
                ArrayList<Integer> re1 = new ArrayList<Integer>(0);
                return re1;
    }
}
