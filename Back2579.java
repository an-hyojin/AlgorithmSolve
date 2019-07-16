import java.util.Scanner;
public class Back2579 {
	
	public static int[] floorScore;
	public static int[] ScoreOf;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner aScanner = new Scanner(System.in);
		int floorNum = aScanner.nextInt();
		floorScore = new int[floorNum+1];
		ScoreOf = new int[floorNum+1];
		
		for(int i = 1; i<=floorNum;i++) {
			floorScore[i] = aScanner.nextInt();
		}
		ScoreOf[1] = floorScore[1];
		ScoreOf[2] = floorScore[1]+floorScore[2];
		
		System.out.println(bestScore(floorNum));
		
	}
	
	public static int bestScore(int num) {
		if(num<=2|| ScoreOf[num]!=0) {
			return ScoreOf[num];
		}
		int minusTwo = ScoreOf[num-2];
		if(minusTwo==0) {
			minusTwo = bestScore(num-2);
		}
		int minusThree = ScoreOf[num-3];
		if(minusThree==0) {
			minusThree = bestScore(num-3);
		}
		int firstCase = floorScore[num-1]+minusThree;
		int secondCase = minusTwo;
		
		if(firstCase>secondCase) {
			ScoreOf[num] = firstCase+floorScore[num];
		}else {
			ScoreOf[num] = secondCase+floorScore[num];
		}

		return ScoreOf[num];
		
	}
}
