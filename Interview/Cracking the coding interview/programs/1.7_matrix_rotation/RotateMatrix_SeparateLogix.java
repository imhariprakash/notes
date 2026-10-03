import java.util.Scanner;

public class RotateMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.print("Enter rotation degree (e.g., 90, 180, 270, -90, 360): ");
        int inputDegree = sc.nextInt();
        sc.close();

        if (inputDegree % 90 != 0) {
            System.out.println("Invalid input: Degree must be a multiple of 90.");
            return;
        }

        rotate(matrix, inputDegree);

        System.out.println("\nRotated Matrix:");
        printMatrix(matrix);
    }

    public static void rotate(int[][] matrix, int degrees) {
        // Normalize angle into {0, 90, 180, 270}
        int normalized = (degrees % 360 + 360) % 360;

        switch (normalized) {
            case 90:
                rotate90(matrix);
                break;
            case 180:
                rotate180(matrix);
                break;
            case 270:
                // 270 clockwise is equivalent to 90 counter-clockwise
                rotate270(matrix);
                break;
            case 0:
            default:
                // 0 degrees or 360 degrees: no-op
                break;
        }
    }

    // 90 degrees clockwise (4-cycle shift)
    private static void rotate90(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    // 180 degrees (direct 2-way opposite swaps)
    private static void rotate180(int[][] matrix) {
        int n = matrix.length;
        int totalElements = n * n;

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

    // 270 degrees clockwise (or 90 counter-clockwise)
    private static void rotate270(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = temp;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}
