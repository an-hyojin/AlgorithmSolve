public class KakaoWinter5 {
    public static void main(String[] args){
        int r =solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1},3);
    System.out.println(r);
    }
    public static int canGo;
    public static int[] stoneArray;
    public static int solution(int[] stones, int k) {
        stoneArray = stones;
        canGo = k;
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int stone : stones) {
            if (stone > max) {
                max = stone;
            }
            if (stone < min) {
                min = stone;
            }
        }

       return binarySearch(min, max);

    }
    public static int binarySearch(int min, int max){
        int mid = (min+max)/2;

        if(min==mid){
            return min;
        }

        if(canGoWith(mid)){
           return binarySearch(mid, max);
        }else{
            return binarySearch(min, mid);
        }

    }
    public static boolean canGoWith(int number){
        int[] stones = stoneArray.clone();
        for (int i=0 ; i < stones.length; i++) {
            stones[i]=stones[i]-number+1;
        }
        int step = 1;
        for(int j=0; j< stones.length; j++){
            if(stones[j]<=0){
                step++;
            }else{
                step =1;
                stones[j]--;
            }
            if(step>canGo){
                return false;
            }
        }

        return true;
    }
}
