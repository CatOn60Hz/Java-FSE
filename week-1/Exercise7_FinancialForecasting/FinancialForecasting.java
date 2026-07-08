package Exercise7_FinancialForecasting;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    // Simple Recursive Approach
    public static double predictFutureValue(double initialValue, double growthRate, int years) {
        if (years <= 0) {
            return initialValue;
        }
        return predictFutureValue(initialValue, growthRate, years - 1) * (1 + growthRate);
    }
    
    // Optimized Approach using Memoization (though for this specific problem, iterative or direct formula is best)
    private static Map<Integer, Double> memo = new HashMap<>();

    public static double predictFutureValueMemoized(double initialValue, double growthRate, int years) {
        if (years <= 0) {
            return initialValue;
        }
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        double value = predictFutureValueMemoized(initialValue, growthRate, years - 1) * (1 + growthRate);
        memo.put(years, value);
        return value;
    }
}
