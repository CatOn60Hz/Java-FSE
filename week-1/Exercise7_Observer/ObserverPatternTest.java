public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileUser = new MobileApp("Praveen");
        Observer webUser = new WebApp("Kumar");

        stockMarket.registerObserver(mobileUser);
        stockMarket.registerObserver(webUser);

        stockMarket.setStockPrice("TCS", 3850.50);
        stockMarket.setStockPrice("Infosys", 1725.75);

        stockMarket.removeObserver(webUser);
        System.out.println("\nWeb User Unsubscribed");

        stockMarket.setStockPrice("Wipro", 295.40);
    }
}
