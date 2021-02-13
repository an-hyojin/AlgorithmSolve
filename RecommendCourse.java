import java.util.*;

public class RecommendCourse {
    public String[] solution(String[] orders, int[] course) {
        // order 정렬
        ArrayList<String> realOrders = new ArrayList<>();
        for(String order:orders){
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            realOrders.add(String.valueOf(arr));
        }
        // course 기준으로 조합 만들기
        Set<String> res = new HashSet<>();
        for(int i=0; i< course.length; i++){
            HashMap<String, Integer> newMap = new HashMap<>();
            int courseNum = course[i];
            for(int k=0;k< realOrders.size(); k++){
                char[] cmbarr = new char[courseNum];
                combination(realOrders.get(k), cmbarr, 0, 0, courseNum, newMap);
            }
            // 가장 많이 주문된 건 추가
            Collection<Integer> val = newMap.values();
            int max =2;
            for(int num : val){
                if(max<num)max = num;
            }
            Set<Map.Entry<String, Integer>> set = newMap.entrySet();
            for(Map.Entry<String, Integer> entry: set){
                if(entry.getValue()>=max){
                    res.add(entry.getKey());
                }
            }
        }
        // 마지막에 정렬
        String[] answer = new String[res.size()];
        int index =0;
        for(String s:res){
            answer[index] = s;
            index++;
        }
        Arrays.sort(answer);
        return answer;
    }

    public static void combination(String s, char[] cmbarr, int index, int depth, int r, HashMap<String, Integer> map){
        if(r==0){
            StringBuilder comb = new StringBuilder();
            for (char c : cmbarr) {
                comb.append(c);
            }
            map.putIfAbsent(comb.toString(), 0);
            map.put(comb.toString(), map.get(comb.toString())+1);
        }else if(depth==s.length()){
            return;
        }else{
            cmbarr[index] = s.charAt(depth);
            combination(s, cmbarr, index+1, depth+1, r-1, map);
            combination(s, cmbarr, index, depth+1, r, map);
        }
    }

}

