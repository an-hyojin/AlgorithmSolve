import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Heap3 {
    static ArrayList<Task> heap = new ArrayList();
    static class Task{
        int request;
        int time;
        Task(int r, int t){
            this.request = r;
            this.time = t;
        }


    }
    public static void main(String[] args){
        int[][] a = {{0,3}, {1,9}, {2, 6}};
        System.out.println(solution(a));
    }
    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });
        int time = 0;
        int index=0;
        Task running = null;
        int remainTime = 0;
        int requireTime = 0;
        while(heap.size()>1||index<jobs.length){
            while(index<jobs.length&&jobs[index][0]==time){
                insertHeap(new Task(jobs[index][0], jobs[index][1]));
                index++;
            }
            if(remainTime==0){
                if(running!=null){
                    requireTime += time -running.request;
                }
                running = getMin();
                if(running!=null){
                    remainTime = running.time;
                }
            }
            if(running!=null){
                remainTime--;
            }
            time++;
        }
        requireTime += time+remainTime - running.request;
        return requireTime/jobs.length;
    }
    public static void insertHeap(Task k){
        if(heap.size()==0){
            heap.add(null);
        }
        heap.add(k);
        int i = heap.size()-1;
        while(i>1 &&(heap.get(i).time<heap.get(i/2).time)){
            Task swap =heap.get(i);
            heap.set(i, heap.get(i/2));
            heap.set(i/2, swap);
            i = i/2;
        }
    }
    public static Task getMin(){
        Task min= null;
        if(heap.size()>1){
            min = heap.get(1);
            heap.set(1,heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
            int length = heap.size();
            int i = 1;
            while(i<length){
                int minIndex = i;
                Task minItem = heap.get(minIndex);
                if(i*2<length&&minItem.time>heap.get(i*2).time){
                    minIndex = i*2;
                    minItem = heap.get(i*2);
                }
                if (i * 2 + 1 < length&&minItem.time>heap.get(i*2+1).time) {
                    minIndex = i*2+1;
                    minItem = heap.get(i*2+1);
                }
                if(minIndex==i){
                    break;
                }
                heap.set(minIndex, heap.get(i));
                heap.set(i, minItem);
                i= minIndex;

            }
        }

        return min;
    }
}
