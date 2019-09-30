
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Back2261 {

    public static ArrayList<Point> pointArrayList;
    public static int ARRAY_LENGTH;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       ARRAY_LENGTH = Integer.parseInt(br.readLine());

       pointArrayList = new ArrayList<>();
        for(int i = 0; i<ARRAY_LENGTH; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pointArrayList.add(new Point(x, y));
        }
        pointArrayList.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x>o2.x){
                    return 1;
                }else if(o1.x==o2.x){
                    return 0;
                }else{
                    return -1;
                }
            }
        });
        int res = Closet_Pair(0, ARRAY_LENGTH-1);
        System.out.print(res);
    }
    public static int calcuTwo(Point p1, Point p2){
        int x1 = p1.x;
        int y1 =p1.y;
        int x2 = p2.x;
        int y2 = p2.y;
        return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
    }

    public static int calcuThree(Point p1, Point p2, Point p3){
        int len1 = calcuTwo(p1,p2);
        int len2 = calcuTwo(p2, p3);
        int len3 = calcuTwo(p1, p3);
        int shortest = Math.min(len1, len2);
        return Math.min(shortest, len3);
    }

    public static int Closet_Pair(int startX, int endX){
        if(endX<=startX){
            return Integer.MAX_VALUE;
        }else if(endX-startX<3){
            if(endX-startX==2){
                return calcuThree(pointArrayList.get(startX), pointArrayList.get(startX+1), pointArrayList.get(endX));
            }else{
                return calcuTwo(pointArrayList.get(startX),pointArrayList.get(endX));
            }
        }
        int mid = (endX+startX)/2;
        int leftSide = Closet_Pair(startX, mid);
        int rightSide = Closet_Pair(mid+1, endX);
        int shortest = Math.min(leftSide, rightSide);
        //mid의 X값 - shortest인 만큼 + shortest인만큼

        ArrayList<Point> tempArray = new ArrayList<>();
        Point midP = pointArrayList.get(mid);

        for(int i = startX ; i<=endX; i++){
            int len  = Math.abs(midP.x - pointArrayList.get(i).x);
            if(len*len<shortest){
                tempArray.add(pointArrayList.get(i));
            }
        }

        tempArray.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.y>o2.y){
                    return 1;
                }else if(o1.y==o2.y){
                    return 0;
                }else{
                    return -1;
                }
            }
        });
        //window 내부의 최소거리 구하기
        int midShort = shortest;
        for(int i = 0 ; i<tempArray.size() ;i++){
            for(int j = i+1; j<tempArray.size();j++) {
                Point p1 = tempArray.get(i);
                Point p2 = tempArray.get(j);
                if ((p2.y - p1.y)*(p2.y-p1.y) < shortest) {
                    int len =calcuTwo(p1,p2);
                    midShort = Math.min(midShort, len);
                } else{
                    break;
                }
            }
        }
        return midShort;

    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
