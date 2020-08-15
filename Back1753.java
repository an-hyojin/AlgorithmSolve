import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back1753 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        String str = bf.readLine(); //String
        StringTokenizer st = new StringTokenizer(str);
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Vertex> distance[] = new ArrayList[V+1];
        for(int i=0; i< distance.length; i++){
            distance[i] = new ArrayList<>();
        }
        int startPoint =Integer.parseInt(bf.readLine());
        int[] res = new int[V+1];
        boolean[] visit = new boolean[V+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[startPoint] = 0;
        for(int i=0; i< E; i++){
            str = bf.readLine();
            st = new StringTokenizer(str);
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            distance[s].add(new Vertex(d, len));
        }
        Queue<Integer> visitQueue = new LinkedList<>();
        visitQueue.add(startPoint);
        while(!visitQueue.isEmpty()){
            int i = visitQueue.poll();
            visit[i] = true;
            for(Vertex v: distance[i]){
                res[v.dest] = Math.min(res[v.dest], res[i]+v.len);
            }
            int minPoint = 0;
            for(int j=1; j< res.length; j++){
                if(!visit[j]){
                    minPoint = res[minPoint]<res[j]?minPoint:j;
                }
            }
            if(res[minPoint]!=Integer.MAX_VALUE)visitQueue.add(minPoint);
        }
        for(int i=1;i<res.length;i++){
            if(res[i]==Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(res[i]);
            }
        }
    }
    static class Vertex{
        int dest;
        int len;
        public Vertex(int d, int l){
            this.dest = d;
            this.len = l;
        }
    }

}
