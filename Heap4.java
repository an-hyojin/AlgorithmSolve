import java.util.ArrayList;

public class Heap4 {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        int[] a = solution(new String[]{"I 16", "D 1"});
        int[] b = solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
        System.out.println(a[0]+" "+a[1]);
        System.out.println(b[0]+" "+b[1]);
    }
    public static int[] solution(String[] operations) {
        int[] answer = {0,0};
        for (String operation : operations) {
            if (operation.charAt(0) == 'I') {
                int value = Integer.parseInt(operation.split(" ")[1]);
                insert(value);
            } else {
                if (list.size() > 0) {
                    if (operation.split(" ")[1].equals( "1")) {
                        list.remove(list.size() - 1);
                    } else {
                        list.remove(0);
                    }
                }
            }
        }

        if(list.size()>0){
         answer[1] = list.get(0);
         answer[0] = list.get(list.size()-1);
        }
        return answer;
    }
    public static void insert(int num){
        int right = list.size()-1;
        int left = 0;
        int mid = (right+left)/2;
        System.out.println("지금 넣는 것 :"+num);
        while(left<=right){
             mid = (right+left)/2;
            System.out.println("left : " + left + " , right: " +right+", mid:"+mid);

            if(list.get(mid)==num){
                list.add(mid, num);
                return;
            }else if(list.get(mid)>num){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        list.add(left, num);
    }

}
