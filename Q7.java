import java.util.Arrays;

public class Q7{

    public static int[] QuadradoNumeros(int[] nums) {
        int n = nums.length;
        int[] resultado = new int[n];

        for (int i = 0; i < n; i++) {
            resultado[i] = nums[i] * nums[i];
        }

        Arrays.sort(resultado);
        return resultado;
    }


    public static int[] QuadradoNumerosLinear(int[] nums) {
        int n = nums.length;
        int[] resultado = new int[n];

        int esq = 0;
        int dir = n - 1;
        int index = n - 1;

        while (esq <= dir) {
            int quadradoEsq = nums[esq] * nums[esq];
            int quadradoDir = nums[dir] * nums[dir];

            if (quadradoEsq > quadradoDir) {
                resultado[index--] = quadradoEsq;
                esq++;
            } else {
                resultado[index--] = quadradoDir;
                dir--;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};


        int[] resultado = QuadradoNumeros(nums);
        System.out.println("Array Original: " + Arrays.toString(nums));
        System.out.println("Metodo Simples: " + Arrays.toString(resultado));

        int[] resultadoLinear = QuadradoNumerosLinear(nums);
        System.out.println("Metodo Linear: " + Arrays.toString(resultadoLinear));
    }
}
