public class NickName1 {


    public String solution(String new_id) {
        StringBuffer sb = new StringBuffer();
        char lastChar = new_id.charAt(0);
        for(int i=0; i<new_id.length(); i++){
            if(sb.length()!=0) lastChar = sb.charAt(sb.length()-1);
            char check = new_id.charAt(i);

            if('A'<=check&&check<='Z') {
                check += 32;
            }
            if(check=='_'||check=='-'||(check>='0'&&check<='9')||(check>='A'&&check<='Z')||(check>='a'&&check<='z')){
                sb.append(check);
            }else if(check=='.'){
                if(i!=0&&lastChar!='.')sb.append(check);
            }
            if(sb.length()>=15)break;
        }
        if(sb.length()>=1&&sb.charAt(0)=='.')sb.deleteCharAt(0);
        if(sb.length()>=1&&sb.charAt(sb.length()-1)=='.')sb.deleteCharAt(sb.length()-1);
        if(sb.length()==0) sb.append("a");
        if(sb.length()<=2){
            char last = sb.charAt(sb.length()-1);
            while(sb.length()<3){
                sb.append(last);
            }
        }
        return sb.toString();
    }

}
