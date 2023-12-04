public class Solution {
    class FailRate {
        int stage;
        double rate;

        public FailRate(int stage, double rate) {
            this.stage = stage;
            this.rate = rate;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] failedCount = new int[N + 2];
        FailRate[] failRates = new FailRate[N + 1];
        int userNum = stages.length;

        for (int i = 0; i < userNum; i++) {
            int stage = stages[i];
            failedCount[stage]++;
        }

        for (int i = 1; i <= N; i++) {
            int stage = i;
            double rate = (double) failedCount[i] / userNum;
            failRates[i] = new FailRate(stage, rate);
            userNum -= failedCount[i];
        }

        // 버블 정렬
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (failRates[j].rate < failRates[j + 1].rate) {
                    FailRate temp = failRates[j];
                    failRates[j] = failRates[j + 1];
                    failRates[j + 1] = temp;
                } else if (failRates[j].rate == failRates[j + 1].rate) {
                    if (failRates[j].stage > failRates[j + 1].stage) {
                        FailRate temp = failRates[j];
                        failRates[j] = failRates[j + 1];
                        failRates[j + 1] = temp;
                    }
                }
            }
        }
        // answer에 복사
        for (int i = 0; i < N; i++) {
            answer[i] = failRates[i + 1].stage;
        }
        return answer;
    }
}