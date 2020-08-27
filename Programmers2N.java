public class Programmers2N {

    public static void main(String[] args){

    }

 
    public int solution(int n) {
        int[] res = new int[n+1];
        res[1] = 1;
        res[2] = 2;
        for(int i=3; i<=n; i++){
            res[i]= (res[i-1]%1000000007+res[i-2]%1000000007)%1000000007;

        }
        return res[n];
    }
}
