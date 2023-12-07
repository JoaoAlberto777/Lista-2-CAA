import java.util.Arrays;

public class Q11 {

    public static void mesclarArrays(int[] nums1, int m, int[] nums2, int n){
        int indiceMesclado = m + n - 1;
        int indice1 = m - 1;
        int indice2 = n - 1;

        while(indice1 >= 0 && indice2 >= 0){
            if(nums1[indice1] > nums2[indice2]){
                nums1[indiceMesclado] = nums1[indice1];
                indice1--;
            }else{
                nums1[indiceMesclado] = nums2[indice2];
                indice2--;
            }
            indiceMesclado--;
        }

        while(indice2 >= 0){
            nums1[indiceMesclado] = nums2[indice2];
            indice2--;
            indiceMesclado--;
        }
    }

    public static void main(String[] args){
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        System.out.println("Array nums1" + Arrays.toString(nums1));
        System.out.println("Array nums2" + Arrays.toString(nums2));

        mesclarArrays(nums1, m, nums2, n);

    
        System.out.print("Arrays Mesclados: [");
        for (int i = 0; i < m + n; i++){
            System.out.print(nums1[i]);
            if(i < m + n - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

