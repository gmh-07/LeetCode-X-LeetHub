class Solution {
    public boolean squareIsWhite(String coordinates) {
        int a = coordinates.charAt(0)-'a';
        int b = coordinates.charAt(1)-'0';
        System.out.println(a);
        System.out.println(b);

        if((a+b)%2==0) return true;

        return false;
    }
}
