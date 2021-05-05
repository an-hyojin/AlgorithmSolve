class KakaoFriendsColoringBook {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] isVisit = new boolean[m][n];
        for(int i=0 ;i<m; i++){
            for(int j= 0;j<n;j++){
                if(picture[i][j]!=0 && !isVisit[i][j]){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, getSize(picture, isVisit, picture[i][j], i, j));
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public int getSize(int[][] picture, boolean[][] isVisit, int num, int x, int y){
        if(x<0 || x>= picture.length || y < 0 || y>=picture[0].length){
            return 0;
        }
        if(picture[x][y]==num && !isVisit[x][y]){
            isVisit[x][y] = true;
            int up = getSize(picture, isVisit, num, x, y-1);
            int down = getSize(picture,isVisit, num , x, y+1);
            int right = getSize(picture,isVisit, num , x+1, y);
            int left = getSize(picture,isVisit, num, x-1, y);
            return up+down+right+left +1;
        }else{
            return 0;
        }
    }
}
