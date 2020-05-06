import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class KakaoWinter2 {
    public static void main(String[] args){
        int[] res = solution("{{1},{1,1}}");
        for(int i : res){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static int[] solution(String s) {

        String substr = s.substring(1, s.length() - 1);
        substr = substr.replace("},{", "}/{");
        System.out.println(substr);
        String[] splits = substr.split("/");
        for(String a: splits){
            a = a.substring(1, a.length()-1);
            String[] array = a.split(",");
            ArrayList<Integer> list = new ArrayList<>();
            for(String b: array){
                list.add(Integer.parseInt(b));
            }
            map.put(array.length, list);
        }
        ArrayList<Integer> all =new ArrayList<>();
        all.addAll(map.get(splits.length));
        int[] answer = new int[splits.length];
        for(int i =0 ; i < splits.length; i++){
            ArrayList<Integer> list = map.get(i+1);
            for (Integer item : list) {
                if (all.contains(item)) {
                    all.remove(item);
                    answer[i] = item;
                    break;
                }
            }
        }
        return answer;
    }
}
