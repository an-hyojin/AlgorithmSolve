import java.io.FileInputStream;
import java.util.ArrayList;

public class Main {

    static int n;
    static double[][] error;
    static double[][] aList;
    static double[][] bList;

    public static void main(String[] args) {
        String filePath = "C:\\Users\\HyoJin\\Downloads\\data08.txt";
        String s = "";
        try (FileInputStream fstream = new FileInputStream(filePath);) {
            byte[] rb = new byte[fstream.available()];
            while (fstream.read(rb) != -1) {
            }
            fstream.close();
            s = new String(rb);
        } catch (Exception e) {
            e.getStackTrace();
        }
        String[] list = s.split(",");

        n = Integer.parseInt(list[0]);
        ArrayList<Point> points = new ArrayList<>();
        points.add(null);
        for (int i = 1; i <= n; i++) {
            points.add(new Point(Double.parseDouble(list[2 * (i - 1) + 1]), Double.parseDouble(list[2 * i])));
        }

        double Cost = Double.parseDouble(list[list.length - 1]);
        Segmented_Least_Squares(points, Cost);
    }

    public static double Segmented_Least_Squares(ArrayList<Point> points, double cost) {
        double[] M = new double[n + 1];
        M[0] = 0;
        error = new double[n + 1][n + 1];
        aList = new double[n + 1][n + 1];
        bList = new double[n + 1][n + 1];

        for (int j = 1; j <= n; j++) {
            for (int I = 1; I <= j; I++) {
                double xy = 0, xSquare = 0, ySum = 0, xSum = 0;
                for (int k = I; k <= j; k++) {
                    double x = points.get(k).xPoint;
                    double y = points.get(k).yPoint;
                    xy += x * y;
                    xSum += x;
                    ySum += y;
                    xSquare += x * x;
                }
                int size = j - I + 1;
                double bottom = (size * xSquare - xSum * xSum);
                double a = (size * xy - xSum * ySum) / (size * xSquare - xSum * xSum);
                if (bottom == 0) {
                    a = 0;
                }
                double b = (ySum - a * xSum) / size;
                aList[I][j] = a;
                bList[I][j] = b;
                double errorSquare = 0;

                for (int t = I; t <= j; t++) {
                    errorSquare += Math.pow(points.get(t).yPoint - a * points.get(t).xPoint - b, 2);
                }
                error[I][j] = errorSquare;
            }
        }

        int visitIndex = 0;
        int[] visit = new int[n + 1];

        for (int j = 1; j <= n; j++) {
            double i = M[0] + error[1][j] + cost;
            for (int in = 1; in <= j; in++) {
                if (M[in - 1] + error[in][j] + cost < i) {
                    i = M[in - 1] + error[in][j] + cost;
                    visitIndex = in;
                }
            }
            visit[j] = visitIndex;
            M[j] = i;
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0, n);
        int index = n;
        while (visit[index] != 0) {
            list.add(0, visit[index]);
            index = visit[index];
        }
        list.add(0, 1);

        printInfo(M[n], list);
        return M[n];
    }

    public static void printInfo(double optimalSolution, ArrayList<Integer> list) {
        System.out.printf("Cost of the optimal solution : %.6f\n", optimalSolution);
        System.out.println("An optimal solution : ");

        for (int j = 0; j < list.size() - 1; j++) {
            int now = list.get(j);
            int next = list.get(j + 1);
            if (j != list.size() - 2) {
                System.out.printf("[Segment %2d - %2d ] : y = %.6f * x + %.6f //square error : %.6f\n", now, next - 1, aList[now][next - 1], bList[now][next - 1], error[now][next - 1]);
            } else {
                System.out.printf("[Segment %2d - %2d ] : y = %.6f * x + %.6f //square error : %.6f\n", now, next, aList[now][next], bList[now][next], error[now][next]);
            }
        }
    }

    static class Point {
        double xPoint;
        double yPoint;

        Point(double x, double y) {
            this.xPoint = x;
            this.yPoint = y;
        }

    }

}
