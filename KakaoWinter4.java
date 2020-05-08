import java.util.HashMap;

public class KakaoWinter4 {

    public static void main(String[] args){
        long[] res = solution(10, new long[]{1,1,2,1,1,1});
      for(long r: res){
          System.out.print(r +" ");
      }
      System.out.println();
    }
    public static HashMap<Long, Long> isExists = new HashMap<>();
    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        long index;

        for(int i=0 ; i < room_number.length;i++){
            if(!isExists.containsKey(room_number[i])){
                isExists.put(room_number[i], findIndex(room_number[i]+1));
                answer[i] = room_number[i];
                // 없을 때
            }else{
                // 있을 때
                index = findIndex(isExists.get(room_number[i]));
                isExists.replace(room_number[i], index);
                answer[i] = index;
                isExists.put(index,findIndex(index)+1);
            }

        }
        return answer;
    }
    public static long findIndex(long index){
        if(isExists.containsKey(index)){
            long find = findIndex(isExists.get(index));
            isExists.replace(index, find);
            return find;
        }
        return index;
    }

}

