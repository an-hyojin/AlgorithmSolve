import java.util.Scanner;
public class Back9095 {
	public static int[] solveSum = new int[11];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner aScanner = new Scanner(System.in);
		int testNum = aScanner.nextInt();
		for(int i = 0; i<testNum; i++) {
			int num = aScanner.nextInt();
			solveSum[1] = 1;
			solveSum[2] = 2;
			solveSum[3] = 4;
			if(num<=3) {
				System.out.println(solveSum[num]);
			}else {
				System.out.println(sumMethod(num));
			}	
		}
	}
	
	public static int sumMethod(int num) {
		if(num<=3) {
			return solveSum[num];
		}
		int minusOne = solveSum[num-1];
		if(minusOne ==0) {
			minusOne = sumMethod(num-1);
		}
		int minusTwo = solveSum[num-2];
		if(minusTwo ==0) {
			minusTwo = sumMethod(num-2);
		}
		int minusThree = solveSum[num-3];
		if(minusThree ==0) {
			minusThree = sumMethod(num-3);
		}
		solveSum[num]=minusOne+minusTwo+minusThree;
		return solveSum[num];
	}
}
