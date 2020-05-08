import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class KakaoWinter3 {
    public static void main(String[] args){
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution(user_id, banned_id));
    }
    static ArrayList<Integer> ids[];
    static HashSet<String> set = new HashSet<>();

    public static boolean check(ArrayList<Integer> array, int i){
        for(int a: array){
            if(a==i){
                return false;
            }
        }
        return true;
    }
    public static void search(int index, ArrayList<Integer> array){
        if(index==ids.length){

            Collections.sort(array);
            set.add(array.toString());
            System.out.println(array.toString());
            return;
        }
        for(Integer id: ids[index]){
            if(!array.contains(id)){
                array.add(id);
                search(index+1, array);
                array.remove(id);
            }
        }

    }
   static int s = 0;
   public static int solution(String[] user_id ,String[] banned_id){
       ids = new ArrayList[banned_id.length];
       for(int i = 0 ; i < banned_id.length; i++){
           String banId = banned_id[i];
           ids[i] = new ArrayList<>();
           for(int j = 0 ; j < user_id.length; j++){
               String userId = user_id[j];
               if(userId.length()==banId.length()){
                   boolean isDif = false;
                   for(int k= 0 ; k < userId.length(); k++){
                       if(!(userId.charAt(k)==banId.charAt(k)||banId.charAt(k)=='*')){
                           isDif = true;
                           break;
                       }
                   }
                   if(!isDif){
                       ids[i].add(j);
                   }
               }
           }
       }
        search(0, new ArrayList<>());

       return set.size();
   }
}

