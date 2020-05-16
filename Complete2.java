import java.util.HashSet;

public class Complete2 {
    public static void main(String[] args){
        solution("012");
    }
    static HashSet<Integer> sosuCase = new HashSet<>();
    public static int solution(String numbers) {
        int answer = 0;

        perm("", numbers);
        for (Integer integer : sosuCase) {
            if (isSosu(integer)) answer++;
        }

        return answer;
    }
    public static void perm(String prefix, String str){
        if(!prefix.equals(""))sosuCase.add(Integer.parseInt(prefix));
        int n=str.length();
        for(int i=0 ; i < n; i++){
            perm(prefix+str.charAt(i), str.substring(0,i)+str.substring(i+1, n));
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isSosu(int x){
        if(x==1||(x!=2&&x%2==0))return false;
        for(int i = 2; x >= i * i; i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
}
