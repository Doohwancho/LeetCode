package array;

import java.util.ArrayList;
import java.util.List;

public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK1414 {

	//<Trial01>
	
	//dp�� Ǯ���׷��µ� �߾ȵǳ� ���̰�;
	
    private static int helper(List<Integer> l, int k){
    	if(l.size() == 0 || k <= 0) {
    		return Integer.MAX_VALUE;
    	}
        if(l.contains(k)){
            return 1;
        } 
        return 1 + Math.min(helper(l.subList(0, l.size()-1), k), helper(l, k-l.get(l.size()-1)));
    }
    
    public static int findMinFibonacciNumbers(int k) {
        List<Integer> l = new ArrayList<>();
        
        for(int i = 1, j = 0; i <= k; ){
            l.add(i);
            i = i+j;
            j = i-j;
        }
        
        return helper(l, k);
    }
    
    //<����Ǯ��1 by nihalanim9>
    
    //greedy
    
    //�� �Ǻ���ġ ���� k������ ������ ������, ���� ū������ ������ ������� �ȵ�.
    
    //fib[i]+fib[i+1] == fib[i+2]�ϱ�,
    
    //fib[i]+fib[i+1] �ΰ� �Դ°ͺ��� �Ȱ��� ���� fib[i+2] �ϳ� �Դ°�, ��ȣ����.
    
    //�������� "�ּ�" ����� ���� ����� �����ϱ�.
    
    //k�� 10(2+8)���� ���� ���ڰ� ������ �Ŷ��,
    
    //k�� �ּ� ��ĭ �̻� ����� �Ǻ���ġ ���ڵ��� ���̰���? i+(i+1)�� ������ �����´ٱ׷����ϱ�.
    
    //�ٵ� ���⼭ �����Ⱑ �� �� �Ѱ�, ������ �̷��� �������ݾ�?
    
    //whether a Fibonacci number could be used multiple times.
    
    //ū������ �ϳ��� ������� ����, �ߺ��Ǽ� ���� ���� ��¿����? ��� ���� �� ���ݾ�?
    
    //�ٵ� ���� �Ǻ���ġ���� �ߺ�([i]*2)��, [i-2]+[i+1]�� ġȯ�� �� �־�.
    
    //�������� �Ʒ��� ����.
    
    //we have:
  	//fibo[i-2] + fibo[i-1] = fibo[i]
  	//fibo[i-1] + fibo[i] = fibo[i+1] -> we get fibo[i] = fibo[i+1] - fibo[i-1]
  	
  	//thus:
  	//fibo[i] + fibo[i] = (fibo[i-2] + fibo[i-1]) + (fibo[i+1] - fibo[i-1]) = fibo[i-2] + fibo[i+1];
  	
  	//so:
  	//fibo[i] * 2 = fibo[i - 2] + fibo[i + 1]
    
	//���� �ߺ������� ���ص� �Ǵϱ�, 
    
    //greedy�� �� ū�ͺ��� �ϳ��� ��鼭 �����ָ� ��.
	
    public int findMinFibonacciNumbers(int k) {
        int rst = 0;
        List<Integer> l = new ArrayList<>();
        
        for(int i = 1, j = 0; i <= k; ){
            l.add(i);
            i = i+j;
            j = i-j;
        }
        
        for(int i = l.size() - 1; i >= 0; i--) {
            if(k == 0) return rst;
            if(l.get(i) <= k) {
                k -= l.get(i);
                rst++;
            } else continue;
        }
        return -1;
    }
    
}
