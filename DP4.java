import java.util.Arrays;

public class DP4 {

    public static void main(String[] args){

    }
    public static int solution(int[] money) {
        int len = money.length;
        int[] res1 = new int[len];
        int[] res2 = new int[len];
        res1[0] = money[0];
        res1[1] = money[0];
        res2[1] = money[1];
        for(int i=2; i < len-1; i++){
            res1[i] = Math.max(res1[i-1], res1[i-2]+money[i]);
            res2[i] = Math.max(res2[i-1], res2[i-2]+money[i]);
        }
        res2[len-1] =  Math.max(res2[len-2], res2[len-3]+money[len-1]);

        return Math.max(res1[len-2], res2[len-1]);
    }
}
