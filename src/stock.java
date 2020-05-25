public class stock {

    public int profitmax(int[] prices){
        int i =0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit =0;
        while (i < prices.length - 1) {
            while(i < prices.length - 1 &&  prices[i] >= prices[i + 1]){
                i++;
            }
            valley = prices[i];
            while(i < prices.length - 1 &&  prices[i] <= prices[i + 1]){
                i++;
            }
            peak = prices[i];
            maxprofit +=peak-valley;
        }
        return maxprofit;
    }

    /**
     * From the above graph, we can observe that the sum
     A
     +
     B
     +
     C
     A+B+C is equal to the difference
     D
     D corresponding to the difference between the heights of the consecutive peak and valley.
     * @param prices
     * @return
     */

    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
