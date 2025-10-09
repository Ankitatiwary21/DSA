import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            long minPotion = (success + spells[i] - 1) / spells[i]; // ceil division
            int idx = lowerBound(potions, minPotion);
            res[i] = m - idx;
        }
        return res;
    }
    
    private int lowerBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}