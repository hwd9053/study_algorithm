package 数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/boats-to-save-people/
 */
public class _881_救生艇 {
    // 贪心
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int li = 0, ri = people.length - 1;
        int ans = 0;

        while(li <= ri) {
            int remain = limit - people[ri];
            if (remain >= people[li]) {
                li++;
            }
            ri--;
            ans++;
        }

        return ans;
    }
}
