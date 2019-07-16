import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner aScanner = new Scanner(System.in);
		int testNum = aScanner.nextInt();
		
		for(int i = 0; i < testNum; i++) {
			int hotelFloor = aScanner.nextInt();
			int floorNum = aScanner.nextInt();
			int client = aScanner.nextInt();
			
			int floor = client%hotelFloor;
			int roomNum = (client/hotelFloor)+1;
			if(floor == 0) {
				floor = hotelFloor;
				roomNum--;
			}
			
			System.out.println(floor*100 + roomNum);
		}
	}

}
