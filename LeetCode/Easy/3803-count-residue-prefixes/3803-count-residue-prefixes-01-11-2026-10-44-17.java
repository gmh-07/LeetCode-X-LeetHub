class Solution {
    public int residuePrefixes(String s) {
        Set<Character> f = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < s.length(); ++i) {
            f.add(s.charAt(i));
            if(f.size() == (i + 1) % 3) ++ans;
        }
        return ans;
    }
}