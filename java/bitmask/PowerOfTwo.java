package juneChallenge;

public class PowerOfTwo {
	
	//<����Ǯ��1>
	
	//n�� 2�� ���������� �ľ��϶�� �ǵ�
	
	//�ϴ� n�� ���̳ʽ���, 2�� ���� ��ü�� �� ���� ������?
	
	//if(n < 0) return false; �׷��� �̰ɷ� ����ó�� ���ְ�
	
	//2�� ������(1,2,4,8,16,32,64,...)�� Ư¡��
	
	//2������ ��ȯ�ϸ� bit�� �� �Ѱ� �����ٶ�°� �̿��ؼ�
	
	//bit�� ���� 1���̸� true�� ��ȯ�ϸ� ����.
	
	//���ð͵� ���������ϱ���
	
	//Runtime: 2 ms
	//Memory Usage: 37 MB
	
    public boolean isPowerOfTwo(int n) {
        if(n < 0) return false;
        return Integer.bitCount(n) == 1;
    }
}
