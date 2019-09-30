import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Back10090 {
    public static int ARRAY_SIZE;
    static int[] solves;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ARRAY_SIZE  = Integer.parseInt(br.readLine());
        solves = new int[ARRAY_SIZE];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< ARRAY_SIZE;i++){
            solves[i] = Integer.valueOf(st.nextToken());
        }
        System.out.print(SORT_AND_COUNT( 0, ARRAY_SIZE-1));
    }

    public static BigInteger SORT_AND_COUNT(int start, int end){
        if(start>=end){
            return BigInteger.ZERO;
        }
        int mid = (end+start)/2;

        BigInteger left = SORT_AND_COUNT(start, mid);
        BigInteger right = SORT_AND_COUNT(mid+1, end);
        BigInteger now = MERGE_AND_COUNT(start, end);
        return left.add(right.add(now));
    }

    public static BigInteger MERGE_AND_COUNT(int start, int end){
        int mid = (start+end)/2;

        int frontIndex = start;
        int backIndex = mid+1;


        int[] result = new int[end-start+1];
        int resultIndex = 0;
        BigInteger inversionCount = BigInteger.ZERO;
        while(frontIndex<=mid&&backIndex<=end){
            if(solves[frontIndex]>solves[backIndex]) {
                result[resultIndex] = solves[backIndex];
                inversionCount = inversionCount.add(BigInteger.valueOf(mid+1-frontIndex));
                backIndex++;
            }else{
                result[resultIndex] = solves[frontIndex];
                frontIndex++;
            }
            resultIndex++;
        }
        if(frontIndex<=mid){
            System.arraycopy( solves, frontIndex,result, resultIndex, (mid-frontIndex)+1);
        }
        if(backIndex<=end){
            System.arraycopy( solves, backIndex,result,resultIndex, (end-backIndex)+1);
        }
        System.arraycopy(result, 0, solves, start, (end-start)+1);
        return inversionCount;
    }
}
