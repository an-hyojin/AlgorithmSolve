class KaKaoRecu {

    public static void main(String[] args){
        solution("(()())()");
    }
    public static String solution(String p) {
        String res = recu(p);

        return res;
    }

    public static String recu(String p){
        if(p.equals("")) return "";
        StringBuilder res = new StringBuilder();
        int l = p.charAt(0)=='('?1:0;
        int r = l==1?0:1;
        int i = 1;
        boolean isR = l == 1;
        for(i=1; i<p.length(); i++){
            if(p.charAt(i)=='(') l++;
            else if(p.charAt(i)==')')r++;

            if(l==r) break;
        }
        if(isR){
            res.append(p.substring(0, i + 1));
            res.append(recu(p.substring(i + 1)));
            return res.toString();
        }
        res.append('(');

        res.append(recu(p.substring(i + 1)));
        res.append(')');
        for(int j=1; j<i; j++){
            if(p.charAt(j)=='(') res.append(')');
            else res.append('(');
        }

        return res.toString();
    }
}
