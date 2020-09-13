package dp;

import java.util.Arrays;

/**
 * k个鸡蛋，N层楼
 * 鸡蛋个数限制了最少尝试次数
 * 最坏情况：搜索区间穷尽，即其它楼层都排除，只剩下最后一个楼层没有检验
 * base case:N=0,次数为0，K=1，只能线性搜索，次数为N
 */
public class superEggDrop {
    class Solution {
        int superEggDrop(int K, int N) {
            int[][] dp = new int[K + 1][N + 1];
            for (int i = 0; i <= K; i++) {
                Arrays.fill(dp[i], 9999);
            }
            //init
            for (int i = 0; i <= K; i++) {
                dp[i][0] = 0;
            }
            dp[0][1] = 0;
            for (int i = 1; i <= K; i++) {
                dp[i][1] = 1;
            }
            for (int j = 0; j <= N; j++) {
                dp[0][j] = 0;
                dp[1][j] = j;
            }
            for (int j = 2; j <= N; j++) {
                for (int i = 2; i <= K; i++) {
                    for (int k = 1; k <= j; k++) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k - 1], dp[i][j - k]) + 1);
                    }
                }
            }
            return dp[K][N];
        }
    }
    class Solution1 {
        int superEggDrop(int K, int N) {
            int[][] dp = new int[K + 1][N + 1];
            for (int i = 0; i <= K; i++) {
                Arrays.fill(dp[i], 9999);
            }
            //init
            for (int i = 0; i <= K; i++) {
                dp[i][0] = 0;
            }
            dp[0][1] = 0;
            for (int i = 1; i <= K; i++) {
                dp[i][1] = 1;
            }
            for (int j = 0; j <= N; j++) {
                dp[0][j] = 0;
                dp[1][j] = j;
            }
            for (int j = 2; j <= N; j++) {
                for (int i = 2; i <= K; i++) {
                    int left=1;
                    int right=j;
                    while(left<=right){
                        int mid=left+(right-left)/2;
                        int breakCount =dp[i-1][mid-1];
                        int notBreakCount=dp[i][j-mid];
                        if (notBreakCount==breakCount){
                            left=mid;
                            break;
                        }
                        if (breakCount>notBreakCount){
                            right=mid-1;
                        }
                        else {
                            left=mid+1;
                        }
                    }
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][left - 1], dp[i][j - left]) + 1);
                }
            }
            return dp[K][N];
        }
    }

    public static void main(String[] args) {
        System.out.println(new superEggDrop().new Solution().superEggDrop(8, 10000));
        System.out.println(new superEggDrop().new Solution1().superEggDrop(8, 10000));
    }
}
