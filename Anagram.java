import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner aScanner = new Scanner(System.in);
		int[] temp1 = new int[52];
		String firstString = aScanner.next();
		String secondString = aScanner.next();
		
		for(int i = 0 ; i<firstString.length();i++) {
			int firstStringNum = firstString.charAt(i);
			int secondStringNum = secondString.charAt(i);
			if(firstStringNum>='A'&&firstStringNum<='Z') {
				temp1[firstStringNum-65]++;
			}else {
				temp1[firstStringNum-71]++;
			}
			if(secondStringNum>='A'&&secondStringNum<='Z') {
				temp1[secondStringNum-65]--;
			}else {
				temp1[secondStringNum-71]--;
			}
			System.out.println(firstString.charAt(i) + ": "+ (int)firstString.charAt(i));
			System.out.println(secondString.charAt(i) + ": "+ (int)secondString.charAt(i));
			
		}
		for(int i = 0 ; i<52;i++) {
			if(temp1[i]!=0) {
				System.out.println("°ÅÁþ");
				return;
			}
		}
		System.out.println("Âü");
	}

}
