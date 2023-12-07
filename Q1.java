public class Q1 {
    public static void main(String[] args){

        int[] vetor = {4, 5, 6, 8, 3, 1, 2, 7};
        int piv = 4;
        int p = 0;
        int r = vetor.length - 1;

        int[] indices = decomposicaoVetor(vetor, piv, p, r);

        System.out.println("Indice q1: " + indices[0]);
        System.out.println("Indice q2: " + indices[1]);

        System.out.println("Vetor rearranjado: ");
        for (int i : vetor){
            System.out.print(i + " ");
        }
    }

    public static int[] decomposicaoVetor(int[] S, int piv, int p, int r){
        int q1 = p - 1;
        int q2 = p - 1;

        for(int j = p; j <= r; j++){
            if (S[j] < piv) {
                q1++;
                q2++;
                troca(S, q2, j);
                troca(S, q1, q2);
            }else if (S[j] == piv){
                q2++;
                troca(S, q2, j);
            }
        }
        int[] indices = {q1 + 1, q2};
        return indices;
    }

    public static void troca(int[] S, int i, int j){
        int temp = S[i];
        S[i] = S[j];
        S[j] = temp;
    }
}
