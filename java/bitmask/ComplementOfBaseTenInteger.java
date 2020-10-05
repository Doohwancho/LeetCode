package october;

public class ComplementOfBaseTenInteger {
	

	
	//<����Ǯ��1>
	 
	//��-��
	
	//Runtime: 1 ms
	//Memory Usage: 35.9 MB
	public int bitwiseComplement(int N) {
	    StringBuilder sb = new StringBuilder();
		for(char c : Integer.toBinaryString(N).toCharArray()) {
			if(c == '1') {
				sb.append('0');
			} else {
				sb.append('1');
			}
		}
	    return Integer.valueOf(sb.toString(), 2);
	}
    
	
	//<����Ǯ��2>
	
	//����ã��
    
	//1000 = 8
	//101 = 5
	//010 = 2
	
	//10000 = 16
	//01010 = 10
	//00101 = 5
    
    //�̰���
    
    //Runtime: 0 ms
    //Memory Usage: 35.6 MB
    
	public int bitwiseComplement(int N) {
	    return N == 0 ? 1 : Integer.highestOneBit(N)*2 - N - 1;
	}
	
	
	//<����Ǯ��3 by lee215>
	
	//111 = 7
	//101 = 5
	//010 = 2
	
	//1111 = 15
	//1010 = 10
	//0101 = 5
	
	//�굵 ����Ǯ��2 ó�� ����ã��. �겨�� ������ 0�� ���� ���ó�� �����൵ �ȴٴ� ��.
	
	//���� 111 - 101 = 111 ^ 101 = 010
	
	//Runtime: 0 ms
	//Memory Usage: 36 MB
	
    public int bitwiseComplement(int N) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return X ^ N; //return X - N �� pass
    }
    
    
}
