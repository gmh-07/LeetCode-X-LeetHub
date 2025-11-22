class Solution {
    public int minimumFlips(int n) {
        String s=Integer.toBinaryString(n);

        String s1 = new StringBuilder(s).reverse().toString();
        int count=0;
        for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)!=s1.charAt(i))count++;
            }
        return count;
    }
}