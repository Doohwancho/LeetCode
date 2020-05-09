package array;

public class MinimumValueToGetPositiveStepByStepSum1413 {

	//<����Ǯ��1>
	
	//���� �������� �������� �߰��� -�� �ѹ��̶� Ƣ�����, �� ������ �ּ� 1�� ū ���� �ʿ��ϰ���?
	
	//�׷��� Math.min()���� rst�� ���� ���� �������ڸ� ������
	
	//rst�� ���̳ʽ� ���̸�, ���밪 ����� +1�ؼ� ��ȯ�ϸ� �Ǳ�
	
	//���� �����, �������� �ּ� starvalue�޶�� �����ϱ�, 1�ָ� ��.
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Value to Get Positive Step by Step Sum.
	//Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Minimum Value to Get Positive Step by Step Sum.
    public int minStartValue(int[] nums) {
        int rst = nums[0];
        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i-1];
            rst = Math.min(rst, nums[i]);
        }
        return rst < 0 ? Math.abs(rst)+1 : 1;
    }
}
