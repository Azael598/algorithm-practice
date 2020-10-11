package dp;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

public class maxProfit {
    class question1 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n == 0) {
                return 0;
            }
            int[][] dp = new int[n][2];
            for (int i = 0; i < n; i++) {
                if (i - 1 == -1) {
                    dp[i][0] = 0;
                    dp[i][1] = -prices[i];
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                //因为只有一次买卖机会，所以dp[i-1][0]=0
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
            return dp[n - 1][0];
        }

        public int maxProfitS2(int[] prices) {
            int n = prices.length;
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, -prices[i]);
            }
            return dp_i_0;
        }
    }

    class question2 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
            }
            return dp_i_0;
        }
    }

    class question309 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            int dp_pre_0 = 0;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
                dp_pre_0 = temp;
            }
            return dp_i_0;
        }
    }

    class question714 {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
            }
            return dp_i_0;
        }
    }

    class question3 {
        public int maxProfit(int[] prices, int fee) {
            int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
            int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
            for (int price : prices) {
                dp_i20 = Math.max(dp_i20, dp_i21 + price);
                dp_i21 = Math.max(dp_i21, dp_i10 - price);
                dp_i10 = Math.max(dp_i10, dp_i11 + price);
                dp_i11 = Math.max(dp_i11, -price);
            }
            return dp_i20;
        }
    }

    class question4 {
        public int maxProfit(int max_k, int[] prices) {
            int n = prices.length;
            if (max_k > n / 2) {
                return new maxProfit().new question2().maxProfit(prices);
            }
            int[][][] dp = new int[n][max_k + 1][2];
            for (int i = 0; i < n; i++) {
                for (int k = max_k; k >= 1; k--) {
                    if (i - 1 == -1) {
                        dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                        dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                    }
                }
            }
            return dp[n - 1][max_k][0];
        }
    }


    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int[] nullArray = new int[0];
        System.out.println(new maxProfit().new question1().maxProfit(nullArray));
    }
}
