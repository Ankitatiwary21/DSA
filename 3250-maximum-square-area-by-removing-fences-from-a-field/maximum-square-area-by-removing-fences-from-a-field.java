class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final long MOD = 1_000_000_007;
        List<Integer> hList = new ArrayList<>();
        List<Integer> vList = new ArrayList<>();
        
        hList.add(1); hList.add(m);
        vList.add(1); vList.add(n);
        
        for (int hf : hFences) hList.add(hf);
        for (int vf : vFences) vList.add(vf);
        
        Collections.sort(hList);
        Collections.sort(vList);
        
        Set<Integer> hDiffs = getDiffs(hList);
        Set<Integer> vDiffs = getDiffs(vList);
        
        long maxSide = -1;
        for (int d : hDiffs) {
            if (vDiffs.contains(d)) {
                maxSide = Math.max(maxSide, d);
            }
        }
        return maxSide == -1 ? -1 : (int)((maxSide * maxSide) % MOD);
    }
    
    private Set<Integer> getDiffs(List<Integer> list) {
        Set<Integer> diffs = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                diffs.add(list.get(j) - list.get(i));
            }
        }
        return diffs;
    }
}