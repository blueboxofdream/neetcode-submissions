class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int INF = 2147483647;
        int r = grid.length, c = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j] == 0)
                    q.offer(new int[]{i,j});
            }
        }

        int[] rowIdx = {0,0,-1,1};
        int[] colIdx = {1,-1,0,0};
        while(!q.isEmpty())
        { 
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            for(int k=0;k<4;k++)
            {
                int ii = i + rowIdx[k];
                int jj = j + colIdx[k];

                if(ii<0 || jj<0 || ii>=r || jj>=c || grid[ii][jj] != INF)
                    continue;
                grid[ii][jj] = grid[i][j] + 1;
                q.offer(new int[]{ii,jj});
            }
        }
    }
}
