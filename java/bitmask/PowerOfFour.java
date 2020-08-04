package augustChallenge;

public class PowerOfFour {
	
	
	//<����Ǯ��1>
	
	//�� ���ɵ� ���� �� Ǯ�� �ߴµ� ���� 2% ������ ����
	
	//���� �ణ �� ������
	
	//Runtime: 1 ms
	//Memory Usage: 36.9 MB
	
    public boolean isPowerOfFour(int num) {
        if(num <= 0) return false;
        else if(num == 1) return true;
        
        for(int i = 0, cnt = 0; i < 32; i++){
            if((num & (1<<i)) > 0){
                if(i % 2 == 0 && i != 0){ 
                    cnt++;
                    if(cnt == 2) return false;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    
    //<����Ǯ��2>
    
    //cnt�� Integer.bitCount(num) == 1�� ��ü�� ���Ҵ�.
    
    //�� �׷��� ���� 2% �����ѵ�
    
    //Runtime: 1 ms
    //Memory Usage: 36.8 MB
    
    public boolean isPowerOfFour(int num) {
        if(num <= 0) return false;
        else if(num == 1) return true;
        
        for(int i = 0; i < 32; i++){
            if((num & (1<<i)) > 0){
                if(i % 2 == 0 && i != 0 && Integer.bitCount(num) == 1){ 
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    
    //<Trial01>
    
    //�� 2�� �������� 4�� �������� �����ϱ⸸ �ϸ� �Ǵµ� �̰� �𸣰ڳ�
    
    public boolean isPowerOfFour(int num) {
        if(num <= 0 || Integer.bitCount(num) != 1 || (Integer.lowestOneBit(num) % 4 != 0 && num != 1)) return false;
        return true;
    }
    
    
    //<����Ǯ��3 by aiscong>
    
    //�׷� �ٷ� �̰���
    
    //�̰� ���ϰ� ���ϰ� ������ ������
    
    //0x55555555 = 0x55 = 01010101
    
    //�̰ɷ� 4�� �������� ������. 
    
    //num & 01010101.... �ϸ� ������ 4�� �������� ���;� �ϱ� ����.
    
    //Runtime: 1 ms
    //Memory Usage: 37.1 MB
    
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
    
    
    //<����Ǯ��4 by JudyH15>
    
    //log
    
    //log(����)/log(����������) ������, 4�� ���������� 0,1,2,3,4, 1�� �����ϵ��� ����
    
    //�ٸ� ���ڵ��� �Ҽ����� ���� ������.
    
    //�̰� %1�ϸ� 4�� ���������� �Ҽ����� ���� ��� 0�̵ǰ�, ������ ���ڴ� �Ҽ����� ���� ���ڰ� ��.
    
    //�̰� ==0�ؼ� 0���� ���������� ���� ����.
    
    
    //Runtime: 1 ms
    //Memory Usage: 36.6 MB
    
    public boolean isPowerOfFour(int num) {
       return Math.log(num)/Math.log(4)%1 == 0;
    }
    
}
