package array;

public class CheckIfAllOnesAreAtLeastLengthKPlacesAway1437 {
	
	//<����Ǯ��1>
	
	//1�� ������������ ī��Ʈ ���ֱ����� d(distance)�� null�� �����,
	
	//1�� ������ 0���� �ʱ�ȭ.
	
	//�� �Ŀ� 0�� ���ö����� distance+1�� ���ִٰ�
	
	//else������ 1�� ������ ��, ���²� ������ distance�� k���� ���Ͽ�
	
	//�������� k���� �� ���� distance��� return false
	
	//loop�� ���Ƶ� �ƹ� �̻� ������ return true
	
	//Runtime: 1 ms, faster than 100.00% of Java online submissions for Check If All 1's Are at Least Length K Places Away.
	//Memory Usage: 49.2 MB, less than 100.00% of Java online submissions for Check If All 1's Are at Least Length K Places Away.
    public boolean kLengthApart(int[] nums, int k) {
        Integer d = null;
        for(int n : nums){
            if(d == null && n == 1){
                d = 0;
            } else if(d != null){
                if(n == 0){
                    d++;
                } else {
                    if(d < k) return false;
                    d = 0;
                }
            }
        }
        return true;
    }
}
