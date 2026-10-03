 public class RotateMatrixBy90
{
	public static void main(String[] args)
	{
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		int n = matrix.length;
		for(int i = 0; i < n / 2; i++)
		{
			for(int j = i; j < n - 1 - i; j++)
			{
				int temp = matrix[n - 1 - j][i]; //Bottom left
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; //copy bottom right to the bottom left
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]; //copy top right to the bottom right
				matrix[j][n - 1 - i] = matrix[i][j]; //top left to the top right
				matrix[i][j] = temp; //copy the earlier temp bottom left to the top left
			}
		}
		printMatrix(matrix);
	}

	private static void printMatrix(int[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			System.out.print("[");
			for(int j = 0; j < matrix[i].length; j++)
			{
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("]");
		}
	}
}
