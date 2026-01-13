class Solution {
    public double separateSquares(int[][] squares) {
        double area = 0;
        for (int[] square : squares) {
            double l = square[2];
            area += l * l;
        }

        double minY = 0;
        double maxY = 0;
        for (int[] square : squares) {
            maxY = Math.max(maxY, square[1] + square[2]);
        }

        double temp = 1e-5;
        while (maxY - minY > temp) {
            double midY = (minY + maxY) / 2;
            double alow = calculateAreaBelow(squares, midY);

            if (alow < area / 2) {
                minY = midY;
            } else {
                maxY = midY;
            }
        }
        return minY;
    }

    private double calculateAreaBelow(int[][] squares, double y) {
        double area = 0;
        for (int[] square : squares) {
            double x1 = square[0];
            double y1 = square[1];
            double l = square[2];
            double y2 = y1 + l;

            if (y2 <= y) {
                area += l * l;
            } else if (y1 < y) {
                double height = y - y1;
                area += height * l;
            }
        }
        return area;
    }
}