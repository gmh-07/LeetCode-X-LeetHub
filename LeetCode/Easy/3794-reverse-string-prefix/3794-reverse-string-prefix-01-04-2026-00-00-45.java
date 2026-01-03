class Solution {
    public String reversePrefix(String s, int k) {
        String str = s.substring(0,k);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString()+s.substring(k);
    }
}