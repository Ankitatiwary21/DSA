class Solution {

    int Alice = 1;
    int Bob = 0;
    int n;

    public int miniMax(int[] stoneValue, int player, int i, int[][] t) {

        if (i >= n)
            return 0;

        if (t[player][i] != -1)
            return t[player][i];

        int result = (player == Alice) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        int stones = 0;

        for (int j = i; j < Math.min(i + 3, n); j++) {

            if (player == Alice) {

                stones += stoneValue[j];

                result = Math.max(
                    result,
                    stones + miniMax(stoneValue, Bob, j + 1, t)
                );

            } else {

                stones -= stoneValue[j];

                result = Math.min(
                    result,
                    stones + miniMax(stoneValue, Alice, j + 1, t)
                );
            }
        }

        return t[player][i] = result;
    }

    public String stoneGameIII(int[] stoneValue) {

        n = stoneValue.length;

        int[][] t = new int[2][n + 1];

        for (int[] row : t) {
            java.util.Arrays.fill(row, -1);
        }

        int diff = miniMax(stoneValue, Alice, 0, t);

        if (diff > 0)
            return "Alice";
        else if (diff < 0)
            return "Bob";

        return "Tie";
    }
}