import java.util.Arrays;
class Greedy4 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min=0;
        int max=people.length-1;
        while(min<max){
            if(people[max]+people[min]<=limit){
                max--;
                min++;
            }else{
                max--;
            }
            answer++;
            if(min==max)return answer+1;
        }
        return answer;
    }
}