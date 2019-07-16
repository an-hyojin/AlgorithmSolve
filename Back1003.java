import java.util.Scanner;
public class Back1003 {
	public static int[] fiboCall_Zero = new int[41];
	public static int[] fiboCall_One = new int[41];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner aScanner = new Scanner(System.in);
		int testNum = aScanner.nextInt();
		fiboCall_Zero[0] = 1;
		fiboCall_One[0] = 0;
		
		fiboCall_Zero[1] = 0;
		fiboCall_One[1] = 1;
		
		for(int i = 0; i< testNum; i++) {
			int test = aScanner.nextInt();
			System.out.println(returnZero(test)+" "+returnOne(test));
		}
	}
	
	public static int returnOne(int num) {
		if(num<=1) {
			return fiboCall_One[num];
		}
		if(fiboCall_One[num]!=0) {
			return fiboCall_One[num];
		}
		int fibo1 = fiboCall_One[num-1];
		if(fibo1==0) {
			fibo1 = returnOne(num-1);	
		}
		int fibo2 = fiboCall_One[num-2];
		if(fibo2==0) {
			fibo2= returnOne(num-2);
		}
		fiboCall_One[num] = fibo1+fibo2;
		return fiboCall_One[num];
	}
	
	public static int returnZero(int num) {
		if(num<=1) {
			return fiboCall_Zero[num];
		}
		if(fiboCall_Zero[num]!=0) {
			return fiboCall_Zero[num];
		}
		int fibo1 = fiboCall_Zero[num-1];
		if(fibo1==0) {
			fibo1 = returnZero(num-1);	
		}
		int fibo2 = fiboCall_Zero[num-2];
		if(fibo2==0) {
			fibo2= returnZero(num-2);
		}
		fiboCall_Zero[num] = fibo1+fibo2;
		return fiboCall_Zero[num];
	}

}
