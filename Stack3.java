import java.util.ArrayList;
import java.util.Collections;

public class Stack3 {
    public static void main(String[] args){
        solution(new int[]{93,30,55}, new int[]{1,30,5});
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        ArrayList<Integer> queue = new ArrayList<>();
        ArrayList<Integer> ans =new ArrayList<>();
        for(int progress: progresses){
            queue.add(progress);
        }
        int st = 0;
        while(!queue.isEmpty()){
            for(int i=0 ;i< queue.size(); i++){
                queue.set(i, queue.get(i)+speeds[st+i]);
            }
            int x=0;
            while(!queue.isEmpty()&&queue.get(0)>=100){
                queue.remove(0);
                st++;
                x++;
            }
            if(x!=0)ans.add(x);
        }
        answer = new int[ans.size()];
        for(int i=0 ;i < answer.length; i++){
            System.out.print(ans.get(i) +" ");
            answer[i] = ans.get(i);
        }
        return answer;

    }
}
