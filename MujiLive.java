import java.util.PriorityQueue;
import java.util.*;
class MujiLive {
    // 정확성 코드
    public int solution(int[] food_times, long k) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int index = 0;
        for(int i=0; i< k; i++){
            for(int j= 0; j< food_times.length ; j++){
                if(food_times[(index + j)%food_times.length]!=0){
                    food_times[(index + j)%food_times.length] -= 1;
                    // System.out.println((i+1) + " Time Eat " + (((index + j)%food_times.length) +1));
                    index = (index + j + 1)%food_times.length;
                    break;
                }
                if(j == food_times.length-1) return -1;
            }
        }
        for(int i=0 ;i< food_times.length ;i++){
            if(food_times[(index + i)%food_times.length]!=0){
                return (index + i)%food_times.length +1;
            }
        }
        return -1;
    }

    public int solutionReal(int[] food_times, long k) {
        PriorityQueue<Food> queue = new PriorityQueue<>();
        long sum = 0, before =0;
        for(int i=0; i< food_times.length;i++){
            queue.add(new Food(i, food_times[i]));
            sum += food_times[i];
        }
        if(sum <= k)return -1;
        while((queue.peek().count - before)*queue.size()<=k){
            k -= (queue.peek().count - before)*queue.size();
            before = queue.poll().count;
        }
        ArrayList<Food> list = new ArrayList<>();
        int size = queue.size();
        while(!queue.isEmpty()) {
            list.add(queue.poll());
        }
        // 음식의 번호 기준으로 정렬
        Collections.sort(list, new Comparator<Food>() {
            @Override
            public int compare(Food a, Food b) {
                return Integer.compare(a.number, b.number);
            }
        });
        return list.get((int)(k % size)).number+1;
    }

    class Food implements Comparable<Food>{
        int number;
        int count;
        Food(int n, int c){
            this.number = n;
            this.count = c;
        }

        @Override
        public int compareTo(Food f){
            if(this.count>f.count){
                return 1;
            }else if(this.count==f.count){
                if(this.number < f.number){
                    return -1;
                }else{
                    return 1;
                }
            }else{
                return -1;
            }
        }
    }

}