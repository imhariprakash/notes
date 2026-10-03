public class RotateMatrix180 {

    public static void rotate180(int[][] matrix) {
        int n = matrix.length;
        int totalElements = n * n;

        // Swap opposite pairs through the center
        for (int idx = 0; idx < totalElements / 2; idx++) {
            int r1 = idx / n;
            int c1 = idx % n;

            int r2 = (totalElements - 1 - idx) / n;
            int c2 = (totalElements - 1 - idx) % n;

            int temp = matrix[r1][c1];
            matrix[r1][c1] = matrix[r2][c2];
            matrix[r2][c2] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        rotate180(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[ ");
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println("]");
        }
    }
}
