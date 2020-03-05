package array;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestFibonacciSubsequence873 {
	
	/*
	//<Trial01 - Time Limit Exceeded>
	
	//�� �� ���ֶ� �ΰ������δٰ�
	
	public int lenLongestFibSubseq(int[] A) {
        List<List<Integer>> container;
        int rst = 0;
        for(int i = 0; i < A.length; i++){
            container = new ArrayList<>(); //�� loop���� ù��° ���ڸ� �޸� ������
            List<Integer> tmp = new ArrayList<>();
            tmp.add(A[i]);
            container.add(tmp); //[[A[i]]] �� �������� �Ǻ���ġ ������ �ٿ� ���� ��
            
            for(int j = i+1; j < A.length; j++){
                int idx = container.size()-1; //container�� ����Ʈ Ȯ���ϴµ�, ������ �ִ��ֵ鸸 �����ؼ� idx��������. for������ �� ������ concurrent exception ��. loop���� container�� .add(list)�߱� ����
                while(idx >= 0){
                    List<Integer> temp = container.get(idx--);
                    if(temp.size() < 2){ //�Ǻ���ġ������ ��Ģ(A[i-1]+A[i] = A[i+1])�� ����° �ε��� ���� �����ϱ� ������, [[A[i]]�� �ϳ����̸�, �ΰ������� ä���ش�.
                        temp.add(A[j]);
                        if(container.get(container.size()-1).size() > 1){ //�� ���������� [[A[i]]]���, ���� ���ο� A[i]�� ������ �ʿ䰡 ����. �ð�/�޸� ����
                            List<Integer> tmp2 = new ArrayList<>();
                            tmp2.add(A[i]);
                            container.add(tmp2); 
                        }
                    }
                    else if(A[j]-temp.get(temp.size()-1) == temp.get(temp.size()-2)){ //�̰� �Ǻ���ġ ��� ������ ��. ���� ���� A[j]�� �ش� ����Ʈ�� ������ ���ڸ� ����, �� ����Ʈ ���������� ���ڿ� ������, �Ǻ���ġ����� �����ǹǷ�, A[j]�� �����ش�.
                        temp.add(A[j]);
                    }
                }
            }
            
            for(List<Integer> temp : container){
                rst = Math.max(rst, temp.size() > 2 ? temp.size() : 0); //���࿡ [1,7] ,[1,4]�̷��͸� ������, �̰� �Ǻ���ġ ������ �ƴ�. A[i-1]+A[i] = A[i+1] �̰����� �Ⱦ����ݾ�. �׷��� 0ó����.
            }
        }
        return rst;
    }
    */
	
	//<����Ǯ��1 by lee215>
	
	//�ȶ����
	
	//Runtime: 73 ms, faster than 59.16% of Java online submissions for Length of Longest Fibonacci Subsequence.
	//Memory Usage: 41.7 MB, less than 14.29% of Java online submissions for Length of Longest Fibonacci Subsequence.
	public int lenLongestFibSubseq(int[] A) {
        Set<Integer> s = new HashSet<Integer>();
        for (int x : A) s.add(x);
        int res = 2;
        for (int i = 0; i < A.length; ++i)
            for (int j = i + 1; j < A.length; ++j) {
                int a = A[i], b = A[j], l = 2;
                while (s.contains(a + b)) {
                    b = a + b;
                    a = b - a;
                    l++;
                }
                res = Math.max(res, l);
            }
        return res > 2 ? res : 0;
    }
}
