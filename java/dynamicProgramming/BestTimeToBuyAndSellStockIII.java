package augustChallenge;

public class BestTimeToBuyAndSellStockIII {

	//<Trial01>
	
	//��� ����
	
	//�ƴ� �ٽ� ���� transaction�� +�� ������ ���� ����� ����, ���� transaction�� -�ε� ���²� �������� ���� ���̶� ���������� -�� ������ �����ؾ� �ؼ�
	
	//�̱��� ���� ���µ�,
	
	//���� i��° transaction�� -�ε�, ���²� �������� �����Ŷ� �������� +��,
	
	//ex)[1,5,2, ...]
	
	//2���� �����ϴ� ���� ū�׸� �׸��鼭 2�� �Ȱ��� ��� 2���� else if�� �־��µ�
	
	//��𼱰� ����.
	
	//�ٽ� �����غ��ϱ� �ִ� 2���� ��� �ȾҴ� �� �� �ִµ� �װ� ������ �Ƚ��׳� �����?
	
    private int dfs(int[] prices, int idx, int first, int second, int curr, int prev){
        
        for(int i = idx, tmp = 0; i < prices.length; i++){
            tmp = prices[i];
            prices[i] -= prev;
            
            if(prices[i] >= 0){
                curr += prices[i];
            } else if(prices[i] + curr > 0){
                if(curr >= second){
                    if(curr >= first){
                        second = first;
                        first = curr;
                    } else if(curr > second){
                        second = curr;
                    }
                    curr = 0;
                }
                return Math.max(dfs(prices, i+1, first, second, prices[i]+curr, prev), dfs(prices, i+1, first, second, curr, prev));
            } else {
                if(curr >= first){
                    second = first;
                    first = curr;
                } else if(curr > second){
                    second = curr;
                }
                curr = 0;
            }
            prev = tmp;
            
        }
        if(curr != 0){
            if(curr >= first){
                second = first;
                first = curr;
            } else if(curr > second){
                second = curr;
            }
            curr = 0;
        }
        
        return first+second;
    }
    
    public int maxProfit(int[] prices) {
        return dfs(prices, 1, 0, 0, 0, prices[0]);
    }
    
    
    //<����Ǯ��1 by jeantimex>
    
    //�;� ū�׸� ���� ������
    
    //���ʺ��� �����ʱ��� �ִ� profit����
    
    //�����ʺ��� ���ʱ��� �ִ� profit����
    
    //for������ �� �ε��� ���鼭 �ش� ������ left�ִ� profit + right �ִ� profit�� �ִ� ����
    
    //left���� transaction �ѹ�, right���� transaction�ѹ� �ߴٰ� ����.
    
    //Runtime: 3 ms
    //Memory Usage: 39.6 MB
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int min = prices[0];
        int max = prices[n-1];
        int rst = 0;
        
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i-1], prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        min = prices[n-1];
        for(int j = n-2; j >= 0; j--){
            right[j] = Math.max(right[j+1], max-prices[j]);
            max = Math.max(max, prices[j]);
            
            rst = Math.max(rst, left[j]+right[j]);
        }
        return rst;
    }
    
    //<����Ǯ��2 by yogi_bear>
    
    //dfs
    
    //optimize�Ϸ��� dp�ᵵ �Ǵµ�, �Ƚᵵ ����
    
    //Runtime: 4 ms
    //Memory Usage: 44.1 MB
    
//    Integer[][] dp;
    int[] prices;
    int k = 2;
    public int maxProfit(int[] prices) {
//        dp = new Integer[prices.length][k];
        this.prices = prices;
        return compute(0, k-1);        
    }
    private int compute(int st, int k) {
        if (k < 0) return 0;
        if (st >= prices.length) return 0;
//        if (dp[st][k] != null) return dp[st][k];
        
        int i = st + 1;
        int maxProfit = 0;
        int profit = 0;
        for (; i < prices.length; i++) {
            profit += prices[i] - prices[i-1];
            if (profit <= 0) break;
            maxProfit = Math.max(maxProfit, profit + compute(i + 1, k - 1)); //i��°�� -�ε�, ���� profit�̶� �������� ���� +�� ���, Math.max(i��°�� �Ĵ� ����, i��°�� �����ϴ� ����)
        }
        maxProfit = Math.max(maxProfit, compute(i, k));//���� profit�� ���۳� ���, ������ maxProfit�̶� ���²��� ������ ������ ���� array�� �ִ� profit���ؼ� maxProfit����
//        dp[st][k] = maxProfit;
        return maxProfit;
    }
}
