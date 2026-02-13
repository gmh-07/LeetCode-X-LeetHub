class Solution {
public:
    int longestBalanced(string s) {
        int n = (int)s.size();
        int ans = 0;
        
        // Longest run of a single character (balanced substring with one letter)
        int run = 1;
        for (int i = 1; i < n; i++) {
            if (s[i] == s[i - 1]) run++;
            else {
                ans = max(ans, run);
                run = 1;
            }
        }
        if (n) ans = max(ans, run);

        // Lambda for two-character balanced substring, excluding third character
        auto solve_pair = [&](char x, char y) {
            int diff = 0;
            unordered_map<int, int> mp;
            bool in_segment = false;
            for (int i = 0; i < n; i++) {
                if (s[i] == x || s[i] == y) {
                    if (!in_segment) {
                        in_segment = true;
                        mp.clear();
                        diff = 0;
                        mp[0] = i - 1;
                    }
                    diff += (s[i] == x) ? 1 : -1;
                    if (mp.count(diff)) {
                        ans = max(ans, i - mp[diff]);
                    } else {
                        mp[diff] = i;
                    }
                } else {
                    in_segment = false;
                }
            }
        };

        solve_pair('a', 'b');
        solve_pair('a', 'c');
        solve_pair('b', 'c');

        // Three character balanced substring with all three letters
        long long ca = 0, cb = 0, cc = 0;
        unordered_map<long long, int> first;
        auto enc = [](long long x, long long y) {
            return (x << 32) ^ (y & 0xffffffffLL);
        };
        first[enc(0, 0)] = -1;

        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') ca++;
            else if (s[i] == 'b') cb++;
            else cc++;

            long long key = enc(ca - cb, ca - cc);
            if (first.count(key)) {
                ans = max(ans, i - first[key]);
            } else {
                first[key] = i;
            }
        }
        return ans;
    }
};