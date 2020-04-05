package thirtyDayChallenge;

public class BestTimeToBuyAndSellStockII {
	
	/*
	//<����Ǯ��1>
	
	//greedy
	
	//201 / 201 test cases passed.
	//Status: Accepted
	//Runtime: 1 ms
	//Memory Usage: 39.3 MB
	
    public int maxProfit(int[] prices) {
        int rst = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                rst += prices[i] - prices[i-1];
            }
        }
        return rst;
    }
    */
	
    //<����Ǯ��2 by shpolsky>
    
    //greedy�� �ƴ� ���
    
    //���� ���� ���� ���� ã�Ƴ���, �� ���� ���� �������� ã�Ƴ� ��, �� ���̸� ���ϴ� ���
    
    public int maxProfit(int[] prices) {
        int profit = 0, i = 0;
        while (i < prices.length) {
            // find next local minimum
            while (i < prices.length-1 && prices[i+1] <= prices[i]) i++;
            int min = prices[i++]; // need increment to avoid infinite loop for "[1]"
            // find next local maximum
            while (i < prices.length-1 && prices[i+1] >= prices[i]) i++;
            profit += i < prices.length ? prices[i++] - min : 0;
        }
        return profit;
    }
}
