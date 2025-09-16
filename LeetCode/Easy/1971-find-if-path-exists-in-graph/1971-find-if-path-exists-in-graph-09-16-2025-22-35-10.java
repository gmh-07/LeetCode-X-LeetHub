class Solution {
    public boolean validPath(int n, int[][] edges, int s, int d) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            adjList.add(list);
        }
        int len = edges.length;
        for(int i=0;i<len;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while(!queue.isEmpty()){
            if(visited[d]==true) return true;
            int curr = queue.poll();
            for(int i=0;i<adjList.get(curr).size();i++){
                int node = adjList.get(curr).get(i);
                if(visited[node]==false){
                    visited[node]=true;
                    queue.add(node);
                }
                if(visited[d]==true) return true;
            }
        }
        return false;
    }
}