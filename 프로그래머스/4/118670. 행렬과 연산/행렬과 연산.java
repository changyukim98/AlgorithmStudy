import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();
        Deque<Deque<Integer>> middleQueues = new ArrayDeque<>();

        int width = rc[0].length;
        int height = rc.length;
        for (int i = 0; i < height; i++) {
            left.add(rc[i][0]);
            right.add(rc[i][width - 1]);

            Deque<Integer> middle = new ArrayDeque<>();
            for (int j = 1; j < width - 1; j++) {
                middle.add(rc[i][j]);
            }
            middleQueues.add(middle);
        }

        for (String operation : operations) {
            if (operation.equals("Rotate")) {
                // 왼쪽 Deque에서 위 Deque로
                Integer leftPop = left.removeFirst();
                middleQueues.getFirst().addFirst(leftPop);
                // 위 Deque에서 오른쪽 Deque로
                Integer topPop = middleQueues.getFirst().removeLast();
                right.addFirst(topPop);
                // 오른쪽 deque에서 아래 Deque로
                Integer rightPop = right.removeLast();
                middleQueues.getLast().addLast(rightPop);
                // 아래 Deque에서 왼쪽 Deque로
                Integer bottomPop = middleQueues.getLast().removeFirst();
                left.addLast(bottomPop);
            } else {
                left.addFirst(left.removeLast());
                right.addFirst(right.removeLast());
                middleQueues.addFirst(middleQueues.removeLast());
            }
        }

        int[][] result = new int[height][width];

        for (int i = 0; i < height; i++) {
            result[i][0] = left.removeFirst();
            result[i][width - 1] = right.removeFirst();
            for (int j = 1; j < width - 1; j++) {
                result[i][j] = middleQueues.getFirst().removeFirst();
            }
            middleQueues.removeFirst();
        }

        return result;
    }
}