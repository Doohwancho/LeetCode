package mayChallenge;

import java.util.ArrayList;
import java.util.List;

public class OnlineStockSpan {
	
	//<����Ǯ��1>
	
	class StockSpanner {

	    List<Integer> list;
	    
	    public StockSpanner() {
	        list = new ArrayList<>();    
	    }
	    
	    public int next(int price) {
	        list.add(price);
	        int consq = 0;
	        for(int i = list.size()-1; i >= 0; i--){
	            if(list.get(i) <= price){
	                consq++;
	            }
	            else {
	                break;
	            }
	        }
	        return consq;
	    }
	}
	
	//<����Ǯ��2 by lee215>
	
	//stack
	
	//[100, 80, 60, 70, 60, 75, 85]
	
	//[100]	100/1  
	//[80]  100/1  80/1  
	//[60]  100/1  80/1  60/1  
	//[70]  100/1  80/1  70/2  
	//[60]  100/1  80/1  70/2  60/1  
	//[75]  100/1  80/1  75/4  
	//[85]  100/1  85/6  
	
	//ũ..
	
	class StockSpanner{

	    Stack<int[]> stack = new Stack<>();
	    
	    public StockSpanner() {
	        
	    }
	    
	    public int next(int price) {
	        int res = 1;
	        while (!stack.isEmpty() && stack.peek()[0] <= price) //��¥�� i���� �������� res�� �̸� ���ؼ� �θ�, ���߿� i���� ū�� ��������, �׳� i�� res�� �����ָ� ���ݾ�.
	            res += stack.pop()[1];
	        stack.push(new int[]{price, res});
	        return res;
	    }
	}
}
}
