package julyChallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CanMakeArithmeticProgressionFromSequence1502 {

	//<����Ǯ��1>
	
	//Runtime: 1 ms, faster than 100.00% of Java online submissions for Can Make Arithmetic Progression From Sequence.
	//Memory Usage: 38.8 MB, less than 100.00% of Java online submissions for Can Make Arithmetic Progression From Sequence.
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int gap = arr[1]-arr[0];
        for(int i = 2; i < arr.length; i++){
            if(arr[i]-arr[i-1] != gap) return false;
        }
        return true;
    }
    
    //<����Ǯ��2 by rock>
    
    //��ó�� Ǫ�°� �� ���� ���ɵ� ������, �ٸ�������� Ǭ ����� �־ �����ͺ�.
    
    //arr���� ��ū�ֶ� �����ָ� ���ϰ�, ���� ���̸� ����. ��� element�� set�� �ְ�.
    
    //max-min�Ѱ� n-1�� ������, arr�ֵ��� ��� ���̰� ��.
    
    //�������, [1,3,5]���� max=5, min=1, n(arr.length) = 3�ε�,
    
    //diff(max-min) = 4�̰�,
    
    //1->3�Ҷ� �ѹ�, 3->5���� �ѹ� �� 2��(n-1)�� ������ 2, �̰� element�� ��� ������.
    
    //diff % (n-1) != 0, return false��, ��� element�� ������ �������� ������ ���� �ʴٸ�, �������� �������ۿ� ��� �׷���,
    
    //set�� ���� �� ������, ���� �� �ٸ��ֵ��ε� �γ� duplicate�̸� ��¥�� diff%(n-1) != 0, return false���� �ɷ�����
    
    //set.contains(minimum number)�� Ȱ���ϱ� ����.
    
    //Runtime: 2 ms, faster than 100.00% of Java online submissions for Can Make Arithmetic Progression From Sequence.
    //Memory Usage: 39.5 MB, less than 100.00% of Java online submissions for Can Make Arithmetic Progression From Sequence.
    
    public boolean canMakeArithmeticProgression(int[] arr) {
        Set<Integer> s = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        for(int e : arr){
            s.add(e);
            if(e < min) min = e;
            if(e > max) max = e;
        }
        
        int diff = max-min;
        
        if (diff % (n - 1) != 0) {
            return false;
        }
        
        diff /= (n - 1);
        
        while (--n > 0) {
            if (!s.contains(min)) {
                return false;
            }
            min += diff;
        }
        return true;
    }
}
