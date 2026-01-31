class Solution {
    public String reverseByType(String s) {
        int n = s.length();
        StringBuilder letters = new StringBuilder("");
        StringBuilder special = new StringBuilder("");
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z') letters.append(ch);
            else special.append(ch);
        }
        letters.reverse();
        special.reverse();
        
        StringBuilder ans = new StringBuilder("");
        int idx1 = 0;
        int idx2 = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                ans.append(letters.charAt(idx1));
                idx1++;
            }
            else {
                ans.append(special.charAt(idx2));
                idx2++;
            }
        }

        return ans.toString();
    }
}