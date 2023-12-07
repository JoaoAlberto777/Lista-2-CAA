import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q3 {

    public static int[] IndiceSomaPiorCaso(int[] nums, int alvo){
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == alvo){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("Solução não encontrada.");
    }

    public static int[] IndiceSomaMedioCaso(int[] nums, int alvo){
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complemento = alvo - nums[i];
            if (numMap.containsKey(complemento)){
                return new int[]{numMap.get(complemento), i};
            }
            numMap.put(nums[i], i);
        }
       throw new IllegalArgumentException("Solução não encontrada.");
    }

    public static int[] IndiceSomaMelhorCaso(int[] nums, int alvo){
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complemento = alvo - nums[i];
            if (numMap.containsKey(complemento)){
                return new int[]{numMap.get(complemento), i};
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("Solução não encontrada.");
    }

    public static void main(String[] args){
        int[] nums = {3,2,4};
        int alvo = 6;
        //int[] nums = {2, 7, 11, 15};
        //int alvo = 9;

        int[] PiorCaso = IndiceSomaPiorCaso(nums, alvo);
        System.out.println("Solução Pior Caso: " + Arrays.toString(PiorCaso));

        int[] MedioCaso = IndiceSomaMedioCaso(nums, alvo);
        System.out.println("Solução Medio Caso: " + Arrays.toString(MedioCaso));

        int[] MelhorCaso = IndiceSomaMelhorCaso(nums, alvo);
        System.out.println("Solução Melhor Caso: " + Arrays.toString(MelhorCaso));
    }
}
