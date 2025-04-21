class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, res, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> res, int start, List<Integer> temp) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], res, i, temp); 
            temp.remove(temp.size() - 1); }

    }
}
