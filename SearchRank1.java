import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
class SearchRank1 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        HashMap<Key, ArrayList<Integer>> map = new HashMap<>();
        for(String i:info){
            String[] infos = i.split(" ");
            dfs(infos, 0, map);
        }
        int index = 0;
        for(String s : query){
            String[] queries = s.split(" ");
            ArrayList<Integer> list = map.getOrDefault(new Key(queries[0], queries[2], queries[4], queries[6]), new ArrayList<>());
            Collections.sort(list);
            int score = Integer.valueOf(queries[7]);
            int size = 0;
            for(int i:list){
                System.out.println(i);
                if(score<=i)break;
                size++;
            }
            answer[index] = list.size()-size;
            index++;
        }
        return answer;
    }
    public void dfs(String[] infos, int index, HashMap<Key, ArrayList<Integer>> map){
        if(index == 4){
            Key key = new Key(infos[0], infos[1], infos[2], infos[3]);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(Integer.valueOf(infos[4]));
        }else{
            String temp = infos[index];
            dfs(infos, index+1, map);
            infos[index] = "-";
            dfs(infos, index+1, map);
            infos[index] = temp;
        }
    }

    class Key{
        String lan;
        String fb;
        String js;
        String soulfood;

        Key(String l, String f, String j, String s){
            this.lan = l;
            this.fb = f;
            this.js = j;
            this.soulfood = s;
        }

        @Override
        public int hashCode() {
            int hashcode = lan.hashCode();
            hashcode = 31*hashcode + fb.hashCode();
            hashcode = 31*hashcode + js.hashCode();
            hashcode = 31*hashcode + soulfood.hashCode();
            return hashcode;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Key){
                Key o = (Key)obj;
                if(o.soulfood.equals(this.soulfood)&&o.lan.equals(this.lan)&&o.fb.equals(this.fb)&&o.js.equals(this.js)){
                    return true;
                }
            }  return false;

        }
    }
}