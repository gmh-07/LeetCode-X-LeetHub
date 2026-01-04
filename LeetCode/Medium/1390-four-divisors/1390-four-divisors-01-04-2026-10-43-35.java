class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num:nums){
            int sum = 1+num;
            int count = 2;
            for(int i=2;i<=num/2;i++){
                if(count > 4) break;
                if(num%i == 0){
                    count++;
                    sum += i;
                }
            }
            if(count == 4){
                total += sum;
            }
        }
        return total;
    }
}