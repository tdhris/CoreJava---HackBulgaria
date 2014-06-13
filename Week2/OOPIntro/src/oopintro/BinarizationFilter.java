package oopintro;

public class BinarizationFilter implements MatrixOperations {

    @Override
    public int withPixel(int x, int y, int[][] matrix) {
        if (matrix[x][y] >= 0 && matrix[x][y] <= 127) {
            return 0;
        }
        else {
            return 255;
        }
    }

}
