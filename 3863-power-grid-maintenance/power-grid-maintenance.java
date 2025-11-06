import java.util.*;

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c + 1);
        for (int[] con : connections) dsu.union(con[0], con[1]);

        Map<Integer, TreeSet<Integer>> online = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            online.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0], x = q[1];
            int root = dsu.find(x);

            if (type == 1) {
                if (online.get(root).contains(x)) res.add(x);
                else res.add(online.get(root).isEmpty() ? -1 : online.get(root).first());
            } else {
                online.get(root).remove(x);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    static class DSU {
        int[] parent;
        DSU(int n) { parent = new int[n]; for (int i = 0; i < n; i++) parent[i] = i; }
        int find(int x) { return parent[x] == x ? x : (parent[x] = find(parent[x])); }
        void union(int a, int b) { parent[find(a)] = find(b); }
    }
}