package julyChallenge;

public class BestTimeToBuyAndSellStockWithCooldown {
	
	//<Trial01>
	
	//� ���� �� �Դµ�
	
    int rst = 0;
    
    private void dfs(int[] prices, int i, int acc, boolean sold, boolean buy){
        if(i == prices.length){
            rst = Math.max(rst, acc);
            return;
        }
        if(sold){
            dfs(prices, i+1, acc, false, false); //cooldown
        } else {
            dfs(prices, i+1, acc + (buy ? prices[i]-prices[i-1] : 0), true, true); //sell
            dfs(prices, i+1, acc + (buy ? prices[i]-prices[i-1] : 0), false, true); //buy
            dfs(prices, i+1, acc, false, true); //pass
        }
    };
    
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        dfs(prices, 1, 0, false, true);
        return rst;
    }
    
    //<Trial02 by naveen_kothamasu >
    
    //���� �ٿ°� �ƴϾ���?
    
    //����� ���� �볻 ���ҳ�?
    
    //�׸��� �̹������ �ص� time limit exceeded �߳�?
    
    //0 - rest, 1 - buy, 2 - sell
    int max = 0;
    public int maxProfit(int[] p) {
        helper(p, 0, 0, false, -1);
        return max;
    }
    private void helper(int[] p, int i, int profit, boolean isSellOK, int prev){
        if(i == p.length) {
            max = Math.max(max, profit);
            return;
        }
        //first only
        if(prev == -1){
            //rest
            helper(p, i+1, profit, isSellOK, 0);
            //buy
            helper(p, i+1, profit-p[i], true, 1);
        //if sell
        }if(prev == 2){
            //rest
            helper(p, i+1, profit, isSellOK, 0);
        //if buy
        }else if(prev == 1){
            //sell
            helper(p, i+1, profit+p[i], false, 2);
            //rest
            helper(p, i+1, profit, isSellOK, 0);
        //if do-nothing
        }else{
        	//rest
            helper(p, i+1, profit, isSellOK, 0);
            //buy
            helper(p, i+1, profit-p[i], true, 1);
            if(isSellOK)
                //sell
                helper(p, i+1, profit+p[i], false, 2);
        }
    }
    
    
    //<����Ǯ��1 by yavinci>
    
    //�̰� ū Ʋ�� �˰ڴµ� �������� �𸣰ڳ�
    
    //buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);   
    //sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
    
    //b0 = Math.max(b1, s2 - prices[i]);
    //s0 = Math.max(s1, b1 + prices[i]);
    
    //Runtime: 1 ms
    //Memory Usage: 39.3 MB
    
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
      
        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;
     
        for(int i = 1; i < prices.length; i++) {
        	b0 = Math.max(b1, s2 - prices[i]); //i��° ��� ����. ���� ���� ����(b1) vs i-2���� �Ȱ� i-1���� cooldown�ϰ� i���� ��� ����(s2-prices[i]) 
        	s0 = Math.max(s1, b1 + prices[i]); //i��° �Ĵ� ����. ���� ���¼���(s1) vs i-1�� i������ ����
        	b1 = b0; s2 = s1; s1 = s0; 
        }
        return s0;
    }
}
