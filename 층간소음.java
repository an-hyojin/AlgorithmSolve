import java.util.Scanner;

public class Ãþ°£¼ÒÀ½ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner aScanner = new Scanner(System.in);
		int repeat = aScanner.nextInt();
		int maxNum = aScanner.nextInt();
		int longTime = 0;
		int realTime=0;
		for(int i = 0; i< repeat; i++) {
			int nowEstimate = aScanner.nextInt();
			
			if(nowEstimate>maxNum) {
				realTime++;
			}else {
				if(longTime<realTime) {
					longTime=realTime;
				}
				realTime=0;
			}
		}
		System.out.println(longTime);
	}

}
