import java.util.Scanner;

public class RotateMatrix 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter degrees (multiple of 90): ");
        int inputDegree = sc.nextInt();
        sc.close();

        if (inputDegree % 90 != 0) 
		{
            System.out.println("Degree must be a multiple of 90.");
            return;
        }

        // Properly wraps negatives and multiples of 360 into {0, 1, 2, 3}
        int degree = ((inputDegree % 360 + 360) % 360) / 90;

        int[][] matrix = 
		{
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9}
        };
        int n = matrix.length;

        for (int i = 0; i < degree; i++) 
		{
            rotateBy90(matrix, n);
        }

        printMatrix(matrix);
    }

    private static void rotateBy90(int[][] matrix, int n) 
	{
        for (int i = 0; i < n / 2; i++) 
		{
            for (int j = i; j < n - 1 - i; j++) 
			{
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    private static void printMatrix(int[][] matrix) 
	{
        for (int i = 0; i < matrix.length; i++) 
		{
            System.out.print("[");
            for (int j = 0; j < matrix[i].length; j++) 
			{
                System.out.print(matrix[i][j] + (j == matrix[i].length - 1 ? "" : " "));
            }
            System.out.println("]");
        }
    }
}
