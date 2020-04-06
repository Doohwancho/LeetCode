package array;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Triangle120 {
	
	//<Trial01>
	
	//level order tree�� ����
	
	//root to leaf�� Math.min()�ϸ� ���� ������ �����ߴµ�
	
	//��ư� �� ��ȿ��������...
    
    
    //<����Ǯ�� 1 by jeantimex>
	
	//�� �ؿ��� ���� �������� �ּҼ��� �̴� ��
	
	//int[]�� ����ؼ��׷��� ������
    
    //Runtime: 2 ms, faster than 70.91% of Java online submissions for Triangle.
    //Memory Usage: 40.4 MB, less than 8.16% of Java online submissions for Triangle.
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] arr = new int[len];
        
        for(int i = 0; i < len; i++){
            arr[i] = triangle.get(len-1).get(i);
        }
        
        for(int i = len-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                arr[j] = Math.min(arr[j], arr[j+1]) + triangle.get(i).get(j);
            }
        }
        return arr[0];
    }
    
}
