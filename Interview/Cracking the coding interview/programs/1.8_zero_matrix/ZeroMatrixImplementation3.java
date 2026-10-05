import java.util.BitSet;

/**
    Question: 1.8. Zero matrix: If an element in an M x N matrix is 0, set its entire row and column to 0.
     *  Implementation 3:
        * Same as Implementation 2, but use two BitSets instead of two int arrays:
            1. First pass: for every original zero at (i, j), set bit i in rowZeroPositions and bit j in columnZeroPositions.
            2. Second pass: zero out every row whose bit is set, then zero out every column whose bit is set.
    * Why BitSet instead of int arrays (Implementation 2)?
     *  I only need a yes/no per row and per column - an int (32 bits) per flag is wasteful.
     *  BitSet stores each flag as a single bit, so memory drops by ~32x.
     *  nextSetBit() lets me jump straight to the marked rows/columns instead of checking every index.
    * Each row and each column is zeroed at most once - same as Implementation 2.
    * Complexity:
     *  Time  : O(M * N) to find zeroes + O(M * N) to zero rows + O(N * M) to zero columns -> O(M * N)
     *  Space : O(M + N) bits -> still O(M + N) asymptotically, but ~32x smaller than int arrays in practice.
    * Further improvement: O(1) space - use the first row and first column of the matrix itself as the markers,
     *  with two booleans to remember whether the first row / first column originally had a zero.
 */
public class ZeroMatrixImplementation3
{
    public static void main(String[] args)
    {
        int[][] matrix = {{0,1,1}, {1,1,1}, {1,1,1}};
        BitSet rowZeroPositions = new BitSet(matrix.length);
        BitSet columnZeroPositions = new BitSet(matrix[0].length);
        ZeroMatrixImplementation3.getZeroPositions(matrix, rowZeroPositions, columnZeroPositions);
        ZeroMatrixImplementation3.setZeroesToMatrix(matrix, rowZeroPositions, columnZeroPositions);
        ZeroMatrixImplementation3.printMatrix(matrix);
    }

    private static void getZeroPositions(int[][] matrix, BitSet rowZeroPositions, BitSet columnZeroPositions)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    rowZeroPositions.set(i);
                    columnZeroPositions.set(j);
                }
            }
        }
    }

    private static void setZeroesToMatrix(int[][] matrix, BitSet rowZeroPositions, BitSet columnZeroPositions)
    {
        for(int i = rowZeroPositions.nextSetBit(0); i >= 0; i = rowZeroPositions.nextSetBit(i + 1))
        {
            ZeroMatrixImplementation3.setRowToZero(matrix, i);
        }
        for(int i = columnZeroPositions.nextSetBit(0); i >= 0; i = columnZeroPositions.nextSetBit(i + 1))
        {
            ZeroMatrixImplementation3.setColumnToZero(matrix, i);
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
