package september;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
	
	//<����Ǯ��1>
	
	//1) low�� ���ڸ� ������ ã��. �ش� �ڸ����� �ּҼ����ϱ�(if digit = 10000, first = 1234, ones = 1111)
	
	//2) ���� low�� 8511�̶�, first�� 9õ���� ������ ���, 6789���� �� ũ�Ƿ�, �ڸ����� ���ڸ� ���� ����
	
	//3) first�� ones�� ���ذ��� rst�� ���� ������.
	
	//������ ������ �������ϳ�;;
	
	//Runtime: 0 ms
	//Memory Usage: 36.6 MB
	
    private int max(int digit){
        int rst = 9;
        int a = 8;
        int b = 10;
        while(rst < digit/10){
            rst = a*b + rst;
            a--;
            b *= 10;
        }
        return rst;
    }
    
    private int fillSeq(int digit){
        int rst = digit;
        digit /= 10;
        int cnt = 2;
        while(digit != 0){
            rst = rst + cnt * digit;
            digit /= 10;
            cnt++;
        }
        return rst;
    }
    
    private int fillOnes(int digit){
        int rst = digit;
        digit /= 10;
        while(digit != 0){
            rst = rst + digit;
            digit /= 10;
        }
        return rst;
    }
    
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> rst = new ArrayList<>();
        int digit = 1;
        int ones = 1;
        int first = 1;
        int cnt = 2;
        
        //1)
        while(low / digit != 0){
            digit *= 10;
            ones = ones * 10 + 1;
            first = first*10+cnt++;
        }
        ones /= 10;
        first /= 10;
        
        while(first < low){
            first += ones;
        }
        
        //2)
        int max = max(digit);
        if(first > max){
            first = fillSeq(digit);
            ones = fillOnes(digit);
            digit *= 10;
        }
        
        //3)
        while(first < high){
            rst.add(first);
            first += ones;
            
            if(first % 10 == 0){
                first = fillSeq(digit);
                ones = fillOnes(digit);
                digit *= 10;
            }
        }
        
        return rst;
    }
}
