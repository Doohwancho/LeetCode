package september;

public class BestTimeToBuyAndSell {
	
	//<����Ǯ��1>
	
	//greedy
	
	//min: i��°���� �ּڰ�
	
	//max: i��°�� �� - ���²� ���� �ּڰ� 
	
	//Runtime: 1 ms
	//Memory Usage: 39.3 MB
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int price : prices){
            min = Math.min(min, price);
            max = Math.max(max, price-min);
        }
        return max;
    }
}
