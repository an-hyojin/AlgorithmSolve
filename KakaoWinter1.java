import java.util.ArrayList;

public class KakaoWinter1 {
    public static void main(String[] args){
        int[][] board = {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        int[] moves = {4,4,4,4,4,4,4,4,4,4};
        System.out.println(solution(board, moves));
    }
    public static int solution(int[][] board, int[] moves) {
        int answer=0;
        int len = board[0].length;
        int[] pointer = new int[len];
        for(int i=0 ; i < board.length; i++){
            for(int j =0 ; j <len; j++){
                if(board[i][j]!=0 && pointer[j]==0){
                    pointer[j] = i+1;
                }
            }
        }
        ArrayList<Integer> stack = new ArrayList<>();
        for(int i =0 ; i < moves.length; i++){
            int getIndex = moves[i]-1;
            int get = board[pointer[getIndex]-1][getIndex];
            board[pointer[getIndex]-1][getIndex]=0;

            if(pointer[getIndex]!=board.length){
                pointer[getIndex]++;
            }
            if(get!=0){
                if(stack.size()>0) {
                    int top = stack.get(stack.size() - 1);
                    if(top==get){
                        stack.remove(stack.size()-1);
                        answer+=2;
                        continue;
                    }
                }
                stack.add(get);
            }
        }
        return answer;
    }
}
