import java.util.Arrays;
class Level3_1 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int bIndex = B.length-1;
        int aIndex = A.length-1;
        for(int i=B.length-1; i>=0; i--){
            if(A[aIndex]>=B[bIndex]){
                aIndex--;
            }else{
                answer++;
                aIndex--;
                bIndex--;
            }
        }
        return answer;
    }
}