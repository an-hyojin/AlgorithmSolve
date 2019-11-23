import java.util.Scanner;

public class Back14274 {

    public static void main(String[] args){
        Scanner aScanner = new Scanner(System.in);
        int index = 0;
        int num = aScanner.nextInt();
        int max = 0;
        for(int i = 0; i<num*9;i++){
            int now = aScanner.nextInt();
            if(now>max){
                max = now;
                index = i;
            }
        }
        if(index<num){
           System.out.print("PROBRAIN");
        }else if(num<=index&&index<2*num){
            System.out.print("GROW");
        }else if(2*num<=index&&index<3*num){
            System.out.print("ARGOS");
        }else if(3*num<=index&&index<4*num){
            System.out.print("ADMIN");
        }else if(4*num<=index&&index<5*num){
            System.out.print("ANT");
        }else if(5*num<=index&&index<6*num){
            System.out.print("MOTION");
        }else if(6*num<=index&&index<7*num){
            System.out.print("SPG");
        }else if(7*num<=index&&index<8*num){
            System.out.println("COMON");
        }else{
            System.out.print("ALMIGHTY");
        }
    }

}
