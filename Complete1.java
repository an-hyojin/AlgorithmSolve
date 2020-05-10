import java.util.Arrays;

public class Complete1 {
    public static void main(String[] args){
        solution(new int[]{1,2,3,4,5});
    }
    public static int[] solution(int[] answers) {
        int[] answer1 = {1,2,3,4,5};
        int[] answer2 = {2,1,2,3,2,4,2,5};
        int[] answer3 = {3,3,1,1,2,2,4,4,5,5};

        Score[] scores = {new Score(1,0),new Score(2,0),new Score(3,0)};
        for(int i=0; i< answers.length; i++){
            int answer = answers[i];
            if(answer==answer1[i%5])scores[0].score++;
            if(answer==answer2[i%8])scores[1].score++;
            if(answer==answer3[i%10])scores[2].score++;
        }
        Arrays.sort(scores);

        if(scores[0].score==scores[1].score){
            if(scores[0].score==scores[2].score){
                return new int[]{1,2,3};
            }else{
                return new int[]{scores[0].num, scores[1].num};
            }
        }else{
            return new int[]{scores[0].num};
        }

    }
    static class Score implements Comparable<Score>{
        int num;
        int score;
        public Score(int n, int s){
            this.num = n;
            this.score = s;
        }

        @Override
        public int compareTo(Score o) {
            if(o.score<this.score)return -1;
            else if(o.score==this.score) return 0;
            else return 1;
        }
    }
}
