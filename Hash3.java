
import java.util.HashMap;
import java.util.Map;

public class Hash3 {

    public static int solution(String[][] clothes){
        HashMap<String, Integer> closet = new HashMap<>();

        for(String[] array : clothes) {
            if(closet.containsKey(array[1])){
                closet.replace(array[1], closet.get(array[1])+1);
            }else{
                closet.put(array[1], 1);
            }
        }

        int old = 1;
        for(Map.Entry<String, Integer> entry : closet.entrySet()){
            old *= (entry.getValue()+1);
        }
        return old-1;
    }

    public static void main(String[] args){
        String[][] res = {{"yellow_hat","headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban","headgear"}};
        System.out.println(solution(res));

    }
}
