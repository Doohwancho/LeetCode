package mayChallenge;

public class SingleElementInASortedArray {
	
	
	//<����Ǯ��1>
	
	//bitmask���� xor�̿��ϴ� ���
	
	//https://doohwancho.tistory.com/867
	
	//�������� ���° ����Դ°ų� ��Ʈ�ڵ�� �����
	
	//Runtime: 0 ms
	//Memory Usage: 39.4 MB
    public int singleNonDuplicate(int[] nums) {
        int rst = 0;
        for(int n : nums) rst ^= n;
        return rst;
    }
}
