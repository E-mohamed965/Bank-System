public class MatrixOperations {
    public static double sumColumn(double[][] m, int columnIndex) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][columnIndex];
        }
        return sum;
    }
    public static void main(String[] args) {
        double[][] matrix = {
                {1.5, 2.5, 3.5, 4.5},
                {5.5, 6.5, 7.5, 8.5},
                {9.5, 10.5, 11.5, 12.5}
        };
        for (int j = 0; j < matrix[0].length; j++) {
            System.out.println("Sum of elements in column " + j + ": " + sumColumn(matrix, j));
        }
    }
}