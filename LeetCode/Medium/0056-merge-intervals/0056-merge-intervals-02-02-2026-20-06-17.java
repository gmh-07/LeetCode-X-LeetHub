class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        for(int[] interval : intervals){
            if(result.isEmpty()){
                result.add(interval);
            }
            else if(result.get(result.size()-1)[1] < interval[0]){
                result.add(interval);
            }
            else{
                int[] temp = new int[2];
                temp[0] = result.get(result.size()-1)[0];
                temp[1] = Math.max(result.get(result.size()-1)[1],interval[1]);
                result.remove(result.size()-1);
                result.add(temp);
            }
        }

        int[][] ans = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            ans[i] = result.get(i);
        }
        return ans;
    }
}