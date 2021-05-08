class LockAndKey {
    public boolean solution(int[][] key, int[][] lock) {
        int n = key.length-1;

        for(int a=0; a<4;a++){
            key = rotate(key);
            for(int i=0 ;i < lock.length + key.length-1; i++){
                for(int j =0 ; j< lock.length +key.length-1; j++){
                    int[][] matchSize = new int[ lock.length +2*(key.length -1)][ lock.length +2*(key.length -1)];
                    for(int k =0 ; k < key.length; k++){
                        for(int l =0 ; l<key.length; l++){
                            matchSize[i+k][l+j] = key[k][l];
                        }
                    }
                    if(isOpen(matchSize, lock, n)) return true;
                }
            }
        }
        return false;
    }
    public int[][] rotate(int[][] key){
        int[][] res = new int[key.length][key.length];
        for(int i=0; i< key.length ; i++){
            for(int j =0; j< key.length ;j++){
                res[i][j] = key[j][key.length-i-1];
            }
        }
        return res;
    }
    public boolean isOpen(int[][] key, int[][] lock, int n){
        for(int i=0 ; i< lock.length ; i++){
            for(int j=0 ; j < lock.length; j++){
                if(key[n+i][n+j] == lock[i][j]) return false;
            }
        }
        return true;
    }
}