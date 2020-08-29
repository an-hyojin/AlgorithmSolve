public class JadenCase {
    public static void main(String[] args){
        String res = solution(" h h  ");

        System.out.println(res);
    }
    public static String solution(String s) {
        s = s.toLowerCase();
        String[] temp = s.split(" ");
        for(String a : temp){
            System.out.println(a);
        }
        StringBuilder answer = new StringBuilder();
        for(String word: temp){
            if(word.length()==0) {answer.append(' '); continue;}
            if(word.charAt(0)>='a'&&word.charAt(0)<='z'){
                answer.append((char)(word.charAt(0)-32));
                answer.append(word.substring(1));
            }else{
                answer.append(word);
            }
            answer.append(' ');
        }

        return answer.toString().substring(0, answer.length()-1);
    }

}
