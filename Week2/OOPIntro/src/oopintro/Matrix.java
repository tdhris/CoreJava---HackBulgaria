package oopintro;

public class Matrix {
    private int[][] matrix;
    private final int rowCount;
    private final int colCount;

    Matrix(int rowsCount, int columnCount) {
        this.matrix = new int[rowsCount][columnCount];
        this.rowCount = rowsCount;
        this.colCount = columnCount;
    }
    
    public int at(int i, int j) {
        return this.matrix[i][j];
    }
    
    public void set(int i, int j, int value) {
        this.matrix[i][j] = value;
    }
    
    public void fill(int value) {
        for (int i = 0; i < this.rowCount; i++) {
            for (int j = 0; j < this.colCount; j++) {
                this.matrix[i][j] = value;
            }
        }
    }
    
    public String toString() {
        StringBuilder matrix = new StringBuilder();
        for (int[] row: this.matrix) {
            for (int element: row) {
                matrix.append(Integer.toString(element));
            }
            matrix.append("\n");
        }
        
        return matrix.toString();
    }
    
    public void operate(MatrixOperations operation) {
        for (int i = 0; i < this.rowCount; i++) {
            for (int j = 0; j < this.colCount; j++) {
                int result = operation.withPixel(i, j, this.matrix);
                this.matrix[i][j] = result;
            }
        }
    }
}
