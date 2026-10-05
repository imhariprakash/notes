/**
    Question: 1.8. Zero matrix: If an element in an M x N matrix is 0, set its entire row and column to 0.
     *  Implementation 2:
        * Maintain two separate arrays - one for rows, one for columns:
            1. First pass: for every original zero at (i, j), mark rowZeroPositions[i] = 1 and columnZeroPositions[j] = 1.
            2. Second pass: zero out every marked row, then zero out every marked column in the original matrix.
    * Why two arrays instead of a full matrix (Implementation 1)?
     *  I only need to know which rows and which columns had a zero - not the exact cell.
     *  So a full M x N snapshot is unnecessary; a row array + a column array is enough.
     *  Marking first and writing later still avoids the "new zero looks like an original zero" problem.
    * Each row and each column is zeroed at most once - no repeated row/column zeroing (fixes the redundancy in Implementation 1).
    * Complexity:
     *  Time  : O(M * N) to find zeroes + O(M * N) to zero rows + O(N * M) to zero columns -> O(M * N)
     *  Space : O(M + N) for rowZeroPositions and columnZeroPositions.
    * Further improvement: O(1) space - use the first row and first column of the matrix itself as the markers,
     *  with two booleans to remember whether the first row / first column originally had a zero.
 */
public class ZeroMatrixImplementation2
{
    public static void main(String[] args)
    {
        int[][] matrix = {{0,1,1}, {1,1,1}, {1,1,1}};
        int[] rowZeroPositions = new int[matrix.length];
        int[] columnZeroPositions = new int[matrix[0].length];
        ZeroMatrixImplementation2.getZeroPositions(matrix, rowZeroPositions, columnZeroPositions);
        ZeroMatrixImplementation2.setZeroesToMatrix(matrix, rowZeroPositions, columnZeroPositions);
        ZeroMatrixImplementation2.printMatrix(matrix);
    }

    private static void getZeroPositions(int[][] matrix, int[] rowZeroPositions, int[] columnZeroPositions)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    rowZeroPositions[i] = 1;
                    columnZeroPositions[j] = 1;
                }
            }
        }
    }

    private static void setZeroesToMatrix(int[][] matrix, int[] rowZeroPositions, int[] columnZeroPositions)
    {
        for(int i = 0; i < rowZeroPositions.length; i++)
        {
            if(rowZeroPositions[i] == 1)
            {
                ZeroMatrixImplementation2.setRowToZero(matrix, i);
            }
        }
        for(int i = 0; i < columnZeroPositions.length; i++)
        {
            if(columnZeroPositions[i] == 1)
            {
                ZeroMatrixImplementation2.setColumnToZero(matrix, i);
            }
        }
    }

    private static void setRowToZero(int[][] matrix, int rowIndex)
    {
        for(int i = 0; i < matrix[rowIndex].length; i++)
        {
            matrix[rowIndex][i] = 0;
        }
    }

    private static void setColumnToZero(int[][] matrix, int columnIndex)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            matrix[i][columnIndex] = 0;
        }
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
