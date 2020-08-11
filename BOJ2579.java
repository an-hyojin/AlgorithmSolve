import java.util.Scanner;

public class BOJ2579 {
    public static int[] maxNums;
    public static void main(String[] args){
        Scanner aScanner = new Scanner(System.in);
        int num = aScanner.nextInt();
        int[] numbers = new int[num];
        maxNums = new int[num];
        for(int i=0; i< num; i++){
            numbers[i] = aScanner.nextInt();
        }
        maxNums[0] = numbers[0]; //0
        if (num==1){
            System.out.println(maxNums[num-1]);
            return;
        }
        maxNums[1] = numbers[0]+numbers[1];//1
        if (num==2){
            System.out.println(maxNums[num-1]);
            return;
        }
        maxNums[2] = Math.max(numbers[0], numbers[1])+numbers[2]; //2
        if (num==3){
            System.out.println(maxNums[num-1]);
            return;
        }

        for(int i=3; i< num; i++){
            int before1 = maxNums[i-3]+ numbers[i-1]+numbers[i];
            int now = maxNums[i-2] + numbers[i];
            maxNums[i] = Math.max(before1, now);
        }
        System.out.println(maxNums[num-1]);
    }
}
