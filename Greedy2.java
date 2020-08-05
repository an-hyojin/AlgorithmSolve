public class Greedy2 {
    public static void main(String[] args){
        System.out.println(solution("4177252841",9));
    }
    public static String solution(String number, int k) {

        StringBuilder answer = new StringBuilder();
        int remainK = k;
        int maxIndex,maxV;
        int lastIndex =0;
        while(remainK>0){
            maxV = number.charAt(lastIndex)-'0';
            maxIndex =lastIndex;
            for(int i=lastIndex; i<=lastIndex+remainK; i++){
                if((number.charAt(i)-'0')>maxV) {
                    maxV = number.charAt(i) - '0';
                    maxIndex = i;
                }
            }
            remainK -= (maxIndex-lastIndex);
            answer.append(number.charAt(maxIndex));
            lastIndex = maxIndex+1;
            if(remainK==number.length()-lastIndex){
                lastIndex = number.length();
                break;
            }
        }
        answer.append(number.substring(lastIndex));
        return answer.toString();
    }
}
