class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int count = 0;
        int[] visited = new int[n];
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] edge:edges)
        {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<n;i++)
        {
            if(visited[i] == 0)
            {
                count++;
                dfs(adj,visited,i);
            }
        }
        return count;
    }
    public void dfs(List<List<Integer>> adj, int[] visited, int node) {
        visited[node] = 1;
        for(int nbr : adj.get(node))
        {
            if(visited[nbr] == 0)
                dfs(adj,visited,nbr);
        }
    }
}
