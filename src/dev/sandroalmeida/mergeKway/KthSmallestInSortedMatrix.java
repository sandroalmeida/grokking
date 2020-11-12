package dev.sandroalmeida.mergeKway;

public class KthSmallestInSortedMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {

        if(k <= 0 || k > matrix.length * matrix.length)
            return -1;

        int col = k / (matrix.length);
        int row = k % (matrix.length);

        if(row == 0) return matrix[matrix.length - 1][col - 1];

        return matrix[row-1][col];
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }

}
