package matchdaygridanalyzer.assigment_problems;

public class MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);
            String classification = average >= threshold ? "Power Surge" : "Normal";

            result.append("Match ").append(i).append(": ").append(classification);
            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };

        System.out.println(classifyMatches(runsPerOver, 8));
    }
}
