class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
 List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
         for (int[] invocation : invocations) {
            int a = invocation[0], b = invocation[1];
            graph.get(a).add(b);
        }
         boolean[] suspicious = new boolean[n];
        boolean[] visited = new boolean[n];
        dfs(k, graph, suspicious, visited);
        boolean canRemove = true;
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                for (int invokedMethod : graph.get(i)) {
                    if (suspicious[invokedMethod]) {
                        canRemove = false; 
                        break;
                    }
                }
            }
            if (!canRemove) break;
        }
         List<Integer> result = new ArrayList<>();
        if (canRemove) {
            for (int i = 0; i < n; i++) {
                if (!suspicious[i]) {
                    result.add(i);
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
        }
        
        return result;
    }
        private void dfs(int node, List<List<Integer>> graph, boolean[] suspicious, boolean[] visited) {
        suspicious[node] = true;
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, suspicious, visited);
            }
        }
    }
}