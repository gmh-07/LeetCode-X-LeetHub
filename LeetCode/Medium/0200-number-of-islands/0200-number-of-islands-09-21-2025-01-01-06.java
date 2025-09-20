class Solution {
    
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int count = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    bfs(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    private void bfs(int i,int j,char[][] grid,boolean[][] visited){
        Queue<Pair> queue = new LinkedList<>();
        Pair p = new Pair(i,j);
        queue.add(p);
        while(!queue.isEmpty()){
            Pair temp = queue.remove();
            int r = temp.row;
            int c = temp.col;
            //top
            if(r>0){
                if(visited[r-1][c]==false && grid[r-1][c]=='1'){
                    queue.add(new Pair(r-1,c));
                    visited[r-1][c]= true;
                }
            }
            //bottom
            if((r+1)<grid.length){
                if(visited[r+1][c]==false && grid[r+1][c]=='1'){
                    queue.add(new Pair(r+1,c));
                    visited[r+1][c]= true;
                }
            }
            //right
            if(c<grid.length){
                if(visited[r][c+1]==false && grid[r][c+1]=='1'){
                    queue.add(new Pair(r,c+1));
                    visited[r][c+1]= true;
                }
            }
            //left
            if(c>0){
                if(visited[r][c-1]==false && grid[r][c-1]=='1'){
                    queue.add(new Pair(r,c-1));
                    visited[r][c-1]= true;
                }
            }
        }
    }
}