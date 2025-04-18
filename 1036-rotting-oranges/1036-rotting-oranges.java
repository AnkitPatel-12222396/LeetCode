class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]>q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                // if(grid[i][j]==0) continue;
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.offer(new int[]{i,j});
                
            }
        }

        int count=0;
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            if(fresh==0) return count;
            int size = q.size();
            count++;
            for(int i=0;i<size;i++){
                int []pair = q.poll();
                for(int d=0;d<4;d++){
                    int x = pair[0]+dir[d][0];
                    int y = pair[1]+dir[d][1];

                    if(x>=0&&x<grid.length &&y>=0&&y<grid[0].length){
                        if(grid[x][y]==1) {
                            grid[x][y]=2;
                            q.offer(new int[]{x,y});
                            fresh--;

                        }
                    }
                }


            }
        }
        return fresh==0?count:-1;
    }
}