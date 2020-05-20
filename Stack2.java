public class Stack2 {
    public static void main(String[] args){
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
    public static int solution(int[] priorities, int location) {
        int answer =1;
        int pointer =0;
        int size = priorities.length;
        boolean flag = true;

        while(true){
            int priority = priorities[pointer];
            for(int prior: priorities){
                if(prior>priority){
                    pointer++;
                    if(pointer%size==0)pointer=0;
                    flag = false;
                    break;
                }
            }
            if(flag){]
                priorities[pointer] = -1;
                if(pointer==location) return answer;
                pointer++;
                answer++;
                if(pointer%size==0)pointer=0;
            }

            flag =true;
        }
    }
}
