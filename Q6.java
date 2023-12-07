public class Q6 {

    public static String SubsequenciaPalindromo(String s){
    int n = s.length();
    int[][] dp = new int[n][n];

    for (int i = 0; i < n; i++){
        dp[i][i] = 1;
    }

    for(int len = 2; len <= n; len++){
        for(int i = 0; i <= n - len; i++){
            int j = i + len - 1;
            if(s.charAt(i) == s.charAt(j) && len == 2){
                dp[i][j] = 2;
            }else if (s.charAt(i) == s.charAt(j)){
                dp[i][j] = dp[i + 1][j - 1] + 2;
            }else{
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
    }

    StringBuilder resultado = new StringBuilder();
    int i = 0, j = n - 1;

    while(i <= j){
        if(s.charAt(i) == s.charAt(j)){
            if(i == j){
                resultado.insert(resultado.length() / 2, s.charAt(i));
            }else{
                resultado.insert(resultado.length() / 2, s.charAt(i));
                resultado.append(s.charAt(i));
            }
            i++;
            j--;
        }else if(dp[i + 1][j] > dp[i][j - 1]){
            i++;
        }else{
            j--;
        }
    }

    return resultado.toString();
}

public static void main(String[] args){
    String sequencia = "ACGTGTCAAAATCG";
    String resultado = SubsequenciaPalindromo(sequencia);
    System.out.println("Subsequência Palíndroma de Tamanho Máximo: " + resultado);
}
}
