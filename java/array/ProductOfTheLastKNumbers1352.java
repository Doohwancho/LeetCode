package array;

import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers1352 {
	
	/*
	//<Trial01 - time limit exceeded>
	
	//brute-force
	
	class ProductOfNumbers {
	
	    List<Integer> list;
	    
	    public ProductOfNumbers() {
	        list = new ArrayList<>();
	    }
	    
	    public void add(int num) {
	        list.add(num);
	    }
	    
	    public int getProduct(int k) {
	        int rst = 1;
	        for(int i = list.size()-1; i >= (list.size()-k); i--){
	            rst *= list.get(i);
	        }
	        return rst;
	    }
	}
    */
	
	
	//<����Ǯ��1>
	
	//trial01�� �ϴϱ� testcase�� ��ģ��ó�� ���̵��� time limit�� �ߴ����. 
	
	//getProduct()�Լ��� �ð��� ���� ��Ƹ��ݾ�.
	
	//�׷��� ��� �ļ��� �θ��� ����ϴٰ�
	
	//input�� ������� 1,2,3,4��, �������� int[]�� �̸� ��Ƴ��°ž�.
	
	//1,2,6,24
	
	//�׸��� �ڿ������� k����ŭ�� ���� ���϶�� �ϸ�, k�� 2��� ����.
	
	//�׷� 24/2 == a[i]/a[i-k] == 12 == 3*4 �ݾ�
	
	//���� ���밡 �Ǵ� ������ �̰Ű�
	
	//�ٵ� ���࿡ �߰��� 0�� �Žθ� ������ ���� ���ݾ�.
	
	//1,2,3,4,0,5,6�̸�,
	
	//1,2,6,24,0,0,0 �̵ɰžƳ�. 0�� �����ص� 0�̴ϱ�, �������ϸ� Ŭ����.
	
	//�׷��� 0�� ���� �ڸ�����, ���Ŀ� �����ؼ� �ٽ� �����ִ°ž�.
	
	//1,2,6,24,0,5,30 �̷���.
	
	//�̶�, getProduct()�ߴµ� k�� 4��� �ĺ�?
	
	//�ٵ� ���������� 0�̳��� index�� 4�ݾ�.
	
	//list.size()-k �ȿ� �ִ� ���ڸ� �� ���ؼ� �����ؾ� �ϴµ�, �� ���̿� 0�� ���ִٴ°žƴϾ�.
	
	//�׷��� if(lastZero > (i-1-k) ) return 0;
    
	//0�� ���� �ȿ� �ɸ��� �� 0�������ִ°���.
	
	//add�Ҷ����� 0�� �����ָ� ������ 0�� �ε����� ������Ʈ ���ָ鼭.
	
	//int[]����� 40000���� �� ������, �������� iterate�� �ִ� 4�����Ѵ� �׷��� �׷���.
	
	//Runtime: 16 ms, faster than 39.00% of Java online submissions for Product of the Last K Numbers.
	//Memory Usage: 61 MB, less than 100.00% of Java online submissions for Product of the Last K Numbers.
	
	class ProductOfNumbers {
	    
	    int[] a;
	    int i = 0;
	    int lastZero = -1;
	    
	    public ProductOfNumbers() {
	        a = new int[40000];
	    }
	    
	    public void add(int num) {
	        if(num == 0){
	            lastZero = i;
	        } else {
	            if(i == 0 || a[i-1] == 0){
	                a[i] = num;
	            } else {
	                a[i] = a[i-1] * num;
	            }
	        }
	        i++;
	    }
	    
	    public int getProduct(int k) {
	        int cnt = 0;
	        if(lastZero > (i-1-k) ){
	            return 0;
	        } else {
	            if(i-k == 0 || a[i-1-k] == 0){
	                return a[i-1];
	            } else {
	                return a[i-1]/a[i-1-k];
	            }
	            
	        }
	    }
	}

	
	//<����Ǯ��2 by lee215>
	
	//�̰� �ξ� �� �����ϰ� �������̴� ��.
	
	//0�̳����� ����Ʈ�� �ƿ� �����ع�����.
	
	//Runtime: 14 ms, faster than 97.60% of Java online submissions for Product of the Last K Numbers.
	//Memory Usage: 63.8 MB, less than 100.00% of Java online submissions for Product of the Last K Numbers.
	
	class ProductOfNumbers {
	    
	    ArrayList<Integer> A;
	    public ProductOfNumbers() {
	        add(0);
	    }

	    public void add(int a) {
	        if (a > 0)
	            A.add(A.get(A.size() - 1) * a);
	        else {
	            A = new ArrayList();
	            A.add(1);
	        }
	    }

	    public int getProduct(int k) {
	        int n = A.size();
	        return k < n ? A.get(n - 1) / A.get(n - k - 1)  : 0;
	    }
	}
}
