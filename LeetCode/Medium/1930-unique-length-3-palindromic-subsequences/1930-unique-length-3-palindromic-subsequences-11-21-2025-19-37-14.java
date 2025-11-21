class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] arr = new int[26][2];
        char ch = 'a';
        for(int i=0;i<26;i++){
            int left = Integer.MAX_VALUE;
            int right = Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                if(s.charAt(j)==ch){
                    left = Math.min(left,j);
                    right = Math.max(right,j);
                }
            }
            System.out.println("left : "+left+" right : "+right);
            ch++;
            arr[i][0] = left;
            arr[i][1] = right;
        }
        ch = 'a';
        int count = 0;
        for(int i=0;i<26;i++){
            HashSet<Character> set = new HashSet<>();
            int left = arr[i][0];
            int right = arr[i][1];
            if(left == Integer.MAX_VALUE || right == Integer.MIN_VALUE) continue;
            for(int j=left+1;j<right;j++){
                set.add(s.charAt(j));
            }
            System.out.println(set.size());
            count += set.size();
            ch++;
        }
        return count;
    }
}