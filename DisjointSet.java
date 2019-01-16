import java.util.*;
class DisjointSet
{
    int v;
    int e;
    ArrayList<Edge> arr;
    subset ar[];
    public DisjointSet(int v , int e)
    {
         this.v = v;
         this.e = e;
         arr = new ArrayList<Edge>();
         ar =  new subset[v];
         for(int i = 0 ; i < v ; i++)
         {
              ar[i] = new subset(i);
         }
         for(int i = 0 ; i < e ; i++)
         {
              arr.add(new Edge());
         }
    }
    public int compare(Edge a , Edge b)
         {
              return a.weight -  b.weight;
         }
    public void enterValue()
    {
         Scanner kb = new Scanner(System.in);
         for(int i = 0 ; i < e ; i++)
         {
             System.out.println("Enter the source:");
             int src = kb.nextInt();
             System.out.println("Enter the Destination:");
             int dest = kb.nextInt();
             System.out.println("Enter the Weight of the Edge:");
             int weight = kb.nextInt();
             arr.get(i).value(src,dest,weight);
         }
         /*arr[0].value(0,1);
         arr[1].value(1,2);
         arr[2].value(3,4);
         arr[3].value(5,6);
         arr[4].value(4,5);
         arr[5].value(2,6);*/ 
    }
    static class sortByWeight implements Comparator<Edge>
    {
         public int compare(Edge a , Edge b)
         {
              return a.weight -  b.weight;
         }
    }
    public void print()
    {
         System.out.println("src dest weight");
         for(int i = 0 ; i < e ; i++)
         {
              System.out.println(arr.get(i).src + "    " + arr.get(i).dest + "    " + arr.get(i).weight);
         }
    }
    class Edge
    {
         int src;
         int dest;
         int weight;
         public void value(int src , int dest , int weight)
         {
             this.src = src;
             this.dest = dest;
             this.weight = weight;
         }
    }
    class subset
    {
         int parent;
         int rank;
         subset(int n)
         {
             parent = n;
             rank = 0;
         }
    }
    static class Kruskal
    {
     int v;
     ArrayList<Edge> res;
     Kruskal(int v)
     {
          this.v = v;
          res = new ArrayList<Edge>();
     }
     public int findLeader(subset [] ar , int n)
     {
         if(ar[n].parent != n)
         {
             ar[n].parent = findLeader(ar,ar[n].parent);
         }
             return ar[n].parent;   
     }   
     public void union(subset [] ar,int src , int dest)
     {
         int x = findLeader(ar,src);
         int y = findLeader(ar,dest);
         
         if(ar[x].rank > ar[y].rank)
         {
              ar[y].parent = x;
         }       
         else if(ar[x].rank < ar[y].rank)
              {
                   ar[x].parent = y;
              }
              else if(ar[x].parent == ar[y].parent)
                   {
                        ar[y].parent = x;
                        (ar[x].rank)++;
                   }
     }
     public void minSpanTree(subset[] ar, Edge obj)
     {
          int ps = findLeader(ar , obj.src);
          int pd = findLeader(ar , obj.dest);
          if(ps == pd)
             return;
          union(ar , obj.src , obj.dest);   
          res.add(obj);
     }
    }
    public static void main(String arg[])
    {
         Scanner kb = new Scanner(System.in);
         System.out.println("Enter the number of vertices:");
         int v = kb.nextInt();
         System.out.println("Enter the number of Edges:");
         int e = kb.nextInt();    
         DisjointSet obj = new DisjointSet(v,e);
         obj.enterValue();
         Collections.sort(obj.arr , new sortByWeight());
         obj.print();
         Kruskal kk = new Kruskal(v);
         for(int i = 0 ; i < obj.e ; i++)
         {
             kk.minSpanTree(obj.ar,obj.arr.get(i));
         }
    }
}

/* kumar.garg@gmail.com */