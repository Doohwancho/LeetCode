package array;

public class CountLargestGroup1399 {
	
	//<����Ǯ��1>
	
	//Runtime: 3 ms, faster than 98.82% of Java online submissions for Count Largest Group.
	//Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Count Largest Group.
	public int countLargestGroup(int n) {
        int[] container = new int[100];
        
        for(int i = 1; i <= n; i++){
        	int i_ = i;
            int num = 0;
            while(i_ > 0) {
            	num += i_%10; //������ ���� �ϳ��� ���� num�� ������. 192���� 2 ����
            	i_/=10; //19�� ����
            }
            container[num-1]++; // �� �����ָ� 1+9+2 �ϸ� 12��. 11�� �ε����� +1����
        }
        
        int maxSize = 0;
        int rst = 0;
        
        for(int element : container) { //element�� ���� num�� ���� ���ڵ��� �󵵼���. 
        	if(element == maxSize) {  //�� �󵵼��� max�϶� rst+1����
        		rst++;
        	}
        	else if(element > maxSize) { //�� ū �󵵼��� ������ rst=1�� ��������
        		maxSize = element;
        		rst = 1;
        	} 
        }
        return rst;
    }
}
