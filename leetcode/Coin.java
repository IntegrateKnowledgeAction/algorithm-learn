import java.util.Arrays;

public class Coin {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] memo;

        public int coinChange(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            memo = new int[amount + 1];
            Arrays.fill(memo, Integer.MIN_VALUE);
            return dp(coins, amount);
        }

        public int dp(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;
            if (memo[amount] != Integer.MIN_VALUE) {
                return memo[amount];
            }
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                int subProblem = dp(coins, amount - coin);
                if (subProblem == -1) {
                    continue;
                }
                res = Math.min(res, subProblem + 1);
            }
            memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
            return memo[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public int coinChange2(int[] coins, int amount) {
        // 目标金额为i时，需要dp[i]个金币
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }

}


