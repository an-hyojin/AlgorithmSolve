import java.util.ArrayList;

public class Pro1 {
    static ArrayList<Integer> heap;
    public static void main(String[] args){
        int a = solution(new int[]{9,8,7,5,4,5,6,8}, 30);
        System.out.println(a);
    }
    public static int solution(int[] scoville, int K) {
        heap = new ArrayList<>();
        heap.add(-1);//0번째 index 채우기 위
        for(int i =0 ; i< scoville.length; i++){
            insertHeap(scoville[i]);
        }
        print();
        int nowScovile;
        int n =0;

        while(heap.size()>2){
            int a = getMin();
            int b = getMin();
            if(a>=K&&b>=K){
                return n;
            }
            n++;
            nowScovile = a + 2*b;
            print();
            insertHeap(nowScovile);
        }
        if(getMin()>=K){
            return n;
        }
        return -1;
    }
    public static void print(){
        for(int i =1 ; i<heap.size(); i++){
            System.out.print(heap.get(i)+" ");
        }
        System.out.println();
    }
    public static void insertHeap(int k){
        heap.add(k);
        int i = heap.size()-1;
        while(i>1 &&(heap.get(i)<heap.get(i/2))){
            int swap =heap.get(i);
            heap.set(i, heap.get(i/2));
            heap.set(i/2, swap);
            i = i/2;
        }
    }
    public static int getMin(){
        int min= -1;
        if(heap.size()>1){
            min = heap.get(1);
            heap.set(1,heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
            int length = heap.size();
            int i = 1;
            while(i<length){
                int minIndex = i;
                int minItem = heap.get(minIndex);
                if(i*2<length&&minItem>heap.get(i*2)){
                    minIndex = i*2;
                    minItem = heap.get(i*2);
                }
                if (i * 2 + 1 < length&&minItem>heap.get(i*2+1)) {
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
