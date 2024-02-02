import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>();
        int[][] giftMatrix = new int[friends.length][friends.length];
        int[] giftScore = new int[friends.length];
        int[] receiveGift = new int[friends.length];

        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }

        // giftMatrix 작성
        for (String gift : gifts) {
            String[] giftArr = gift.split(" ");
            String from = giftArr[0];
            String to = giftArr[1];

            int fromIdx = map.get(from);
            int toIdx = map.get(to);

            giftMatrix[fromIdx][toIdx] += 1;
        }

        // 선물 지수 계산
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                giftScore[i] += giftMatrix[i][j];
            }
            for (int j = 0; j < friends.length; j++) {
                giftScore[i] -= giftMatrix[j][i];
            }
        }

        int max = 0;
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                if (giftMatrix[i][j] > giftMatrix[j][i]) {
                    receiveGift[i] += 1;
                } else if (giftMatrix[i][j] < giftMatrix[j][i]) {
                    receiveGift[j] += 1;
                } else {
                    if (giftScore[i] > giftScore[j]) {
                        receiveGift[i] += 1;
                    } else {
                        if (giftScore[i] < giftScore[j]) {
                            receiveGift[j] += 1;
                        }
                    }
                }
            }
            max = Math.max(max, receiveGift[i]);
        }

        return max;
    }
}