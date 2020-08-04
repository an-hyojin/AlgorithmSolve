import java.util.ArrayList;
import java.util.Arrays;

public class TravelRoute {
    public static void main(String[] args){
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        solution(tickets);
        tickets = new String[][]{{"ICN", "JFK"}, {"HDN", "IAD"}, {"JFK", "HDN"}};
        solution(tickets);
    }
    static boolean[] isVisit;
    static Route[] ticketsList;
    public static String[] solution(String[][] tickets) {

        isVisit = new boolean[tickets.length+1];
        ticketsList = new Route[tickets.length];
        for(int i=0; i< tickets.length; i++){
            String[] ticket = tickets[i];
            ticketsList[i] = new Route(ticket[0], ticket[1]);
        }
        Arrays.sort(ticketsList);

        ArrayList<String> res = new ArrayList<>();
        res.add("ICN");
        for(int i=0;i<ticketsList.length; i++){
            Route ticket = ticketsList[i];
            if(ticket.start.equals("ICN")){
                isVisit[i] = true;
                res.add(ticket.end);
                boolean result = findRoute(ticket.end, res);
                isVisit[i] = false;
                if(result){
                    break;

                }
                res.remove(res.size()-1);
            }
        }
        String[] answer = new String[tickets.length+1];
        for(int i=0; i< res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }
    public static boolean findRoute(String next, ArrayList<String> arrayList){

        if(arrayList.size()==isVisit.length)return true;
        for(int i=0; i< ticketsList.length; i++){
            if((!isVisit[i])&&ticketsList[i].start.equals(next)){
                arrayList.add(ticketsList[i].end);
                isVisit[i] = true;
                if(findRoute(ticketsList[i].end, arrayList)){
                    return true;
                }
                arrayList.remove(arrayList.size()-1);
                isVisit[i] = false;
            }
        }
        return false;
    }
    static class Route implements Comparable<Route>{
        String start;
        String end;
        Route(String s, String e){
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Route o) {
            if(this.start.compareTo(o.start)==0){
                return this.end.compareTo(o.end);
            }else{
                return this.start.compareTo(o.start);
            }
        }
    }

}
