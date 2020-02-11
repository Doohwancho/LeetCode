package array;

public class TheKWeakestRowsInMatrix1337 {
	
	//<����Ǯ��1>
	
	//���Ƶ�
	
	//Runtime: 1 ms, faster than 99.74% of Java online submissions for The K Weakest Rows in a Matrix.
	//Memory Usage: 41.7 MB, less than 100.00% of Java online submissions for The K Weakest Rows in a Matrix.
	public int[] kWeakestRows(int[][] mat, int k) {
        int[] rst = new int[k];
        int[] container = new int[mat.length]; //�̹� rst�� �� row�� index�� üũ�ϱ� ���� ����Ʈ
        int idx = 0;
        int originalK = k;
        
        //1(soldier)�� ������ 0���� �տ� ��ġ �ϴϱ�, for�� ���� �� row�� ���� ù��° ���� üũ, �� row�� �ι�° �� üũ, ����° �� üũ.. ������ ��.
        for(int i = 0; i < mat[0].length; i++){
            for(int j = 0; j < mat.length; j++){
                if(container[j] == 0 && mat[j][i] == 0){ //���� 0(civilian)�� ��Ÿ����, �̹� rst�� ������ �ʾҴٸ�, 
                    rst[idx++] = j; //rst�� ���� �ְ�
                    container[j]++; //rst�� ���� row�� �ε����� üũ����
                    k--;
                }
                if(k == 0){     //���� k�� ��� ���������� rst�� �ٷ� ��ȯ����.
                    return rst;
                }
            }
        }
        
        if(k == originalK){ //mat�� 2�� for������ �� ���Ҵµ���, 0(civilian)�� �Ѹ� ������ ������ k���� ��ȭ�� �����ٸ�, �� ����Ʈ�� k�������� [0]�� ��ȯ.
            return rst; 
        }

        for(int q = 0; q < container.length && k > 0; q++){ //���� k�� ���� 4�̰�, 3���� row�� 0(civilian)�� �־ 1�� ���� ��Ȳ�̸�, ��� 1(soldier)�ۿ� ������ �ش� row�� ���� ������
            if(container[q] == 0){
                rst[idx++] = q;
                k--;
            }
        }
        
        return rst;
    }
}
