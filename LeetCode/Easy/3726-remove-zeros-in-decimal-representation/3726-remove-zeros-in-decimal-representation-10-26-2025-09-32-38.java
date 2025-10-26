class Solution {
    public long removeZeros(long n) {
        String str = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for(char ch:str.toCharArray()){
            if(ch != '0'){
                sb.append(ch);
            }
        }
        return Long.parseLong(sb.toString());
    }
}