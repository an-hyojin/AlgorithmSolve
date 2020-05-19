public class Complete4 {
    public static void main(String[] args){
        solution(10,2);
        solution(8,1);
        solution(24,24);

    }
    public static int[] solution(int brown, int yellow){
        int sum = brown+yellow;
        int row=0, col=0;
        for(int i=3 ; i*i<=sum ; i++){
            if(sum%i==0){
                col = i;
                row = sum/i;
                int b = row*2+(col-2)*2;
                int c = (col-2)*(row-2);
                if(b==brown&&c==yellow){
                    System.out.println(row+" "+ col);
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{0,0};
    }
}