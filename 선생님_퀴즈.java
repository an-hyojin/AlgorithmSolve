import java.util.Scanner;

public class ¼±»ı´Ô_ÄûÁî {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner aScanner = new Scanner(System.in);
		int repeat = aScanner.nextInt();
		
		for(int i = 0; i < repeat; i++) {
			int num = aScanner.nextInt();
			int answer = aScanner.nextInt();
			if(RightAnswer(num)==answer) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	
	public static int RightAnswer(int num) {
		int multiNum = num+1;
		int result = multiNum*(num/2);
		if(num%2==1) {
			result += (num/2+1);
		}
		return result;
	}

}
