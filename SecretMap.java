class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0 ;i < n; i++){
            boolean[] firstWall = makeTwoNumber(n,arr1[i]);
            boolean[] secondWall = makeTwoNumber(n,arr2[i]);
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n;j++){
                if(firstWall[j]||secondWall[j]){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;


    }

    public boolean[] makeTwoNumber(int k, int num){
        boolean[] isWall = new boolean[k];
        int index = k-1;
        while(num > 0){
            isWall[index] = num%2==0?false:true;
            index--;
            num = num/2;
        }
        return isWall;
    }
}