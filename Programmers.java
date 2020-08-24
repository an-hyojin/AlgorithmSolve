import java.time.*;
public class Programmers {
    public static String solution(int a, int b) {
       LocalDate d = LocalDate.of(2016, a, b);
      return d.getDayOfWeek().toString().substring(0,3);
    }
    public static void main(String[] args){
        System.out.println(solution(8,14));
    }

}
