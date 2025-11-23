class Solution {
    public long sumAndMultiply(int n) {
        String str = String.valueOf(n);
        StringBuilder sb = new StringBuilder("");
        long sum = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch-'0'!=0){
                sb.append(ch);
                sum += (ch-'0');
            }
        }
        long sbToInt = Integer.parseInt(sb.toString());
        long ans = sbToInt*sum;
        return ans;
    }
}