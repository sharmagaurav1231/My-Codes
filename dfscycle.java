import java.util.*;
enum color
{
    WHITE,GREY,BLACK;
}
class dfscycle
{
    int v;
    color id[];
    int parent[];
    int fuv[];
    int depth[];
    int edge;
    int d;
    int indeg[];
    ArrayList<ArrayList<Integer>> adj;
    dfscycle(int v)
    {
         this.v = v;
         id = new color[v];
         parent = new int[v];
         fuv = new int[v];
         depth = new int[v];
         d = 0;
         indeg = new int[v];
         //outer_edge = new int[v];
         adj = new ArrayList<ArrayList<Integer>>();
         for(int i = 0 ; i < v ; i++)
         {
             adj.add(new ArrayList<Integer>());
             id[i] = color.WHITE;
         }  
    }
    void addEdge(int x , int y)
    {
         adj.get(x).add(y);
         adj.get(y).add(x);
    }
    /*int detectCycle(int start , int p)
    {
        id[start] = color.GREY;
        parent[start] = p;
        Iterator<Integer> it = adj.get(start).iterator();
        while(it.hasNext())
        {
            int x = it.next();
            if(id[x] == color.WHITE)
            {
                 detectCycle(x , start);
            }
            if(id[x] == color.GREY && parent[start] != x)
            {
                return 1;
            }
        }
        id[start] = color.BLACK;
        return  0;
    }*/
    /*int min(int x , int y)
    {
         if(x < y)
            return x;
         return y;
    }*/
    /*int bridgeEdge(int start , int p , int dd)
    {
       depth[start] = dd;
       fuv[start] = depth[start];
       id[start] = color.GREY;
       Iterator<Integer> it = adj.get(start).iterator();
       while(it.hasNext())
       {
          int x =it.next();
          if(id[x] == color.WHITE)
          {
              parent[x] = start;
              bridgeEdge(x , start , dd + 1);
              fuv[start] = min(fuv[start] , fuv[x]); 
              if(fuv[x] > depth[start])
                 edge++;
          }
          else
          {
              if(parent[start] != x) 
              {
                  fuv[start] = min(fuv[start] , depth[x]);   
              }
          }
       }
       id[start] = color.BLACK;
       return edge;    
    }*/
    /*void print()
    {
       for(int i = 0 ; i < v ; i++)
       {
            System.out.println(fuv[i]);
       }
    }*/
    /*void bfs(int start)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        id[start] = color.GREY;
        q.add(start);
        while(q.peek() != null)
        {
            int x = q.poll();
            Iterator<Integer> it = adj.get(x).iterator();
            while(it.hasNext())
            {
                int y = it.next();
                if(id[y] == color.WHITE)
                {
                     id[y] = color.GREY;//
                     q.add(y);
                }
            }
        }
    }*/
   public ArrayList<Integer> topologicOrder()
   {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0 ; i < v ; i++)
        {
            for(int j = 0 ; j < adj.get(i).size() ; j++)
            {
                 int x = adj.get(i).get(j);
                 indeg[x]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0 ; i < v ; i++)
        {
             if(indeg[i] == 0)
               q.add(i);
        }
        while(q.peek() != null)
        {
             int x = q.poll();
             res.add(x);
             for(int i = 0 ; i < adj.get(x).size() ; i++)
             {
                  int y = adj.get(x).get(i);
                  if(id[y]== color.WHITE)
                  {
                      indeg[y]--;
                      if(indeg[y] == 0)
                      {
                           q.add(y);
                           id[y] = color.GREY;
                      }
                  }
             }
        }
        return res;
   }
    public static void main(String arg[])
    {
        dfscycle obj = new dfscycle(6);
        obj.addEdge(0,1);
        obj.addEdge(0,2);
        obj.addEdge(2,3);
        obj.addEdge(1,5);
        obj.addEdge(3,4);
        obj.addEdge(2,4);
        obj.addEdge(0,5);
        obj.addEdge(0,4);
        /*int check = obj.detectCycle(0,-1);
        if(check == 1)
         System.out.println("Cycle");
        else
         System.out.println("Cycle not present");*/
        //int edges = obj.bridgeEdge(0 , -1 , 0);
        //System.out.println(edges);
        //obj.print();
        //obj.bfs(0);
        ArrayList<Integer> res = new ArrayList<Integer>();
        res = obj.topologicOrder();
    }   
}