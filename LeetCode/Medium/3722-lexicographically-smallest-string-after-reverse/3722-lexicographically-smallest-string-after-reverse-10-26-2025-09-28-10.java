class Solution {
    public String lexSmallest(String s) {
        int n = s.length();
        String ans = s;
        for(int k=1;k<=n;k++){
            String prefixRevStr = buildRev(s,0,k-1)+s.substring(k);

            if(prefixRevStr.compareTo(ans)<0){
                ans = prefixRevStr;
            }

            String suffRevStr = s.substring(0,n-k)+buildRev(s,n-k,n-1);

            if(suffRevStr.compareTo(ans)<0){
                ans = suffRevStr;
            }
        }
        return ans;
    }
    private String buildRev(String s,int left,int right){
        char[] chars = s.toCharArray();
        StringBuilder rev = new StringBuilder();
        for(int i=right;i>=left;i--){
            rev.append(chars[i]);
        }
        return rev.toString();
    }
}