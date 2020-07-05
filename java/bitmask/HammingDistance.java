package julyChallenge;

public class HammingDistance {

	
	//<����Ǯ��1>
	
	//�׻� ������ �ð��� �ɸ��ϱ� O(1)�ƴѰ�?
	
	//x�� y�� ���� ���� loop31�� ���ƾ� �ɰžƳ�?
	
	//Runtime: 0 ms
	//Memory Usage: 38.7 MB
	
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int rst = 0;
        
        for(int i = 0; i < 32; i++){
            if((n & (1<<i)) > 0){
                rst++;
            };
        }
        
        return rst;
    }
    
    //<����Ǯ��2 by shawngao>
    
    //bit�� � �����ִ��� Ȯ���ϴ� �Լ��� Integer.bitCount()�� �̿��� ���
    
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
    
    //<����Ǯ��3 by tankztc>
    
    //1010 0000 �� xor-1�ϸ�
    
    //1001 1111 �� �ǰ�,
    
    //�װ� xor &=�ϸ� 1000 0000�� �ǰ� cnt+1
    
    //1000 0000�� xor-1�ϸ�
    
    //0111 1111�� �ǰ�
    
    //�̰� cnt+1�� �� xor�� &=�ϸ�
    
    //0000 0000�� �ǳ�
    
    //�׷��ϱ� ���� �����ʿ� �ִ� bit�� -1�ϰ� &���̸� �������ϱ�
    
    //���� �����ʿ� �ִ� bit���� �ϳ��� ��� cnt+1�ϴ� ����̱���!
    
    //sexy�ϱ���
    
    //Runtime: 0 ms
    //Memory Usage: 38.2 MB
    
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        
        while (xor != 0) {
            xor &= (xor - 1);
            count++;
        }
        return count;
    }
}
