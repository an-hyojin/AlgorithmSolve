import java.util.Scanner;

public class 분노_유발자 {

	public static void main(String[] args) {
		Scanner aScanner = new Scanner(System.in);
		int studentNum = aScanner.nextInt();
		int[] height = new int[studentNum];

		for (int i = 0; i < studentNum; i++) {
			height[i] = aScanner.nextInt();
		}
		int maxHeight = height[studentNum - 1];
		int angryNum = 0;
		for (int i = studentNum - 2; i >= 0; i--) {
			if (height[i] > maxHeight) {
				angryNum++;
				maxHeight = height[i];
			}
		}
//		for(int i = 0 ; i< studentNum-1;i++) {
//			for(int j = i+1; j< studentNum; j++) {
//				if(height[i]<height[j]) {
//					break;
//				}
//				if(j+1==studentNum) {
//					System.out.println(i);
//					angryNum++;
//				}
//			}
//		}
		System.out.println(angryNum);
		
	}
}
