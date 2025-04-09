class Graph {
    public int n;
    public ArrayList<Integer>[] adj;
    public Graph(int n) {
        this.n = n;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }
    // unweighted, undirected graph
    public void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src);
    }
    public boolean haspath(int src,int dest,boolean vis[])
   {if(src==dest) return true;
    else vis[src] = true;
    for(int i:adj[src]){
        if(i==dest) return true;
        else if(vis[i]==true) continue;
        else{            
            vis[i] = true;
            if(haspath(i,dest,vis)){
                return true;
            }
        }
    }
    return false;
   }

}

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph g= new Graph(n);
        for(int []edge: edges)
        {
            g.addEdge(edge[0],edge[1]);
        }
        boolean visted[]= new boolean[n];
       return  g.haspath(source,destination,visted);


    }
}