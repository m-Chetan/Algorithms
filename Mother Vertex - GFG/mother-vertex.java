//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find a Mother Vertex in the Graph.
    //Kosaraju
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        Stack<Integer> stk = new Stack<>();
        boolean[] visited = new boolean[V];
      
        for(int i=0;i<V;i++){
            if(visited[i] == false){
                dfs(i,adj,stk,visited);
            }
        }
        
        visited = new boolean[V];

        int ans = stk.peek();
        
        dfs(ans,adj,new Stack<>(),visited);
        
        for(boolean vis:visited){
            if(vis == false) return -1;
        }
        
        return ans;
           
    }
    
    private void dfs(int src,ArrayList<ArrayList<Integer>> adj, Stack<Integer> stk, boolean[] visited){
        
        if(visited[src] == true) return;
        
        visited[src] = true;
        
        for(int nbr:adj.get(src)){
            if(visited[nbr] == false){
                dfs(nbr,adj,stk,visited);
               
            }
        }
        
         stk.add(src);
        
    }
}