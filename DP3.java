import java.math.BigInteger;

public class DP3 {

    public static void main(String[] args) {
        int res =solution(4, 3, new int[][]{{2,2}});
        System.out.println(res);
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] res = new int[n][m];

        for (int[] puddle : puddles) {
            int x = puddle[1]-1;
            int y = puddle[0]-1;
            res[x][y] = -1;
        }
        res[0][0]=1;
        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                if(res[i][j]==-1){
                    res[i][j]=0;
                    continue;
                }
                if(i!=0)res[i][j]= (res[i][j]+res[i-1][j])%1000000007;
                if(j!=0)res[i][j]=(res[i][j]+res[i][j-1])%1000000007;
            }
        }

        return res[n-1][m-1];
    }
}
