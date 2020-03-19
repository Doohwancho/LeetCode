package array;

public class NumberOfSubarraysWithBoundedMaximum795 {
	
	/*
	//<Trial01>
	
	//brute-force
	
	//��� combination ����� ���� ���� ����, �ش� ����Ʈ�� �� ���� L <= total < R���� ���ϴ� ���.
	
	//�� �ٵ� contiguous subarray���� �ϳ�. 
	
	//�������� ��ģ����
	
	public int numSubarrayBoundedMax(int[] A, int L, int R) {
        Arrays.sort(A);
        int rst = 0;
        
        List<List<Integer>> container = new ArrayList<>();
        container.add(new ArrayList<>());
        container.add(new ArrayList<>());
        container.get(1).add(A[0]);
        
        int nprev = 1;
        for(int i = 1; i < A.length; i++){
            int size = container.size();
            if(A[i] != A[i-1]){
                nprev = size;
            }
            for(int j = size-nprev; j < size; j++){
                List<Integer> cp = new ArrayList<>(container.get(j));
                cp.add(A[i]);
                container.add(cp);
            }
        }
        
        for(List<Integer> temp : container){
            int total = 0;
            for(int element : temp){
                total += element;
            }
            if(total >= L && total <= R){
                rst++;
            }
        }
        return rst;
    }
    */
	
	/*
	//<Trial02>
	
	//������ ��� �߸� �����ϳ� ��ģ����
	
	//Maximum element�� L>= <=R�̱⸸ �ϸ� ��. ���� �� ���� �ʿ䰡 ���� ��ģ����.
	
	//���ŸӸ��� ì��� �ٴ��� ģ����
	
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int rst = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] >= L && A[i] <= R){
                rst++;
            }
            int total = A[i];
            while(total <= R){
                for(int j = i+1; j < A.length; j++){
                    total += A[j];
                    if(total >= L && total <= R){
                        rst++;
                    }
                }
                break;
            }
        }
        return rst;
    }
	
	*/
	
	/*
	//<����Ǯ��1>
	
	//Runtime: 8 ms, faster than 10.53% of Java online submissions for Number of Subarrays with Bounded Maximum.
	//Memory Usage: 45.5 MB, less than 100.00% of Java online submissions for Number of Subarrays with Bounded Maximum.
	
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int rst = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] > R){ //�ش� ���ڰ� �̹� R�� �����, �� �� ���ڿ� ������� �н� L<= max_number <=R �� �̹� �ȸ±� ����
                continue;
            }
            else if(A[i] >= L){ //���� A[i]�� L<= A[i] <=R ���ǿ� �����Ѵٸ�, 
                rst++; //�ش� ���� �ϳ� �����ְ�
                for(int j = i+1, maxNum = A[i]; j < A.length; j++){ //�� ���� ������ ���� ���鼭 R�� ����� �ʴ� ���������� rst++���ش�.
                    maxNum = Math.max(maxNum, A[j]);
                    if(maxNum > R){
                        break;
                    } else {
                        rst++;
                    }
                }
            } else { //���� A[i]�� L���� ������, �� ������ ���ڰ� R���� ũ�� �����鼭 L<= max_number<=R�� �����ϴ��� ã�´�.
                boolean flag = false;
                for(int j = i+1; j < A.length; j++){ 
                    if(A[j] > R){ //R�� ����� ���ʿ���� ��ŵ
                        break;
                    } else if(A[j] >= L && A[j] <= R){ //���� L<= max_number<=R ���ǿ� �����ϴ� ���ڰ� ������, rst+1�� ���� ��,
                        rst++;
                        flag = true;
                    } else if(flag){ //������ ���ڰ� R�� ������� �ʴ´ٸ� ��� +1�� ���ش�.
                        rst++;
                    }
                }
            }
        }
        
        return rst;
    }
    */
	
    
    //<����Ǯ��2 by shawngao>
    
    //����Ǯ��1�� ���� �����ε� �� ������ ���� ��.
    
    //else if�� else�� ���ĳ�����
    
	//Runtime: 5 ms, faster than 21.05% of Java online submissions for Number of Subarrays with Bounded Maximum.
	//Memory Usage: 45.4 MB, less than 100.00% of Java online submissions for Number of Subarrays with Bounded Maximum.
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int rst = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] > R) continue;
            int maximum = Integer.MIN_VALUE;
            for(int j = i; j < A.length; j++){
                if(A[j] > R) break;
                maximum = Math.max(maximum, A[j]);
                if(maximum >= L) rst++; 
            }
        }
        return rst;
    }
}
