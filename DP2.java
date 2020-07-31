import java.util.Arrays;

public class DP2 {
    public static void main(String[] args){
        int[][] triangle = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }
    static int[][] res;
    static int[][] array;
    public static int solution(int[][] triangle) {
        array = triangle;
        int[] last = triangle[triangle.length-1];
        res = new int[triangle.length][last.length];
        for(int[] i: res){
            Arrays.fill(i, -1);
        }
        res[0][0] = triangle[0][0];
        int[] max = new int[last.length];
        for(int i=0; i<last.length; i++){
           max[i] = getMax(triangle.length-1, i);
        }
        Arrays.sort(max);

        return max[max.length-1];
    }
    public static int getMax(int depth, int index){
        if(res[depth][index]!=-1) {
            return res[depth][index];
        }else{
            int max;
            if(index==0){ // 왼쪽으로 내려왔을 것
                max = getMax(depth-1, 0) + array[depth][index];
                res[depth][index] = max;
            }else if(index==depth){// 오른쪽으로 내려왔을 것
                max = getMax(depth-1, index-1) + array[depth][index];
                res[depth][index] = max;
            }else{
                int left = getMax(depth-1, index);
                int right = getMax(depth-1, index-1);
                max = Math.max(left, right) + array[depth][index];
                res[depth][index] = max;
            }
            return max;
        }
    }
}
