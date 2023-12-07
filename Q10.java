public class Q10{

    public static int indiceValorAlvo(int[] nums, int alvo){
        int esq = 0;
        int dir = nums.length - 1;

        while(esq <= dir){
            int mid = esq + (dir - esq) / 2;

            if(nums[mid] == alvo){
                return mid;
            }else if (nums[mid] < alvo){
                esq = mid + 1;
            }else{
                dir = mid - 1;
            }
        }

        return esq; 
    }

    public static void main(String[] args){
        int[] nums = {1, 3, 5, 6};

        int valorAlvo1 = 5;
        int resultado1 = indiceValorAlvo(nums, valorAlvo1);
        System.out.println("Indice do alvo que está no array: " + resultado1);

        int valorAlvo2 = 2;
        int resultado2 = indiceValorAlvo(nums, valorAlvo2);
        System.out.println("Posição de inserção do elemento que não está no array: " + resultado2);
    }
}