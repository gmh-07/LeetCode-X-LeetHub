class Solution {
    public List<List<String>> wordSquares(String[] words) {
        int n = words.length;
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(words);
        for(int i=0;i<n;i++){
            String top = words[i];
            for(int j=0;j<n;j++){
                if(j==i) continue;
                String left = words[j];
                for(int k=0;k<n;k++){
                    if(k==i || k==j) continue;
                    String right = words[k];
                    for(int l=0;l<n;l++){
                        if(l==i || l==j || l==k) continue;
                        String bottom = words[l];
                        if(isValid(top,left,right,bottom)){
                            List<String> list = new ArrayList<>();
                            list.add(top);
                            list.add(left);
                            list.add(right);
                            list.add(bottom);
                            ans.add(list);
                        }
                    }
                }
            }
        }
        return ans;
    }
    private boolean isValid(String top,String left,String right,String bottom){
        if(top.charAt(0) == left.charAt(0) && top.charAt(3) == right.charAt(0) && bottom.charAt(0) == left.charAt(3) && bottom.charAt(3) == right.charAt(3)){
            return true;
        }
        return false;
    }
}