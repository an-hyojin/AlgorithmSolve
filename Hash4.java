

import java.util.*;
    class Hash4 {
        public static void main(String[] args){
        solution(new String[]{"c", "c", "c", "c","a", "b","d"}, new int[]{500, 500, 500, 300, 200, 1000, 3000});

        }
        public static int[] solution(String[] genres, int[] plays) {

            HashMap<String, ArrayList<Song>> map = new HashMap<>();
           // HashMap<String, Integer> scores = new HashMap<>()<>();
            ArrayList<Song> scores = new ArrayList<>();
            for(int i=0; i< plays.length; i++){
                Song s= new Song(plays[i], i, genres[i]);
                if(map.containsKey(s.genres)){
                    int index = scores.indexOf(s);
                    scores.get(index).playNum += s.playNum;
                    map.get(s.genres).add(s);
                }else{
                    map.put(s.genres, new ArrayList<>());
                    scores.add(new Song(s.playNum, 0, s.genres));
                    map.get(s.genres).add(s);
                }
            }
            Collections.sort(scores);
            ArrayList<Integer> answer = new ArrayList<>();
            while(!scores.isEmpty()) {
                ArrayList<Song> list = map.get(scores.remove(0).genres);
                Collections.sort(list);
                int input = 1;
                while(!list.isEmpty()&&input<=2){
                    Song s = list.remove(0);
                    input++;
                    answer.add(s.num);
                }
            }
            int[] ret = new int[answer.size()];
            for(int i=0; i< answer.size(); i++){
                ret[i] = answer.get(i);
                System.out.print(ret[i]+" ");
            }
            return ret;

        }

        static class Song implements Comparable<Song>{
            int playNum;
            int num;
            String genres;
            Song(int p,int n,String g){
                this.playNum = p;
                this.num = n;
                this.genres = g;
            }
            @Override
            public boolean equals(Object o) {
                if(o instanceof Song) {
                    if(((Song)o).genres.equals(this.genres)){
                        return true;
                    }
                }
                return false;
            }
            @Override
            public int compareTo(Song o) {
                if(o.playNum>this.playNum){
                    return 1;
                }else if(o.playNum==this.playNum){
                    if(o.num<this.num){
                        return 1;
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
            }


    }
}
