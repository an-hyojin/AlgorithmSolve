import java.util.HashMap;
import java.util.Map;

public class Hash1 {
    public static String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> participants;
        participants = new HashMap<>();
        for(String person : participant){
            if(!participants.containsKey(person)){
                participants.put(person,1);
            }else{
                int num = participants.get(person);
                participants.put(person, num+1);
            }
        }
        for(String complete: completion){
            int num = participants.get(complete);
            if(num==1){
                participants.remove(complete);
            }else{
                participants.put(complete, num-1);
            }
        }
        Map.Entry<String, Integer> result = participants.entrySet().iterator().next();

        return result.getKey();
    }
    public static void main(String[] args){
        String[] participants = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String com = solution(participants, completion);
        System.out.println(com);
    }
}
