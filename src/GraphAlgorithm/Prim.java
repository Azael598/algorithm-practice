package GraphAlgorithm;

import java.util.Arrays;

public class Prim {
    private static final int MAXV = 1000;
    private static final int INF = Integer.MAX_VALUE;
    public int n;
    public int[][] G = new int[MAXV][MAXV];
    public int[] d = new int[MAXV];

    public int prim() {
        Arrays.fill(d, INF);
        boolean[] vis = new boolean[MAXV];
        Arrays.fill(vis, false);
        d[0] = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int u = -1, MIN = INF;
            for (int j = 0; j < n; j++) {
                if (vis[j] == false && d[j] < MIN) {
                    u = j;
                    MIN = d[j];
                }
            }
            if (u == -1) return -1;
            vis[u] = true;
            ans += d[u];
            for (int v = 0; v < n; v++) {
                if (vis[v] == false && G[u][v] != INF && G[u][v] < d[v]) {
                    d[v] = G[u][v];
                }
            }
        }
        return ans;
    }
}
