public class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] magicSquares = {
            {8, 1, 6, 3, 5, 7, 4, 9, 2},
            {6, 1, 8, 7, 5, 3, 2, 9, 4},
            {4, 9, 2, 3, 5, 7, 8, 1, 6},
            {2, 9, 4, 7, 5, 3, 6, 1, 8},
            {8, 3, 4, 1, 5, 9, 6, 7, 2},
            {4, 3, 8, 9, 5, 1, 2, 7, 6},
            {6, 7, 2, 1, 5, 9, 8, 3, 4},
            {2, 7, 6, 9, 5, 1, 4, 3, 8}
        };
        
        for (int r = 0; r <= rows - 3; r++) {
            for (int c = 0; c <= cols - 3; c++) {
                int[] subgrid = new int[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        subgrid[i * 3 + j] = grid[r + i][c + j];
                    }
                }
                for (int[] magicSquare : magicSquares) {
                    if (matches(subgrid, magicSquare)) {
                        count++;
                        break;
                    }
                }
            }
        }
        
        return count;
    }
    
    private boolean matches(int[] grid, int[] magicSquare) {
        for (int i = 0; i < 9; i++) {
            if (grid[i] != magicSquare[i]) {
                return false;
            }
        }
        return true;
    }
}