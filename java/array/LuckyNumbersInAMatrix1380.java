package array;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix1380 {
	
	//<����Ǯ��1>
	
	//Runtime: 1 ms, faster than 98.81% of Java online submissions for Lucky Numbers in a Matrix.
	//Memory Usage: 42 MB, less than 100.00% of Java online submissions for Lucky Numbers in a Matrix.
	public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> rst = new ArrayList<>();
        int[] container = new int[matrix[0].length]; //���� row���� ���� �������� �̾Ƽ� �� ���� column index�� ���� ���� ����
        
        for(int i = 0; i < matrix.length; i++){
            int minNum = Integer.MAX_VALUE;
            int j_ = 0;
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] < minNum){
                    minNum = matrix[i][j];
                    j_ = j;
                }
            }
            container[j_] = Math.max(container[j_], minNum); //int[]�� �ʱⰪ�� 0. ���� ������ �־������� �ִٸ�, ���� column�� �ΰ� ���� �ִٴ°ǵ�, �� �� �� �� �� ū���� �־���. ��¥�� �ؿ� for������ �� ū���� �������̱� ����.
        }
        
        for(int p = 0; p < matrix[0].length; p++){
            if(container[p] == 0) continue; //int[]�� �ʱⰪ�� 0�̰�, �������� matrix[m][n]�� 1���� 10^5������ ����� �����ϱ�, ���� 0�̶�°� �ϰ͵� �ȵ��ٴ� ���̱� ������ ���ʿ��� �н�.
            int maxNum = container[p];
            boolean flag = true;
            for(int q = 0; q < matrix.length; q++){
                if(matrix[q][p] > maxNum){
                    flag = false;
                    break;
                }
            }
            if(flag) rst.add(maxNum); //�ִ��� container���� ���� maxNum�̸� ���� �ְ�, �ش� column�� �ٸ� ���ڰ� �ִ��� ���ٸ�, flag�� false�ϱ� rst�� �ȳְ� �Ѿ.
        }
        return rst;
    }
}
