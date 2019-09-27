import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Sort {
    static int ARRAY_LENGTH;

    public static void main(String[] args) {
        //파일 읽는 부분
        String filePath = "C:\\Users\\HyoJin\\Downloads\\data02.txt";
        String s ="";
        try (FileInputStream fstream= new FileInputStream(filePath);){
            byte[] rb = new byte[fstream.available()];
            while(fstream.read(rb) != -1) {}
            fstream.close();
            s = new String(rb);
        }catch(Exception e) {
            e.getStackTrace();
        }
        //String -> int로 바꾸는 부분
        String[] StringArray = s.split(",");
        ARRAY_LENGTH = StringArray.length;
        int[] array1 = new int[StringArray.length];
        int[] array2 = new int[StringArray.length];
        for(int i = 0; i<StringArray.length; i++){
            array1[i] = Integer.valueOf(StringArray[i]);
            array2[i] = Integer.valueOf(StringArray[i]);
        }

        //InsertionSort file write
        try (FileWriter fw = new FileWriter("InsertionSort.txt")){
            System.out.println("정렬 전: "+ arrayToString(array1));
            InsertionSort(array1);
            String result = arrayToString(array1);
            fw.write(result);
            System.out.println("InsertionSort: "+ result);
        }catch(IOException e){//오류있을경우
            e.printStackTrace();//오류 출력
        }


        //MergeSort fileWrite
        try (FileWriter fw = new FileWriter("MergeSort.txt")){
            System.out.println("정렬 전: "+ arrayToString(array2));
            mergeRecursion(0, array2.length-1, array2);
            String result = arrayToString(array2);
            fw.write(result);
            System.out.println("MergeSort: "+ result);
        }catch(IOException e){//오류있을경우
            e.printStackTrace();//오류 출력
        }

    }
    public static String arrayToString(int[] array){
        String str="";
        for(int i = 0 ; i<array.length;i++){
            str+=array[i];
            if(i != array.length-1){
                str+=" ,";
            }
        }
        return str;
    }

    public static void mergeRecursion(int start, int end, int[] temp){
        if(start<end){
            //앞배열 정렬
            //뒷배열 정렬
            int mid = (start+end)/2;
            mergeRecursion(start, mid,temp);
            mergeRecursion(mid+1, end, temp);
            int firstTemp = start;
            int secondTemp = mid + 1;
            int[] result = new int[ARRAY_LENGTH];

            for(int i = start ; i <=end; i++){
                //비교하면서 배열에 값 넣어줌
                if(temp[firstTemp]<temp[secondTemp]){
                    result[i] = temp[firstTemp];
                    firstTemp++;
                }else{
                    result[i] = temp[secondTemp];
                    secondTemp++;
                }
                //한 배열이 다 끝났을 경우
                if(firstTemp>=mid+1){
                    for(int j = i+1; j <=end; j++){
                        result[j] = temp[secondTemp];
                        secondTemp++;
                    }
                    break;
                }else if(secondTemp>end){
                    for(int j = i+1; j <=end; j++){
                        result[j] = temp[firstTemp];
                        firstTemp++;
                    }
                    break;
                }
            }
            //구한 배열의 값을 매개변수로 받은 temp로 옮겨줌
            for(int i = start; i<= end; i++) {
                temp[i] = result[i];
            }
        }
    }

    public static void InsertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp >= array[j]) {
                    break;
                } else {
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

    }
}
