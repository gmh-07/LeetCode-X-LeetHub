class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        HashMap<Integer,Character> map = new HashMap<>();
        char ch = 'z';
        for(int i=0;i<26;i++){
            map.put(i,ch);
            ch--;
        }
        // System.out.println(map);
        HashMap<Character,Integer> letterWeight = new HashMap<>();
        ch = 'a';
        for(int i=0;i<26;i++){
            letterWeight.put(ch,weights[i]);
            ch++;
        }
        // System.out.println(letterWeight);
        String ans = "";
        for(String word : words){
            int sum = 0;
            for(char c:word.toCharArray()){
                sum += letterWeight.get(c);
            }
            ans += map.get(sum%26);
        }
        return ans;
    }
}