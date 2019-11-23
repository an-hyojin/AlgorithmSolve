import java.util.Scanner;

public class Back11049 {

    public static void main(String[] args){
        Scanner aScanner = new Scanner(System.in);
        int n = aScanner.nextInt();
        int[] matrics = new int[n+1];
        for(int i =0 ; i <n; i++){
            matrics[i] = aScanner.nextInt();
            int number =aScanner.nextInt();
            if(i==n-1){
                matrics[i+1] = number;
            }
        }
        int[][] res = MATRIX_CHAIN_ORDER(matrics);
        System.out.print(res[1][res.length-1]);
    }

    public static int[][] MATRIX_CHAIN_ORDER(int[] d){
        int n = d.length;
        int[][] min =  new int[n][n];
        for(int i = 1; i <n; i++){
            min[i][i] =0;
        }
        for(int l=2; l<n; l++){//l은 chain 길이
            for(int i = 1;i<n-l+1;i++){
                int j = i + l -1;
                min[i][j] = Integer.MAX_VALUE;
                for(int k= i; k <=j-1; k++){
                    int q = min[i][k] + min[k+1][j] +d[i-1]*d[k]*d[j];
                    min[i][j] = Math.min(min[i][j], q);
                }
            }
        }
        return min;
    }

}
