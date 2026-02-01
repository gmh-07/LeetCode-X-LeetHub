class Solution {
    public int countMonobit(int n) {
        int count = 1;
        for(int i=1;i<=n;i++){
            String binary = Integer.toBinaryString(i);
            char first = binary.charAt(0);
            boolean flag = true;
            for(int j=1;j<binary.length();j++){
                if(binary.charAt(j) != first){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }

        return count;
    }
}