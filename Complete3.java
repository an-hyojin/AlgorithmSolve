import java.util.HashSet;
import java.util.Iterator;

public class Complete3 {


    public static void main(String[] args){
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        solution(baseball);
    }

    public static int solution(int[][] baseball) {
        HashSet<String> ableSet = new HashSet<>();
        for(int i=123; i <=987; i++){
            String iString = String.valueOf(i);
            int a0 = iString.charAt(0)-'0';
            int a1 = iString.charAt(1)-'0';
            int a2 = iString.charAt(2)-'0';
            if(a0==0||a1==0||a2==0||a0==a1||a1==a2||a2==a0){
                continue;
            }
            ableSet.add(iString);
        }
        for(int index=0; index<baseball.length;index++){
            int check = baseball[index][0];
            String checkString = String.valueOf(check);
            int c0 = checkString.charAt(0)-'0';
            int c1 = checkString.charAt(1)-'0';
            int c2 = checkString.charAt(2)-'0';
            int s = baseball[index][1];
            int b = baseball[index][2];
            for(int i=123; i<=987; i++){
                String iString = String.valueOf(i);
                if(!ableSet.contains(String.valueOf(i))){
                    continue;
                }
                int a0 = iString.charAt(0)-'0';
                int a1 = iString.charAt(1)-'0';
                int a2 = iString.charAt(2)-'0';
                if(a0==0||a1==0||a2==0||a0==a1||a1==a2||a2==a0){
                    continue;
                }
                int iBall =0;
                int iStrike = 0;

                if(a0==c0)iStrike++;
                if(a1==c1)iStrike++;
                if(a2==c2)iStrike++;

                if(a0==c1||a0==c2)iBall++;
                if(a1==c0||a1==c2)iBall++;
                if(a2==c0||a2==c1)iBall++;

                if(s!=iStrike||b!=iBall)ableSet.remove(iString);

            }
        }
        System.out.println(ableSet.size());
        return ableSet.size();
    }


}
