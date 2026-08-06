class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1 && edges.length == 0) return true;
        if (edges.length != n - 1)
            return false;
        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge :edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        q.add(0);
        s.add(0);
        while(!q.isEmpty())
        {
            int node = q.poll();
            for(int nbr : adj.get(node))
            {
                if(s.contains(nbr))
                    continue;
                q.add(nbr);
                s.add(nbr);
            }
        }
        return s.size() == n;
    }
}