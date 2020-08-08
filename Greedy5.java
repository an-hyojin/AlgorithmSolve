import java.util.Arrays;

public class Greedy5 {
    public static void main(String[] args){
        int[][] costs ={{0, 1, 2}, {0, 2, 2}, {0, 3, 2}, {0, 4, 2}, {3, 4, 1}};
        solution(5, costs);
    }
    static int[] connect;

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        Item[] items = new Item[costs.length];
        connect = new int[n];
        for(int i=0;i<connect.length; i++){
            connect[i] = i;
        }
        for(int i=0; i< costs.length; i++){
            int[] cost = costs[i];
            int point1 = Math.min(cost[0], cost[1]);
            int point2 = Math.max(cost[0], cost[1]);
            items[i] = new Item(point1, point2, cost[2]);
        }
        Arrays.sort(items);
        int edgeCount = 0;
        int index =0;

        while(edgeCount<n-1){
            Item edge = items[index++];
            if(find(edge.point1)!=find(edge.point2)){
                System.out.println(edge.point1 +" "+edge.point2);
                answer += edge.cost;
                union(edge.point1, edge.point2);
                edgeCount++;
            }
        }
        System.out.println(answer);
        return answer;
    }
    static int find(int x){
        if(connect[x]==x){
            return x;
        }else{
            return find(connect[x]);
        }
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        connect[y] = x;
    }

    static class Item implements Comparable<Item>{
        int point1;
        int point2;
        int cost;
        Item(int p1, int p2, int c){
            this.point1 = p1;
            this.point2 = p2;
            this.cost = c;
        }

        @Override
        public int compareTo(Item o) {
            if(o.cost>this.cost)return -1;
            else if(o.cost==this.cost) return 0;
            else return 1;
        }
    }
}
