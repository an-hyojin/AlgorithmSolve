import java.util.Scanner;
public class Main {
	public static int[] least;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner aScanner = new Scanner(System.in);
		int arraySize = aScanner.nextInt();
		least = new int[arraySize+1];
		
		int solveNum = arraySize;
		System.out.println(solve(solveNum));
	}
	
	public static int solve(int num) {
		if(num==1) {
			return 0;
		}
		int returnNum;
		if(num%6==0) {
			int three = least[num/3];
			if(three==0) {
				three = solve(num/3);
			}
			int two = least[num/2];
			if(two==0) {
				two = solve(num/2);
			}
			int one = least[num-1];
			if(one ==0) {
				one = solve(num-1);
			}
			if(three>two) {
				if(two>one) {
					returnNum =one;
				}else {
					returnNum = two;
				}
			}else {
				if(three>one) {
					returnNum = one;
				}else {
					returnNum = three;
				}
			}
		}
		else if(num%3==0) {
			int three = least[num/3];
			if(three==0) {
				three = solve(num/3);
			}
			int one = least[num-1];
			if(one ==0) {
				one = solve(num-1);
			}
			if(three>one) {
				returnNum =  one;
			}else {
				returnNum = three;
			}
		}else if(num%2==0) {
			int two = least[num/2];
			if(two==0) {
				two = solve(num/2);
			}
			int one = least[num-1];
			if(one ==0) {
				one = solve(num-1);
			}
			if(two>one) {
				returnNum = one;
			}else {
				returnNum = two;
			}
		}else {
			int one = least[num-1];
			if(one==0) {
				one = solve(num-1);
			}
			returnNum = one;
		}
		least[num] = returnNum+1;
		return least[num];
	}
	

}
