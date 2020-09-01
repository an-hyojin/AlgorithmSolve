import java.util.*;
import java.math.BigInteger;

class BinarySearch1 {
    int[] timeArray;
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        timeArray = times;
        BigInteger num = BigInteger.valueOf((long)n);
        BigInteger time = BigInteger.valueOf(times[times.length-1]).multiply(num);
        return binarySearch(BigInteger.ZERO, time, num);

    }
    public long binarySearch(BigInteger min, BigInteger max, BigInteger n){
        BigInteger half = min.add(max).divide(BigInteger.valueOf(2));
        while(max.compareTo(min)>=0){
            half = min.add(max).divide(BigInteger.valueOf(2));
            BigInteger num =BigInteger.ZERO;
            for(int i=0 ;i < timeArray.length; i++){
                num = num.add(half.divide(BigInteger.valueOf((long)timeArray[i])));
            }

            if(num.compareTo(n)>=0){

                max = half.subtract(BigInteger.ONE);


            }else{
                min = half.add(BigInteger.ONE);

            }
        }
        return min.longValue();
    }
}