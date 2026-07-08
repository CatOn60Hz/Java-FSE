package Exercise7_FinancialForecasting;

public class Main {
    public static void main(String[] args) {
        double initialValue = 1000.0;
        double growthRate = 0.05; // 5% growth
        int years = 10;

        double predictedValue = FinancialForecasting.predictFutureValue(initialValue, growthRate, years);
        System.out.printf("Predicted value after %d years (recursive): $%.2f%n", years, predictedValue);
        
        double predictedValueMemoized = FinancialForecasting.predictFutureValueMemoized(initialValue, growthRate, years);
        System.out.printf("Predicted value after %d years (memoized): $%.2f%n", years, predictedValueMemoized);
    }
}
