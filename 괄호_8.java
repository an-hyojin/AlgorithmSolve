import java.util.Stack;
import java.util.Scanner;

public class °ýÈ£_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack pushStack = new Stack();
		Scanner aScanner = new Scanner(System.in);
		String push = aScanner.next();
		for(int i = 0; i<push.length(); i++) {
			if(push.charAt(i)=='(') {
				pushStack.push('(');
			}else if(push.charAt(i)==')'){
				if(pushStack.size()<=0) {
					System.out.println("NO");
					return;
				}else {
					pushStack.pop();	
				}
				
			}
		}
		if(pushStack.size()==0) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

}
