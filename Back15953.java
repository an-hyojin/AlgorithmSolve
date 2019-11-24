import java.util.Scanner;

public class Back16507 {
    public static void main(String[] args){
        Scanner aScanner = new Scanner(System.in);
        int T = aScanner.nextInt();
        for(int i = 0 ;i <T; i++){
            int a = aScanner.nextInt();
            int b = aScanner.nextInt();
            System.out.println(getFirtst(a)+getSecond(b));
        }
    }

    public static int getFirtst(int rank){
       if(rank==0){
           return 0;
       }
        if(rank==1){
            return 5000000;
        }else if(rank<=3){
            return 3000000;
        }else if(rank<=6){
            return 2000000;
        }else if(rank<=10){
            return 500000;
        }else if(rank<=15){
            return 300000;
        }else if(rank<=21){
            return 100000;
        }else{
            return 0;
        }
    }

    public static int getSecond(int rank){
        if(rank==0){
            return 0;
        }
        if(rank==1){
            return 5120000;
        }else if(rank<=3){
            return 2560000;
        }else if(rank<=7){
            return 1280000;
        }else if(rank<=15){
            return 640000;
        }else if(rank<=31){
            return 320000;
        }else{
            return 0;
        }
    }
}
