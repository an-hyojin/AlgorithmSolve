import java.util.Scanner;

public class Back16507 {
    public static void main(String[] args){
        Scanner aScanner = new Scanner(System.in);
        int row = aScanner.nextInt();
        int col = aScanner.nextInt();
        int num = aScanner.nextInt();
        int[][] display = new int[row][col];
        int[][] displayCount = new int[row][col];

        for(int i=0; i<row; i++){
            for(int j =0 ; j<col; j++){
                display[i][j] = aScanner.nextInt();
            }
        }

        displayCount[0][0] = display[0][0];
        for(int i =1 ; i<col; i++){
            displayCount[0][i] = displayCount[0][i - 1] + display[0][i];
        }
        for(int i=1; i<row; i++){
            for(int j =0 ; j<col; j++){
                if(j==0){
                    displayCount[i][j] = displayCount[i-1][j] + display[i][j];
                }else{
                    displayCount[i][j] = displayCount[i][j-1]+displayCount[i-1][j] - displayCount[i-1][j-1]+display[i][j];
                }
            }
        }
        for(int i =0 ; i <num; i++){
            int fR = aScanner.nextInt()-1;
            int fC = aScanner.nextInt()-1;
            int lR = aScanner.nextInt()-1;
            int lC = aScanner.nextInt()-1;
            int r = displayCount[lR][lC];
            if(fR>0){
                r-= displayCount[fR-1][lC];
            }
            if(fC>0){
                r-= displayCount[lR][fC-1];
            }
            if(fR>0&&fC>0){
                r+=displayCount[fR-1][fC-1];
            }
            r = r / ((lR-fR+1)*(lC-fC+1));
            System.out.println(r);
        }
    }
}
