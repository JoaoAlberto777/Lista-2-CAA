public class Q2 {

    public static int[][] multiMatrizes(int[][] A, int[][] B){
        int n = A.length;

        if(n == 1){
            int[][] C = new int[1][1];
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }

        int[][] C = new int[n][n];

        int[][] A11 = divideMatriz(A, 0, 0, n/2);
        int[][] A12 = divideMatriz(A, 0, n/2, n/2);
        int[][] A21 = divideMatriz(A, n/2, 0, n/2);
        int[][] A22 = divideMatriz(A, n/2, n/2, n/2);

        int[][] B11 = divideMatriz(B, 0, 0, n/2);
        int[][] B12 = divideMatriz(B, 0, n/2, n/2);
        int[][] B21 = divideMatriz(B, n/2, 0, n/2);
        int[][] B22 = divideMatriz(B, n/2, n/2, n/2);

        int[][] P1 = multiMatrizes(A11, removeMatriz(B12, B22));
        int[][] P2 = multiMatrizes(addMatriz(A11, A12), B22);
        int[][] P3 = multiMatrizes(addMatriz(A21, A22), B11);
        int[][] P4 = multiMatrizes(A22, removeMatriz(B21, B11));
        int[][] P5 = multiMatrizes(addMatriz(A11, A22), addMatriz(B11, B22));
        int[][] P6 = multiMatrizes(removeMatriz(A12, A22), addMatriz(B21, B22));
        int[][] P7 = multiMatrizes(removeMatriz(A11, A21), addMatriz(B11, B12));

        int[][] C11 = addMatriz(removeMatriz(addMatriz(P5, P4), P2), P6);
        int[][] C12 = addMatriz(P1, P2);
        int[][] C21 = addMatriz(P3, P4);
        int[][] C22 = removeMatriz(removeMatriz(addMatriz(P5, P1), P3), P7);

        mesclarMatriz(C, C11, C12, C21, C22);

        return C;
    }

    private static int[][] divideMatriz(int[][] matrix, int row, int col, int size){
        int[][] submatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                submatrix[i][j] = matrix[row + i][col + j];
            }
        }
        return submatrix;
    }

    private static void mesclarMatriz(int[][] resultado, int[][] C11, int[][] C12, int[][] C21, int[][] C22){
        int size = C11.length;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                resultado[i][j] = C11[i][j];
                resultado[i][j + size] = C12[i][j];
                resultado[i + size][j] = C21[i][j];
                resultado[i + size][j + size] = C22[i][j];
            }
        }
    }

    private static int[][] addMatriz(int[][] A, int[][] B){
        int n = A.length;
        int[][] resultado = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado[i][j] = A[i][j] + B[i][j];
            }
        }
        return resultado;
    }

    private static int[][] removeMatriz(int[][] A, int[][] B){
        int n = A.length;
        int[][] resultado = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado[i][j] = A[i][j] - B[i][j];
            }
        }
        return resultado;
    }

    public static void main(String[] args){
        int[][] A = {{5, 8}, {7, 2}};
        int[][] B = {{11, 17}, {11, 15}};

        int[][] resultado = multiMatrizes(A, B);

        for (int[] row : resultado){
            for (int elem : row){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
