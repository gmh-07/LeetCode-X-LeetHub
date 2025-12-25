class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList(Arrays.asList(1)));
        if(numRows == 1) return ans;
        ans.add(new ArrayList(Arrays.asList(1,1)));

        for(int i=2;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
            int len = i+1;
            list.add(1);
            int prev = i-1;

            for(int j=1;j<len-1;j++){
                int a = ans.get(prev).get(j-1);
                int b = ans.get(prev).get(j);

                list.add(a+b);
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }
}