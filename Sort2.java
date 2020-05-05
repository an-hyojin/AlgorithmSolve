import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort2 {
    public static void main(String[] args){
        System.out.println(solution(new int[]{0,0,0,0}));
    }
    public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        ArrayList<Integer> numList = new ArrayList<>();
        for(int num:numbers){
            numList.add(num);
        }
        Collections.sort(numList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                String a = o1.toString();
                if(a.length()==1){
                    o1=o1*100000+o1*10000+o1*1000+o1*100+o1*10+o1;
                }else if(a.length()==2){
                    o1=o1*10000+o1*100+o1;
                }else if(a.length()==3){
                    o1=1000*o1+o1;
                }
                String b = o2.toString();
                if(b.length()==1) {
                    o2=o2*100000+o2*10000+o2*1000+o2*100+o2*10+o2;
                } else if(b.length()==2){  o2=o2*10000+o2*100+o2;
                }else if(b.length()==3){
                    o2=1000*o2+o2;
                }

                if(o1>o2){
                    return -1;
                }else if(o1.equals(o2)){
                    return 0;
                }
                return 1;
            }
        });

        for (Integer integer : numList) {
            answer.append(integer.toString());
        }
        String res = answer.toString();
        for(int i=0; i<res.length(); i++){
           if( res.charAt(i)!='0'){
               return res;
           }
        }

        return "0";
    }
}
