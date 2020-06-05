package bitmask;

public class HammingDistance461 {
	
	//<����Ǯ��1>
	
	//x�� y�� 2������ ���� bit�� �ڸ����� ��� �ٸ��� ����°žƳ�

	//x�� y�� ������ 0 �� x, y < 2^31 �ϱ�, bit�ڸ��� �� 32����,
	
	//������ �ȼ��ϱ� �� �տ� bit�� �� �ʿ� ������? �׷� 31���� for�� �����鼭
	
	//�ڸ��� üũ���ָ� �ǰڳ�.
	
	//�ڸ��� üũ�� 1 << i�� �ϰ�.
	
	//1 << i�� �� �����ʺ��� i�� ���� �Ŀ� 1�� ���شٴ� ���̿�.
	
	//�ű⿡ x & �� �ϸ�, i��° ������� x�� bit�� ���������� �ش��ڸ��� ���ڸ� ������
	
	//�������, 9�� bit�� 1001����?
	
	//9 & (1<<3) �ϸ� 1000�� ������, 1001 & 1000�ϸ� 1000�̴ϱ�, 8�� ��ȯ���ִ� ������.
	
	//�̷��� x�� y�� bit�ڸ� 31�� ���غ��� ��
	
	// Runtime: 0 ms, faster than 100.00% of Java online submissions for Hamming Distance.
	// Memory Usage: 36.1 MB, less than 78.77% of Java online submissions for Hamming Distance.
    public int hammingDistance(int x, int y) {
        int rst = 0;
        for(int i = 0; i < 32; i++){
            if ((x & (1 << i)) != (y & (1 << i))){
                rst++;
            }
        }
        return rst;
    }
    
    
    //<����Ǯ��2 by shawngao>
    
    //�Ӹ��� ��� ��ģ��
    
    //x�� y�� xor�ϸ�, ���� ���� bit�� �ִ°� ������, �ٸ� ��Ʈ�� �ִ°� �����žƳ�?
    
    //�׷� .bitCount() �����Լ��� �ٸ� bit�� ��ִ��� ���� ���ڳ�
    
//    public int hammingDistance(int x, int y) {
//        return Integer.bitCount(x ^ y);
//    }
	    
}
