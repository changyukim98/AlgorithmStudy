import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> edgeMap = new HashMap<>();
    private Map<Integer, int[]> edgeCountMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public int[] solution(int[][] edges) {
        // 추가된 정점 찾기
        for (int[] edge : edges) {
            if (!edgeCountMap.containsKey(edge[0]))
                edgeCountMap.put(edge[0], new int[2]);
            if (!edgeCountMap.containsKey(edge[1])) {
                edgeCountMap.put(edge[1], new int[2]);
            }
            edgeCountMap.get(edge[0])[0]++;
            edgeCountMap.get(edge[1])[1]++;
        }

        int created = -1;
        for (Map.Entry<Integer, int[]> entry : edgeCountMap.entrySet()) {
            int[] countArray = entry.getValue();
            if (countArray[0] >= 2 && countArray[1] == 0)
                created = entry.getKey();
        }

        // 간선을 맵으로 정리
        for (int[] edge : edges) {
            if (!edgeMap.containsKey(edge[0])) {
                edgeMap.put(edge[0], new ArrayList<>());
            }
            edgeMap.get(edge[0]).add(edge[1]);
        }

        int[] result = new int[]{created, 0, 0, 0};

        for (Integer node : edgeMap.get(created)) {
            visited.add(node);
            int type = graphClassification(node);
            result[type]++;
        }

        return result;
    }

    public int graphClassification(int node) {
        int[] countArray = edgeCountMap.get(node);
        if (countArray[0] >= 2) return 3;
        else if (countArray[0] == 0) return 2;

        List<Integer> edgeList = edgeMap.get(node);
        for (Integer next : edgeList) {
            if (visited.contains(next)) return 1;
            visited.add(next);
            return graphClassification(next);
        }
        return 2;
    }
}