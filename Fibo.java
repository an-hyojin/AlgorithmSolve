import java.math.BigInteger;
import java.util.Scanner;

public class Fibo {
    public static void main(String[] args){
        System.out.println("피보나치 수열 출력 1. Recursion 2. Array 3. Recursive Squaring");
        Scanner aScanner = new Scanner(System.in);
        int input =aScanner.nextInt();
        System.out.println("n값을 입력하세요");
        int n = aScanner.nextInt();

        switch (input){
            case 1:
                for(int i = 0; i<n+1;i++){
                    long start = System.nanoTime();
                    BigInteger result = recuFibo(i);
                    long end = System.nanoTime();
                    double time = ((double)(end-start))/1000000000;
                    System.out.printf("f<%4d> = %20d \t\t %.12f sec\n", i, result, time);
                }
                break;
            case 2:
                for(int i = 0; i<n+1;i++){
                    long start = System.nanoTime();
                    BigInteger result = bottom_up_fibo(i);
                    long end = System.nanoTime();
                    double time = ((double)(end-start))/1000000000;
                    System.out.printf("f<%4d> = %20d \t\t %.12f sec\n", i, result, time);
                }
                break;
            case 3:
                for(int i = 0; i<n+1;i++){
                    long start = System.nanoTime();
                    BigInteger result = recu_squaring(i);
                    long end = System.nanoTime();
                    double time = ((double)(end-start))/1000000000;
                    System.out.printf("f<%4d> = %20d \t\t %.12f sec\n", i, result, time);
                }
                break;
            default :
                break;
        }

    }

    public static BigInteger recuFibo(int num){
        if(num==0||num ==1){
            return BigInteger.valueOf(num);
        }else{
            return recuFibo(num-1).add(recuFibo(num-2));
        }
    }

    public static BigInteger bottom_up_fibo(int num){
        if(num<2){
            return BigInteger.valueOf(num);
        }
        BigInteger f1 = BigInteger.ZERO;
        BigInteger f2 = BigInteger.ONE;
        for(int i = 2 ; i<=num; i++){
            BigInteger temp =f2;
            f2 =f2.add(f1);
            f1 = temp;
        }
        return f2;
    }

    public static BigInteger recu_squaring(int n){
        if(n<2){
            return BigInteger.valueOf(n);
        }
        BigInteger[][] multi = new BigInteger[2][2];
        multi[0][0] = BigInteger.ONE;
        multi[0][1] = BigInteger.ONE;
        multi[1][0] = BigInteger.ONE;
        multi[1][1] = BigInteger.ZERO;
        return pow(multi, n-1)[0][0];
    }

    public static BigInteger[][] pow(BigInteger[][] A, int n){
        if(n<=1){
            return A;
        }else if(n%2==0){
            BigInteger[][] temp = pow(A, n/2);
            return mulMatrix(temp, temp);
        }else{
            BigInteger[][] temp = pow(A, (n-1)/2);
            temp = mulMatrix(temp, temp);
            BigInteger[][] multi = new BigInteger[2][2];
            multi[0][0] = BigInteger.ONE;
            multi[0][1] = BigInteger.ONE;
            multi[1][0] = BigInteger.ONE;
            multi[1][1] = BigInteger.ZERO;
            return mulMatrix(temp, multi);

        }
    }

    public static BigInteger[][] mulMatrix(BigInteger[][] A, BigInteger[][] B){
        BigInteger[][] result = new BigInteger[2][2];
        BigInteger a1 = A[0][0], a2 = A[0][1], a3 = A[1][0], a4 = A[1][1];
        BigInteger b1 = B[0][0], b2 = B[0][1], b3 = B[1][0], b4 = B[1][1];
        result[0][0] = a1.multiply(b1).add(a2.multiply(b3));
        result[0][1] = a1.multiply(b2).add(a2.multiply(b4));
        result[1][0] = a3.multiply(b1).add(a4.multiply(b3));
        result[1][1] = a3.multiply(b2).add(a4.multiply(b4));
        return result;
    }

    public static BigInteger recuPower(int a, int num){
        if(num==0){
            return BigInteger.ONE;
        }else if(num==1){
            return BigInteger.valueOf(a);
        }else if(num%2==0){
            BigInteger temp = recuPower(a, num/2);
            return temp.multiply(temp);
        }else{
            BigInteger temp = recuPower(a, (num-1)/2);
            return temp.multiply(temp).multiply(BigInteger.valueOf(a));
        }
    }
}
