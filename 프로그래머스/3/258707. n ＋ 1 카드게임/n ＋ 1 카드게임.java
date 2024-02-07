import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int coin, int[] cards) {
        int goalNum = cards.length + 1;

        // 카드의 1/3을 hands에 채움
        Set<Integer> hands = new HashSet<>();
        for (int i = 0; i < cards.length / 3; i++) {
            hands.add(cards[i]);
        }

        int round = 1;
        int idx = cards.length / 3;
        Set<Integer> keeps = new HashSet<>();

        while (idx < cards.length) {
            keeps.add(cards[idx]);
            keeps.add(cards[idx + 1]);

            boolean success = false;

            for (Integer handCard : hands) {
                if (hands.contains(goalNum - handCard)) {
                    success = true;
                    hands.remove(handCard);
                    hands.remove(goalNum - handCard);
                    break;
                }
            }
            if (!success) {
                if (coin < 1) break;
                for (Integer handCard : hands) {
                    if (keeps.contains(goalNum - handCard)) {
                        success = true;
                        hands.remove(handCard);
                        keeps.remove(goalNum - handCard);
                        coin -= 1;
                        break;
                    }
                }
            }

            if (!success) {
                if (coin < 2) break;
                for (Integer keepCard : keeps) {
                    if (keeps.contains(goalNum - keepCard)) {
                        success = true;
                        keeps.remove(keepCard);
                        keeps.remove(goalNum - keepCard);
                        coin -= 2;
                        break;
                    }
                }
            }
            if (!success) break;

            idx += 2;
            round++;
        }

        return round;
    }
}