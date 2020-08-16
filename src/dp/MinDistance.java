package dp;

import sun.font.CreatedFontTracker;

public class MinDistance {
    //dp[i][j]等于word1[0...i-1]和word2[0...j-1]的最少操作数
    class Solution1 {
        public int minDistance(String word1, String word2) {
            char[] word1Array = word1.toCharArray();
            char[] word2Array = word2.toCharArray();
            int len1 = word1Array.length;
            int len2 = word2Array.length;
            int[][] dp = new int[len1 + 1][len2 + 1];

            for (int i = 1; i <= len1; i++) {
                //如果j=0，那么word1还剩i个元素，则还需要进行i次操作
                dp[i][0] = i;
            }
            for (int j = 1; j <= len2; j++) {
                dp[0][j] = j;
            }

            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    if (word1Array[i] == word2Array[j]) {
                        dp[i + 1][j + 1] = dp[i][j];
                        continue;
                    }
                    int insert = dp[i + 1][j] + 1;
                    int replace = dp[i][j] + 1;
                    int delete = dp[i][j + 1] + 1;
                    dp[i + 1][j + 1] = Math.min(Math.min(insert, replace), delete);
                }
            }
            return dp[len1][len2];
        }
    }
}
