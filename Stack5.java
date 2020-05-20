import java.util.Stack;

public class Stack5 {
    public static void main(String[] args){
        solution("()(((()())(())()))(()");
    }
    public static int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        int realNum = 0;
        for(int i=0 ;i< arrangement.length();i++){
            char input = arrangement.charAt(i);
            if(i<arrangement.length()-1&&input=='('&&arrangement.charAt(i+1)==')'){
                //레이저
                answer += realNum;
                i++;
            }else{
                if(input=='('){
                    answer++;
                    realNum++;
                    stack.push('(');
                }else{
                    realNum--;
                    stack.pop();
                }
                System.out.println(input+" : " + realNum);

            }

        }
    System.out.println(answer);
        return answer;
    }

}
