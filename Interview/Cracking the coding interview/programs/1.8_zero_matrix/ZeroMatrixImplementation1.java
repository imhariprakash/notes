/**
    Question: 1.8. Zero matrix: If an element in an M x N matrix is 0, set its entire row and column to 0.
     *  Implementation 1:
        * Maintain a separate matrix: 
            1. First pass: copy the positions of the original zeroes into a separate : zeroPositions matrix (1 = original zero, 0 = otherwise).
            2. Second pass: for every marked cell (i, j), zero out row i and column j in the original matrix.
    * Why a separate matrix?
     *  If I zero rows/columns while scanning the same matrix, the newly written zeroes look like original zeroes and end up wiping the whole matrix.
     *  Taking a snapshot first avoids that.
    * Complexity:
     *  Time:
            * Without isRowSet: 
                *  O(M * N) to find zeroes, plus O(M + N) work for each zero found -> O(M * N * (M + N)) in the worst case.
                *  Space : O(M * N) for zeroPositions.
            * With isRowSet: Time worst case: O(MN^2)
            * With columnSet (array): O(MN) - can't achieved using a single boolean
    * Repeated row zeroing is avoided with the isRowSet flag: the outer loop
 */
public class ZeroMatrixImplementation1
{
    public static void main(String[] args)
    {
        int[][] matrix = {{0,1,1}, {1,1,1}, {1,1,1}};
        int[][] zeroPositions = ZeroMatrixImplementation1.getZeroPositions(matrix);
        ZeroMatrixImplementation1.setZeroesToMatrix(matrix, zeroPositions);
        ZeroMatrixImplementation1.printMatrix(matrix);
    }

    private static int[][] getZeroPositions(int[][] matrix)
    {
        int[][] zeroPositions = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    zeroPositions[i][j] = 1;
                }
            }
        }
        return zeroPositions;
    }

    private static void setZeroesToMatrix(int[][] matrix, int[][] zeroPositions)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            boolean isRowSet = false;
            for(int j = 0; j < matrix[i].length; j++)
            {
                if(zeroPositions[i][j] == 1)
                {
                    if(isRowSet)
                    {
                        ZeroMatrixImplementation1.setRowToZero(matrix, i);
                        isRowSet = true;
                    }
                    ZeroMatrixImplementation1.setColumnToZero(matrix, j);
                }
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
