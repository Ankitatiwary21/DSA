import java.util.Arrays;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[26][26];

        // Initialize the distance matrix with a large value representing infinity
        for (long[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // The cost to change a character to itself is zero
        for (int i = 0; i < 26; i++) {
            dist[i][i] = 0;
        }

        // Fill the initial distances from the given arrays
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }

        // Apply the Floyd-Warshall algorithm to find the shortest paths
        for (int node = 0; node < 26; node++) {
            for (int u = 0; u < 26; u++) {
                for (int v = 0; v < 26; v++) {
                    if (dist[u][node] < Integer.MAX_VALUE && dist[node][v] < Integer.MAX_VALUE) {
                        dist[u][v] = Math.min(dist[u][v], dist[u][node] + dist[node][v]);
                    }
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i)) continue;
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (dist[from][to] >= Integer.MAX_VALUE) return -1;
            ans += dist[from][to];
        }
        return ans;
    }
}