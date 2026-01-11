class Solution {
    public int residuePrefixes(String s) {
        int n = s.length();
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<n;i++){
            int len = i+1;
            set.add(s.charAt(i));
            if(len%3 == set.size()) count++;
        }
        return count;
    }
}