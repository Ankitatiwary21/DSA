class Solution {
    public int[][] sortMatrix(int[][] grid) {
     
        int n = grid.length;
        if (n <= 1) return grid;
        
        int[][] result = new int[n][n];
        
        for (int startRow = 0; startRow < n; startRow++) {
            List<Integer> diagonal = new ArrayList<>();
            int row = startRow;
            int col = 0;
            
            while (row < n && col < n) {
                diagonal.add(grid[row][col]);
                row++;
                col++;
            }
            
            Collections.sort(diagonal, Collections.reverseOrder());
            
            row = startRow;
            col = 0;
            int index = 0;
            while (row < n && col < n) {
                result[row][col] = diagonal.get(index++);
                row++;
                col++;
            }
        }
        
        for (int startCol = 1; startCol < n; startCol++) {
            List<Integer> diagonal = new ArrayList<>();
            int row = 0;
            int col = startCol;
            
            while (row < n && col < n) {
                diagonal.add(grid[row][col]);
                row++;
                col++;
            }
            
            Collections.sort(diagonal);
            
            row = 0;
            col = startCol;
            int index = 0;
            while (row < n && col < n) {
                result[row][col] = diagonal.get(index++);
                row++;
                col++;
            }
        }
        
        return result;
    }
}
