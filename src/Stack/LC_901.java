package Stack;

public class LC_901 {

    //Online Stock Span

    /*Design an algorithm that collects daily price quotes for some stock and returns the span 
    of that stock's price for the current day. The span of the stock's price in one day is the 
    maximum number of consecutive days (starting from that day and going backward) for which the 
    stock price was less than or equal to the price of that day.
    For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the 
    stock today is 2, then the span of today is 4 because starting from today, the price of the stock 
    was less than or equal 2 for 4 consecutive days.
    Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock 
    today is 8, then the span of today is 3 because starting from today, the price of the stock was 
    less than or equal 8 for 3 consecutive days.
    Implement the StockSpanner class:
        -- StockSpanner() Initializes the object of the class.
        -- int next(int price) Returns the span of the stock's price given that today's price is price.*/
    
    public static void main(String[] args) {
        LC_901 obj = new LC_901();
        StockSpanner stockSpanner = obj.new StockSpanner();
        System.out.println(stockSpanner.next(100)); 
        System.out.println(stockSpanner.next(80));  
        System.out.println(stockSpanner.next(60));  
        System.out.println(stockSpanner.next(70));  
        System.out.println(stockSpanner.next(60));  
        System.out.println(stockSpanner.next(75)); 
        System.out.println(stockSpanner.next(85));  
    }

    class StockSpanner {
        private class Pair {
            int price;
            int span;

            Pair(int price, int span) {
                this.price = price;
                this.span = span;
            }
        }

        private java.util.Stack<Pair> stack;

        public StockSpanner() {
            stack = new java.util.Stack<>();
        }

        public int next(int price) {
            int span = 1;

            while (!stack.isEmpty() && stack.peek().price <= price) {
                span += stack.pop().span;
            }

            stack.push(new Pair(price, span));
            return span;
        }
    }

    
}
