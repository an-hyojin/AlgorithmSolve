import java.util.*;
class OpenChat {
    public String[] solution(String[] record) {
        HashMap<String, String> idMap = new HashMap<>();
        for(String id : record){
            String[] split = id.split(" ");
            if(!split[0].equals("Leave")){
                idMap.put(split[1], split[2]);
            }
        }
        ArrayList<String> resList = new ArrayList<>();
        for(String id : record){
            String[] split = id.split(" ");
            if(!split[0].equals("Change")){
                StringBuffer sb =new StringBuffer();
                sb.append(idMap.get(split[1]));
                if(split[0].equals("Enter")){
                    sb.append("님이 들어왔습니다.");
                }else{
                    sb.append("님이 나갔습니다.");
                }
                resList.add(sb.toString());
            }
        }
        String[] answer = new String[resList.size()];
        int i=0;
        for(String s : resList){
            answer[i] = s;
            i++;
        }
        return answer;
    }
}