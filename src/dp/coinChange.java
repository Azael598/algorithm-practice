package dp;

import java.util.Arrays;

public class coinChange {
    class Solution1 {
        int[] memo;

        public int coinChange(int[] coins, int amount) {
            if (coins.length == 0) {
                return -1;
            }
            memo = new int[amount+1];
            return findWay(coins, amount);
        }

        public int findWay(int[] coins, int amount) {
            int subproblem;
            if (amount < 0) {
                return -1;
            }
            if (amount == 0) {
                return 0;
            }
            if (memo[amount] != 0) {
                return memo[amount];
            }
            int res = Integer.MAX_VALUE;
            for (int coin :
                    coins) {
                subproblem = findWay(coins, amount - coin);
                if (subproblem == -1) {
                    continue;
                }
                res = Math.min(res, subproblem + 1);
            }
            memo[amount] = res != Integer.MAX_VALUE ? res : -1;
            return memo[amount];
        }
    }
    class Solution2{
        public int coinChange(int[] coins, int amount){
            if (coins.length == 0){
                return -1;
            }
            int[] dp = new int[amount+1];
            Arrays.fill(dp,amount+1);
            dp[0] = 0;
            for (int i = 0; i < dp.length; i++){
                for (int coin : coins){
                    if (i - coin < 0)continue;
                    dp[i] = Math.min(dp[i], dp[i - coin]+1);
                }
            }
            return (dp[amount] == amount+1) ? -1 : dp[amount];
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        System.out.println(new coinChange().new Solution1().coinChange(coins,amount));
        System.out.println(new coinChange().new Solution2().coinChange(coins,amount));
    }
}
