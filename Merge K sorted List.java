public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> a) 
    {
        PriorityQueue<ListNode> que = new PriorityQueue(a.size(),new Comparator<ListNode>()
                                                      {
                                                          public int compare(ListNode x,ListNode y)
                                                          {
                                                              return x.val - y.val;
                                                          }
                                                      });
        
        for(int i = 0 ; i < a.size() ; i++ )
        {
            que.add(a.get(i));
        }
        
        ListNode res = new ListNode(0);
        ListNode x=res;
        while(que.size()>0)
        {
            ListNode temp = que.poll();
            x.next=temp;
            if(temp.next!=null)
            {
                que.add(temp.next);
            }
            x=x.next;
            
        }
        
        return res.next;
    }
}
