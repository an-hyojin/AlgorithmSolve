import java.util.*;
class Greedy4 {
    public int solution(String name) {
        HashMap<Character,Integer> alphabets = new HashMap<>();
        for(int i='A';i<='Z';i++){
            alphabets.put((char)i, Math.min(i-65, 91-i));
        }
        int lastIndex=0;
        int total=0;
        for(int i=0; i<name.length();i++){
            total += alphabets.get(name.charAt(i));
        }
        int move1 = 0;
        for(int i=1; i< name.length(); i++){
            if(name.charAt(i)=='A')continue;
            if(lastIndex!=i-1){
                int back =name.length()-i+lastIndex;
                if(back<i-lastIndex){
                    move1+=back;
                    break;
                }else{
                    move1 += i-lastIndex;
                    lastIndex=i;
                }
            }else{
                move1++;
                lastIndex++;
            }
        }
        int move2 =0;
        lastIndex = name.length();
        for(int i=name.length()-1; i>0; i--){
            if(name.charAt(i)=='A')continue;
            if(lastIndex!=i+1){
                int back =name.length()-lastIndex+i;
                if(back<lastIndex-i){
                    move2+=back;
                    break;
                }else{
                    move2 += lastIndex-i;
                    lastIndex=i;
                }
            }else{
                move2++;
                lastIndex--;
            }
        }
        System.out.println(move2);

        return Math.min(move1, move2)+total;
    }
}