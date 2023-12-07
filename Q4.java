public class Q4 {

    public static int ElementoMajoritario(int[] nums){
        int c = 0;
        int count = 0;


        for (int num : nums){
            if (count == 0){
                c = num;
                count++;
            }else if (num == c){
                count++;
            }else {
                count--;
            }
        }
        count = 0;
        for (int num : nums){
            if (num == c) {
                count++;
            }
        }
        if (count > nums.length / 2){
            return c;
        }
        throw new IllegalArgumentException("Elemento majoritario não encontrado");
    }

    public static void main(String[] args){
        int[] nums = {3, 5, 5, 3, 6, 5, 5, 5};
        int elemento = ElementoMajoritario(nums);
        System.out.println("O Elemento Majoritário é: " + elemento);
    }
}
