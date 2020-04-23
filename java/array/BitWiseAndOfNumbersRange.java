package thirtyDayChallenge;

import java.util.ArrayList;
import java.util.List;

public class BitWiseAndOfNumbersRange {
	
	/*
	//<Trial01 - Time limit exceeded>
	
	//�ƴ� �̰� �ʹ��Ѱ� �ƴϳİ�~
	
	//�������� �����ڳ�~ �н�����~

    public static int rangeBitwiseAnd(int m, int n) {
        char[] mChar = Integer.toBinaryString(m).toCharArray();
		List<Integer> list = new ArrayList<>();
		
		for(int idx = mChar.length-1, i = 0;idx >= 0;idx--, i++) {
			if('1' == mChar[idx]) {
				list.add(i);            //���������κ��� ���°�� 1�� �ִ��� üũ
			}
		}
		int i = m+1;
		while(list.size()>0 && i <= n) {
            for(int j = list.size()-1; j >=0; j--) {
            	if((i & (1<< list.get(j))) == 0) { //m+1~n�� ���� ��, �ش� �ڸ��� 1�� ���ٸ�, and�����ڷ� �������ϱ� �ش� �ڸ��� ����.
            		list.remove(j);
            	}
            }
			i++;
		}
		
		int rst = 0;
		for(int digit : list) {
			rst = rst | (1 << digit); //���� �ڸ����� 1�� �־� ���ڸ� ����
		}
		return rst;
    }
	*/
    
	
	//<����Ǯ��1 by dietpepsi>
	
	//�ȶ����
	
	//m�̶� n�� �̷��ٰ� ����.
	
	//m = 0abc 0010
	
	//n = 0abc 1000
	
	//m�� 0010�κ��� 1�� �ö󰡸鼭 bitmask�� �ٲ�� �ᱹ�� n�̶� ���� ������ ���ö����� �� �����Ŵ�.
	
	//0abc 0000����
	
	//8266 / 8266 test cases passed.
	//Status: Accepted
	//Runtime: 4 ms
	//Memory Usage: 38.8 MB
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        for (; m != n; ++i) {
            m >>= 1;
            n >>= 1;
        }
        return n << i;
    }
}
