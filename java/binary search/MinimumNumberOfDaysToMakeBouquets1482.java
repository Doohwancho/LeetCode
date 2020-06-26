package array;

import java.util.Arrays;

public class MinimumNumberOfDaysToMakeBouquets1482 {
	
	//<Trial01 - time limit exceeded>
	
	//���̰�
	
	public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m*k) return -1; //���ʿ� ���ǿ� �ȸ��ڳ�~
        
        int[] copy = bloomDay.clone();
		Arrays.sort(copy); 
        
        int idx = m * k - 1; //���� ������ ���� m*k-1��°�� ū �� ���������� ���ʿ� �� �ʿ䰡 ���ڳ�~ 
        int i = copy[idx];
        
        while(i <= copy[copy.length-1]){
            int bouquet = 0;
            
            for(int j = 0, consq = 0; j < bloomDay.length; j++){ 
                if(bloomDay[j] <= i){
                    consq++;
                } else {
                    consq = 0;
                }
                if(consq == k){
                    consq = 0;
                    bouquet++;
                }
            }
            
            if(bouquet >= m) return i;
        
            i = copy[idx++];
        }
        
        return -1;
    }
	
	
	//<����Ǯ��1 by lee215>
	
	//�������� ������ �ȵ� int[]�� binary search��
	
	//value�������� ã�� �� �ִ�.
	
	//÷�� (1+1000000000)/2 ���� �������� �ϴϱ�, �ظ�ŭ bloomDay[i]�� ũ�� ������ bouq�� �ִ�ġ����?
	
	//�׷� right = mid;�� �ؼ� �ݾ� �Ҷ� �߶� ������ �������°���
	
	//�׷��ٰ� ���� bouq < m�� ���� right bound�� �״�� �ΰ� left bound�� �������°���
	
	//right bound�� bouq == m�� �ƴϴ���, left bound�� �ִ��� bouq < m�� �ƴ� �� ���� ���ܿ��ϱ�,
	
	//�� �������� left�� �̾��� �� �ּ�ġ�� ����.
	
	//Runtime: 36 ms, faster than 34.89% of Java online submissions for Minimum Number of Days to Make m Bouquets.
	//Memory Usage: 88.8 MB, less than 33.33% of Java online submissions for Minimum Number of Days to Make m Bouquets.
	
    public int minDays(int[] A, int m, int k) {
        int n = A.length, left = 1, right = (int)1e9; //1000000000 (10�� 9��. (int)����ȯ ���ϸ� 1.09E9��� ��)
        if (m * k > n) return -1;
        while (left < right) {
            int mid = (left + right) / 2, flow = 0, bouq = 0;
            for (int j = 0; j < n; ++j) {
                if (A[j] > mid) {
                    flow = 0;
                } else if (++flow >= k) {
                    bouq++;
                    flow = 0;
                }
            }
            if (bouq < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
	
}
