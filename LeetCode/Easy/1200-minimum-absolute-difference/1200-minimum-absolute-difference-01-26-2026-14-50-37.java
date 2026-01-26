class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            min = Math.min(min,Math.abs(arr[i-1]-arr[i]));
        }
        System.out.print(min);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<n;i++){
            ArrayList<Integer> list = new ArrayList<>();
            if(Math.abs(arr[i-1]-arr[i]) == min){
                list.add(arr[i-1]);
                list.add(arr[i]);
            }
            if(list.size() != 0){
                ans.add(list);
            }
        }
        return ans;
    }
}