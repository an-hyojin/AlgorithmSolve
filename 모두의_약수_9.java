import java.util.Scanner;

public class 모두의_약수_9 {
	public static int[] number;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner aScanner = new Scanner(System.in);
		int size = aScanner.nextInt();
		number = new int[size+1];
		for(int i = 1; i<=size;i++) {
			for(int j=i;j<=size;j=i+j) {
				number[j] +=1;
			}
		}
		for(int i = 1; i<=size;i++) {
			System.out.print(number[i] +" ");
			if(i%100==0) {
				System.out.println("");
			}
		}
		
	}

}
