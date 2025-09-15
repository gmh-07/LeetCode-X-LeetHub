class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int count = 0;

        for(int i=0;i<n;i++){
            if(isVisited[i]==false){
                bfs(i,isVisited,isConnected);
                count++;
            }
        }
        return count;
    }
    private void bfs(int start,boolean[] isVisited,int[][] isConnected){
        Queue<Integer> queue = new LinkedList<>();
        isVisited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i=0;i<isConnected.length;i++){
                if(isConnected[node][i]==1 && !isVisited[i]){
                    isVisited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}