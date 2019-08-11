import java.math.BigInteger;
import java.util.Scanner;

public class 숫자의_총개수_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner aScanner = new Scanner(System.in);
		/*BigInteger aNumber = aScanner.nextBigInteger();
		// 9까지 1개 90까지 2개 900까지 3개
		BigInteger nowNum = new BigInteger(String.valueOf("9"));
		BigInteger totalNum = BigInteger.ZERO;
		BigInteger addNum = BigInteger.ONE;
		BigInteger nextNum = nowNum.multiply(BigInteger.TEN);
		while (aNumber.compareTo(nextNum) <= 0) {
			if (aNumber.compareTo(nowNum) <= 0) {
				BigInteger temp = aNumber.subtract(nowNum.divide(BigInteger.TEN));
				totalNum = totalNum.add(temp.multiply(addNum));
				break;
			} else {
				totalNum = totalNum.add(nowNum.multiply(addNum));
				System.out.println("totalNum:" + totalNum);
				addNum = addNum.add(BigInteger.ONE);
				System.out.println("addNum:" + addNum);
				nowNum = nowNum.multiply(BigInteger.TEN);
				System.out.println("nowNum:" + nowNum);
				nextNum = nowNum.multiply(BigInteger.TEN);
				System.out.println("nextNum:" + nextNum);
			}
		}
*/
		int multiNum = 1;
		int compareNum = 9;
		int multiCompare = compareNum;
		int scanNum = aScanner.nextInt();
		int total = 0;
		int ten = 10;
		int result = scanNum;
		while (result != 0) {
			if (scanNum > ten) {
				total += multiNum * compareNum;
				compareNum = compareNum * 10;
				multiCompare += compareNum;
				ten *= 10;
				multiNum ++;
				result = result%10;
			} else {
				total = (scanNum - multiCompare/10) * multiNum + total;
				break;
			}
		}
		Integer a = 3;
		System.out.println(total);
		System.out.println("298954307");
		System.out.println(1000000000);
	}

}
