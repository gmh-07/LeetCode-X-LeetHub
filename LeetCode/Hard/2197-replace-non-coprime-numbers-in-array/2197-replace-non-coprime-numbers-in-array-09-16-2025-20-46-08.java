class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            long temp = num; // use long for intermediate LCM
            while (!ans.isEmpty()) {
                int last = ans.get(ans.size() - 1);
                int g = gcd((int) temp, last);
                if (g == 1) break; // coprime now
                ans.remove(ans.size() - 1);
                temp = lcm(temp, last, g);
            }
            ans.add((int) temp); // safe cast back to int if guaranteed within bounds
        }
        return ans;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // compute LCM safely using gcd
    private static long lcm(long a, long b, long g) {
        return a / g * b; // avoids overflow
    }
}
