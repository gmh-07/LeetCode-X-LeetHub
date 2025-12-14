class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        int n = arr.length;
        int vowelsCount = countVowels(arr[0]);
        StringBuilder ans = new StringBuilder(arr[0]);
        for(int i=1;i<n;i++){
            int count = countVowels(arr[i]);
            if(count==vowelsCount){
                StringBuilder temp = new StringBuilder(arr[i]);
                String adder = " "+temp.reverse().toString();
                ans.append(adder);
            }
            else{
                ans.append(" "+arr[i]);
            }
        }
        return ans.toString();
    }
    private int countVowels(String word){
        int n = word.length();
        int count = 0;
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') count++;
        }
        return count;
    }
}