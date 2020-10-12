import java.util.*;
class Greedy6 {
    public int solution(int[][] routes) {
        int answer = 1;
        ArrayList<Route> routeList = new ArrayList<>();
        for(int[] route:routes){
            routeList.add(new Route(route[0], route[1]));
        }
        Collections.sort(routeList);
        // -20 15
        // -18 -13
        // -14 -5
        // -5 -3
        int canCheck = routeList.get(0).dest;
        for(int i=1; i< routeList.size();i++){
            Route next = routeList.get(i);
            if (canCheck < next.start) {
                answer++;
                canCheck = next.dest;
            }
            if (canCheck >= next.dest)
                canCheck = next.dest;
        }
        return answer;
    }

    class Route implements Comparable<Route>{
        int start;
        int dest;
        Route(int s, int d){
            this.start = s;
            this.dest = d;
        }

        @Override
        public int compareTo(Route r){
            if(r.start < this.start){
                return 1;
            }else if(r.start==this.start){
                if(r.dest<this.dest)return 1;
                else if(r.dest==this.dest) return 0;
                else return -1;
            }else{
                return -1;
            }
        }
    }
}