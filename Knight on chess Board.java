public class Solution {
    int dir[][] = { {-1 , -2} , {-1 , 2} , {1 , -2} , {1 , 2} , {-2 , -1} , {2, -1} , {-2 , 1} , {2 ,1}};
    class cord{
        int x;
        int y;
        cord(int x , int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public int knight(int A, int B, int C, int D, int E, int F) {
        Queue<cord> q = new LinkedList<cord>();
        boolean visited[][] = new boolean[A+1][B+1];
        visited[C][D] = true;
        q.add(new cord(C,D));
        int count = 0;
        while(!q.isEmpty())
        {
            int s = q.size();
            for(int i = 0 ; i < s ; i++)
            {
                cord obj = q.poll();
                int x = obj.x;
                int y = obj.y;
                if(x == E && y == F)
                    return count;
                for(int j = 0 ; j < dir.length ; j++)
                {
                    int newx = x + dir[j][0];
                    int newy = y + dir[j][1];
                    if(isValid(newx , newy , A , B , visited) == 1)
                    {
                        visited[newx][newy] = true;
                       q.add(new cord(newx , newy));
                    }
                }
            }
            count++;
        }
        return -1;
    }
    private int isValid(int x , int y , int A , int B , boolean visited[][])
    {
        if(x >= 1 && x <= A && y >= 1 && y <= B && visited[x][y] == false)
            
          return 1;
         return 0;
    }
}
