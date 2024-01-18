import java.util.*;

class Solution {
    class TicketInfo {
        private List<String> dest;
        private List<Boolean> used;
    }

    private final Map<String, TicketInfo> ticketMap = new HashMap<>();
    private final Stack<String> result = new Stack<>();
    private int ticketsCount;

    public String[] solution(String[][] tickets) {
        ticketsCount = tickets.length;

        Arrays.sort(tickets, Comparator.comparing(a -> a[1]));

        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];

            if (!ticketMap.containsKey(from)) {
                TicketInfo ticketInfo = new TicketInfo();
                ticketInfo.dest = new ArrayList<>();
                ticketInfo.used = new ArrayList<>();
                ticketMap.put(from, ticketInfo);
            }

            TicketInfo ticketInfo = ticketMap.get(from);
            ticketInfo.dest.add(to);
            ticketInfo.used.add(false);
        }

        result.add("ICN");
        DFS("ICN", 0);

        return result.toArray(String[]::new);
    }

    public boolean DFS(String now, int cnt) {
        if (cnt == ticketsCount) return true;

        TicketInfo ticketInfo = ticketMap.get(now);
        if (ticketInfo == null) return false;

        List<String> dest = ticketInfo.dest;
        List<Boolean> used = ticketInfo.used;
        for (int i = 0; i < dest.size(); i++) {
            if (!used.get(i)) {
                String next = dest.get(i);
                used.set(i, true);
                result.add(next);
                if (DFS(next, cnt + 1)) return true;
                result.pop();
                used.set(i, false);
            }
        }
        return false;
    }
}