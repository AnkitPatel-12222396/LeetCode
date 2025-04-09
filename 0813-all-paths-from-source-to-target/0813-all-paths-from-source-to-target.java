class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int dest = graph.length - 1;
        List<Integer> path = new ArrayList<>();
        dfs(graph, 0, dest, path);
        return res;
    }
    public void dfs(int[][] graph,int src,int dest,List<Integer>list){
        list.add(src);
        if(src==dest){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int nbr:graph[src]){
            dfs(graph,nbr,dest,list);
            list.remove(list.size()-1);
        }
    }

    
}