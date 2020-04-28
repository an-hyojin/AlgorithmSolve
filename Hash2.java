class Hash2 {
    public static boolean solution(String[] phone_book) {
        for(int i =0 ; i < phone_book.length;i++){
            for(int j =i+1 ; j< phone_book.length;j++){
                if(phone_book[j].startsWith(phone_book[i])){
                    return false;
                }else if (phone_book[i].startsWith(phone_book[j])) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        String[] first ={"119", "98674223","1195524421"};
        String[] second = {"123","456","789"};
        String[] third = {"12","123","1235","567","88"};
        System.out.println(solution(first));
        System.out.println(solution(second));
        System.out.println(solution(third));
    }
}