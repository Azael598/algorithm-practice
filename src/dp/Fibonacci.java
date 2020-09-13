package dp;

public class Fibonacci {
    class Solution1 {
        public int fib(int n) {
            int[] memo = new int[n + 1];
            for (int i = 0; i < n; i++) {
                memo[i] = 0;
            }
            return helper(memo, n);
        }

        public int helper(int[] memo, int n) {
            if (n == 1 || n == 2) return 1;
            if (memo[n] != 0) return memo[n];
            memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
            return memo[n];
        }
    }

    class Solution2 {
        int fib(int n) {
            int[] dp = new int[n + 1];
            dp[1] = dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    class Solution3 {
        int fib(int n) {
            if (n == 1 || n == 2) {
                return 1;
            }
            int pre = 1, curr = 1, sum;
            for (int i = 3; i <= n; i++) {
                sum = pre + curr;
                pre = curr % 1000000007;
                curr = sum % 1000000007;
            }
            return curr;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().new Solution1().fib(48));
        System.out.println(new Fibonacci().new Solution2().fib(48));
        System.out.println(new Fibonacci().new Solution3().fib(48));
    }
}
