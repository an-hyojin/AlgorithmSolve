public class World124 {

        public String solution(int n) {
            return getV(n);
        }
        public String getV(int n){
            if(n==0){
                return "";
            }
            StringBuilder answer= new StringBuilder();
            answer.append(getV((n-1)/3));
            if(n%3==0){
                answer.append("4");
            }else {
                answer.append(n%3);
            }

            return answer.toString();
        }


}
