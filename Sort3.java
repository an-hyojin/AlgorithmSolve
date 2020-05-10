import java.util.Arrays;

public class Sort3 {
    public static void main(String[] args){
        int a= solution(new int[]{5,5,5,5});
        System.out.println(a);
        solution(new int[]{1000,1000,999});
    }
    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int[] hS = new int[citations.length];
        for(int i=0 ; i< citations.length; i++){
            hS[i] = Math.min(citations[i], citations.length-i);
        }
        Arrays.sort(hS);
        return hS[hS.length-1];
    }
}

