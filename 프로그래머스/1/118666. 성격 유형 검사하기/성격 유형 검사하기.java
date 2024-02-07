class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] scores = new int[4];
        for (int i = 0; i < survey.length; i++) {
            if (survey[i].equals("RT")) {
                scores[0] += 4 - choices[i];
            } else if (survey[i].equals("TR")) {
                scores[0] -= 4 - choices[i];
            }

            else if (survey[i].equals("CF")) {
                scores[1] += 4 - choices[i];
            } else if (survey[i].equals("FC")) {
                scores[1] -= 4 - choices[i];
            }

            else if (survey[i].equals("JM")) {
                scores[2] += 4 - choices[i];
            } else if (survey[i].equals("MJ")) {
                scores[2] -= 4 - choices[i];
            }

            else if (survey[i].equals("AN")) {
                scores[3] += 4 - choices[i];
            } else if (survey[i].equals("NA")) {
                scores[3] -= 4 - choices[i];
            }
        }

        String result = "";
        result += scores[0] >= 0 ? 'R' : 'T';
        result += scores[1] >= 0 ? 'C' : 'F';
        result += scores[2] >= 0 ? 'J' : 'M';
        result += scores[3] >= 0 ? 'A' : 'N';

        return result;
    }
}